/**
 * 
 */
package com.graphql_java_generator.plugin.generate_code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.annotation.PostConstruct;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.TemplateInitException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.graphql_java_generator.plugin.CodeTemplate;
import com.graphql_java_generator.plugin.Generator;
import com.graphql_java_generator.plugin.ResourceSchemaStringProvider;
import com.graphql_java_generator.plugin.conf.GenerateClientCodeConfiguration;
import com.graphql_java_generator.plugin.conf.GenerateCodeCommonConfiguration;
import com.graphql_java_generator.plugin.conf.GenerateGraphQLSchemaConfiguration;
import com.graphql_java_generator.plugin.conf.GeneratePojoConfiguration;
import com.graphql_java_generator.plugin.conf.PluginMode;
import com.graphql_java_generator.plugin.generate_schema.GenerateGraphQLSchema;
import com.graphql_java_generator.plugin.language.DataFetchersDelegate;
import com.graphql_java_generator.plugin.language.Type;
import com.graphql_java_generator.util.GraphqlUtils;
import com.graphql_java_generator.util.VelocityUtils;

/**
 * This class generates the code for the graphql goals/tasks of the plugin, from the classes coming from the
 * com.graphql_java_generator.plugin.language package. This classes have been created by {link
 * {@link GenerateCodeDocumentParser}.<BR/>
 * This class should not be used directly. Please use the {@link GenerateCodePluginExecutor} instead.
 * 
 * @author etienne-sf
 */
@Component
public class GenerateCodeGenerator implements Generator {

	private static final Logger logger = LoggerFactory.getLogger(GenerateCodeGenerator.class);

	private final static String COMMON_RUNTIME_SOURCE_FILENAME = "/graphql-java-common-runtime-sources.jar";
	private final static String CLIENT_RUNTIME_SOURCE_FILENAME = "/graphql-java-client-runtime-sources.jar";
	private final static String SERVER_RUNTIME_SOURCE_FILENAME = "/graphql-java-server-runtime-sources.jar";

	private final static String CLIENT_SPRING_AUTO_CONFIGURATION_CLASS = "GraphQLMavenPluginAutoConfiguration";

	@Autowired
	GenerateCodeDocumentParser generateCodeDocumentParser;

	/**
	 * This instance is responsible for providing all the configuration parameter from the project (Maven, Gradle...)
	 */
	@Autowired
	GenerateCodeCommonConfiguration configuration;

	/** The component that reads the GraphQL schema from the file system */
	@Autowired
	ResourceSchemaStringProvider resourceSchemaStringProvider;

	@Autowired
	GraphqlUtils graphqlUtils;

	/** The Velocity engine, that will merge the templates with their context */
	VelocityEngine velocityEngine = null;

	/** The context for server mode. Stored here, so that it is calculated only once */
	VelocityContext serverContext = null;

	@PostConstruct
	void init() {
		// Initialization for Velocity
		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADERS, "classpath, file");

		// Configuration for 'real' executions of the plugin (that is: from the plugin's packaged jar)
		velocityEngine.setProperty("resource.loader.classpath.description", "Velocity Classpath Resource Loader");
		velocityEngine.setProperty("resource.loader.classpath.class", ClasspathResourceLoader.class.getName());

		// Configuration for the unit tests (that is: from the file system)
		velocityEngine.setProperty("resource.loader.file.description", "Velocity File Resource Loader");
		velocityEngine.setProperty("resource.loader.file.class", FileResourceLoader.class.getName());
		velocityEngine.setProperty("resource.loader.file.path", configuration.getProjectDir().getAbsolutePath());
		velocityEngine.setProperty("resource.loader.file.cache", true);

		velocityEngine.init();
	}

	/**
	 * Execution of the code generation. The generation is done on the data build by the
	 * {@link #generateCodeDocumentParser}
	 * 
	 * @Return The number of generated classes
	 * @throws MojoExecutionException
	 * @throws IOException
	 */
	@Override
	public int generateCode() throws IOException {

		logger.debug("Starting code generation");

		int i = 0;
		logger.debug("Generating objects");
		i += generateTargetFiles(generateCodeDocumentParser.getObjectTypes(), "object",
				resolveTemplate(CodeTemplate.OBJECT), false);
		logger.debug("Generating interfaces");
		i += generateTargetFiles(generateCodeDocumentParser.getInterfaceTypes(), "interface",
				resolveTemplate(CodeTemplate.INTERFACE), false);
		logger.debug("Generating unions");
		i += generateTargetFiles(generateCodeDocumentParser.getUnionTypes(), "union",
				resolveTemplate(CodeTemplate.UNION), false);
		logger.debug("Generating enums");
		i += generateTargetFiles(generateCodeDocumentParser.getEnumTypes(), "enum", resolveTemplate(CodeTemplate.ENUM),
				false);

		switch (configuration.getMode()) {
		case server:
			i += generateServerFiles();
			break;
		case client:
			i += generateClientFiles();
			break;
		}// switch (configuration.getMode())

		if (configuration.isCopyRuntimeSources()) {
			copyRuntimeSources();
		}
		logger.info(i + " java classes have been generated from the schema(s) '" + configuration.getSchemaFilePattern()
				+ "' in the package '" + configuration.getPackageName() + "'");
		return i;
	}

	private int generateClientFiles() throws IOException {
		int i = 0;
		logger.debug("Starting client specific code generation");

		// Custom Deserializers and array deserialization (always generated)
		VelocityContext context = getVelocityContext();
		context.put("customDeserializers", generateCodeDocumentParser.getCustomDeserializers());
		context.put("customSerializers", generateCodeDocumentParser.getCustomSerializers());

		if (configuration.isGenerateJacksonAnnotations()) {
			i += generateOneFile(getJavaFile("CustomJacksonDeserializers", true), "Generating custom deserializers",
					context, resolveTemplate(CodeTemplate.JACKSON_DESERIALIZERS));
			i += generateOneFile(getJavaFile("CustomJacksonSerializers", true), "Generating custom serializers",
					context, resolveTemplate(CodeTemplate.JACKSON_SERIALIZERS));
		}

		if (configuration.isGenerateUtilityClasses()) {

			// Generation of the query/mutation/subscription classes
			if (((GenerateClientCodeConfiguration) configuration).isGenerateDeprecatedRequestResponse()) {
				// We generate these utility classes only when asked for
				logger.debug("Generating query");
				i += generateTargetFile(generateCodeDocumentParser.getQueryType(), "query",
						resolveTemplate(CodeTemplate.QUERY_MUTATION), true);
				logger.debug("Generating mutation");
				i += generateTargetFile(generateCodeDocumentParser.getMutationType(), "mutation",
						resolveTemplate(CodeTemplate.QUERY_MUTATION), true);
				logger.debug("Generating subscription");
				i += generateTargetFile(generateCodeDocumentParser.getSubscriptionType(), "subscription",
						resolveTemplate(CodeTemplate.SUBSCRIPTION), true);
			}

			// Generation of the query/mutation/subscription executor classes
			logger.debug("Generating query executors");
			i += generateTargetFile(generateCodeDocumentParser.getQueryType(), "executor",
					resolveTemplate(CodeTemplate.QUERY_MUTATION_EXECUTOR), true);
			logger.debug("Generating mutation executors");
			i += generateTargetFile(generateCodeDocumentParser.getMutationType(), "executor",
					resolveTemplate(CodeTemplate.QUERY_MUTATION_EXECUTOR), true);
			logger.debug("Generating subscription executors");
			i += generateTargetFile(generateCodeDocumentParser.getSubscriptionType(), "executor",
					resolveTemplate(CodeTemplate.SUBSCRIPTION_EXECUTOR), true);

			// Generation of the query/mutation/subscription response classes
			if (((GenerateClientCodeConfiguration) configuration).isGenerateDeprecatedRequestResponse()) {
				logger.debug("Generating query response");
				i += generateTargetFile(generateCodeDocumentParser.getQueryType(), "response",
						resolveTemplate(CodeTemplate.QUERY_RESPONSE), true);
				logger.debug("Generating mutation response");
				i += generateTargetFile(generateCodeDocumentParser.getMutationType(), "response",
						resolveTemplate(CodeTemplate.QUERY_RESPONSE), true);
				logger.debug("Generating subscription response");
				i += generateTargetFile(generateCodeDocumentParser.getSubscriptionType(), "response",
						resolveTemplate(CodeTemplate.QUERY_RESPONSE), true);
			}

			// Generation of the query/mutation/subscription root responses classes
			logger.debug("Generating query root response");
			i += generateTargetFile(generateCodeDocumentParser.getQueryType(), "root response",
					resolveTemplate(CodeTemplate.ROOT_RESPONSE), true);
			logger.debug("Generating mutation root response");
			i += generateTargetFile(generateCodeDocumentParser.getMutationType(), "root response",
					resolveTemplate(CodeTemplate.ROOT_RESPONSE), true);
			logger.debug("Generating subscription root response");
			i += generateTargetFile(generateCodeDocumentParser.getSubscriptionType(), "root response",
					resolveTemplate(CodeTemplate.ROOT_RESPONSE), true);

			// Generation of the GraphQLRequest class
			logger.debug("Generating GraphQL Request class");
			i += generateGraphQLRequest();

			// Generation of the Spring Configuration class, that is specific to this GraphQL schema
			logger.debug("Generating SpringConfig");
			i += generateOneFile(
					getJavaFile(CLIENT_SPRING_AUTO_CONFIGURATION_CLASS
							+ (configuration.getSpringBeanSuffix() == null ? "" : configuration.getSpringBeanSuffix()),
							true),
					"generating SpringConfiguration", context,
					resolveTemplate(CodeTemplate.SPRING_AUTO_CONFIGURATION_CLASS));

			// Files for Custom Scalars
			logger.debug("Generating CustomScalarRegistryInitializer");
			i += generateOneFile(getJavaFile("CustomScalarRegistryInitializer", true),
					"Generating CustomScalarRegistryInitializer", getVelocityContext(),
					resolveTemplate(CodeTemplate.CUSTOM_SCALAR_REGISTRY_INITIALIZER));

			// Files for Directives
			logger.debug("Generating DirectiveRegistryInitializer");
			i += generateOneFile(getJavaFile("DirectiveRegistryInitializer", true),
					"Generating DirectiveRegistryInitializer", getVelocityContext(),
					resolveTemplate(CodeTemplate.DIRECTIVE_REGISTRY_INITIALIZER));

			// Spring auto-configuration management
			logger.debug("Generating Spring auto-configuration generation");
			i += generateSpringAutoConfigurationDeclaration();
		}

		logger.debug("Generating client side mapping from graphql type to java type");
		i += generateClientTypeMapping();

		return i;
	}

	/**
	 * Generate a class for mapping from graphql types to client java classes.
	 *
	 * @return
	 */
	private int generateClientTypeMapping() {
		VelocityContext context = getVelocityContext();
		context.put("types", generateCodeDocumentParser.getTypes());

		generateOneFile(getJavaFile("GraphQLTypeMapping", false), "generating GraphQLTypeMapping", context,
				resolveTemplate(CodeTemplate.TYPE_MAPPING));

		return 1;
	}

	/**
	 * Generates the Spring auto-configuration file (META-INF/spring.factories), or update it to declare the
	 * SpringAutoConfiguration for this generation
	 * 
	 * @return
	 * @throws IOException
	 */
	private int generateSpringAutoConfigurationDeclaration() throws IOException {
		String springAutoConfigurationPath = "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports";
		File springFactories = new File(configuration.getTargetResourceFolder(), springAutoConfigurationPath);
		String autoConfClass = configuration.getSpringAutoConfigurationPackage() + "."
				+ CLIENT_SPRING_AUTO_CONFIGURATION_CLASS
				+ (configuration.getSpringBeanSuffix() == null ? "" : configuration.getSpringBeanSuffix());
		Set<String> autoConfClasses = new TreeSet<>();
		autoConfClasses.add(autoConfClass);
		if (springFactories.exists()) {
			String line;
			springFactories.getParentFile().mkdirs();
			try (BufferedReader br = new BufferedReader(new FileReader(springFactories))) {
				while ((line = br.readLine()) != null) {
					if (line.equals(autoConfClass)) {
						// The auto configuration class is already defined there. There is nothing to do
						return 0;
					}
					autoConfClasses.add(line);
				}
			}
		}

		VelocityContext context = getVelocityContext();
		context.put("springAutoConfigurationClasses", String.join("\n", autoConfClasses));
		generateOneFile(getResourceFile(springAutoConfigurationPath), "Generating " + springAutoConfigurationPath,
				context, resolveTemplate(CodeTemplate.SPRING_AUTOCONFIGURATION_DEFINITION_FILE));

		return 1;
	}

	void copyRuntimeSources() throws IOException {
		final int NB_BYTES = 1000;
		JarEntry entry;
		java.io.File file;
		String targetFilename;
		int nbBytesRead;
		byte[] bytes = new byte[NB_BYTES];

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Step 1 : the common runtime
		try (JarInputStream jar = new JarInputStream(
				new ClassPathResource(COMMON_RUNTIME_SOURCE_FILENAME).getInputStream())) {
			while ((entry = jar.getNextJarEntry()) != null) {

				// Folders are ignored here.
				if (entry.isDirectory())
					continue;

				// We skip the /META-INF/ folder that just contains the MANIFEST file
				if (entry.getName().startsWith("META-INF") || entry.getName().equals("java/")
						|| entry.getName().equals("resources/")) {
					continue;
				}
				if (!entry.getName().startsWith("resources") && !entry.getName().startsWith("java")) {
					throw new RuntimeException("The entries in the '" + COMMON_RUNTIME_SOURCE_FILENAME
							+ "' file should start either by 'java' or by 'resources', but this entry doesn't: "
							+ entry.getName());
				}

				targetFilename = entry.getName().substring("java".length() + 1);

				boolean copyFile = true;// Default is to copy the file
				if (configuration instanceof GeneratePojoConfiguration) {
					// if the goal/task is generatePojo, then only part of the dependencies should be copied.
					copyFile = targetFilename.startsWith("com/graphql_java_generator/annotation");
				}

				if (copyFile) {
					file = new java.io.File(configuration.getTargetSourceFolder(), targetFilename);

					file.getParentFile().mkdirs();
					try (OutputStream fos = new FileOutputStream(file)) {
						while ((nbBytesRead = jar.read(bytes, 0, bytes.length)) > 0) {
							fos.write(bytes, 0, nbBytesRead);
						}
					}
				}
			}
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Step 2 : the client runtime
		if (configuration.getMode().equals(PluginMode.client)) {
			try (JarInputStream jar = new JarInputStream(
					new ClassPathResource(CLIENT_RUNTIME_SOURCE_FILENAME).getInputStream())) {
				while ((entry = jar.getNextJarEntry()) != null) {

					// Folders are ignored here.
					if (entry.isDirectory())
						continue;

					// We skip the /META-INF/ folder that just contains the MANIFEST file
					if (entry.getName().startsWith("META-INF") || entry.getName().equals("java/")
							|| entry.getName().equals("resources/")) {
						continue;
					}
					if (!entry.getName().startsWith("resources") && !entry.getName().startsWith("java")) {
						throw new RuntimeException("The entries in the '" + CLIENT_RUNTIME_SOURCE_FILENAME
								+ "' file should start either by 'java' or by 'resources', but this entry doesn't: "
								+ entry.getName());
					}

					boolean resources = entry.getName().startsWith("resources");
					if (resources) {
						targetFilename = entry.getName().substring("resources".length() + 1);
					} else {
						targetFilename = entry.getName().substring("java".length() + 1);
					}

					boolean copyFile = true;// Default is to copy the file
					if (configuration instanceof GeneratePojoConfiguration) {
						// if the goal/task is generatePojo, then only part of the dependencies should be copied.
						copyFile = targetFilename.startsWith("com/graphql_java_generator/annotation")
								|| (configuration.isGenerateJacksonAnnotations() && //
										(targetFilename
												.startsWith("com/graphql_java_generator/client/GraphQLRequestObject")
												|| targetFilename.contains("AbstractCustomJacksonSerializer")
												|| targetFilename.contains("AbstractCustomJacksonDeserializer")));
					}

					if (copyFile) {
						if (resources)
							file = new java.io.File(configuration.getTargetResourceFolder(), targetFilename);
						else
							file = new java.io.File(configuration.getTargetSourceFolder(), targetFilename);

						file.getParentFile().mkdirs();
						try (OutputStream fos = new FileOutputStream(file)) {
							while ((nbBytesRead = jar.read(bytes, 0, bytes.length)) > 0) {
								fos.write(bytes, 0, nbBytesRead);
							}
						}
					}
				}
			}
		} // if (mode==client)

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Step3 : the server runtime
		if (configuration.getMode().equals(PluginMode.server)) {
			try (JarInputStream jar = new JarInputStream(
					new ClassPathResource(SERVER_RUNTIME_SOURCE_FILENAME).getInputStream())) {
				while ((entry = jar.getNextJarEntry()) != null) {

					// Folders are ignored here.
					if (entry.isDirectory())
						continue;

					// We skip the /META-INF/ folder that just contains the MANIFEST file
					if (entry.getName().startsWith("META-INF") || entry.getName().equals("java/")
							|| entry.getName().equals("resources/")) {
						continue;
					}
					if (!entry.getName().startsWith("resources") && !entry.getName().startsWith("java")) {
						throw new RuntimeException("The entries in the '" + SERVER_RUNTIME_SOURCE_FILENAME
								+ "' file should start either by 'java' or by 'resources', but this entry doesn't: "
								+ entry.getName());
					}

					targetFilename = entry.getName().substring("java".length() + 1);

					boolean copyFile = true; // Default is to copy the file
					if (configuration instanceof GeneratePojoConfiguration) {
						// if the goal/task is generatePojo, then only part of the dependencies should be copied.
						copyFile = targetFilename.startsWith("com/graphql_java_generator/annotation")
								|| (configuration.isGenerateJacksonAnnotations() && //
										(targetFilename
												.startsWith("com/graphql_java_generator/client/GraphQLRequestObject")
												|| targetFilename.contains("AbstractCustomJacksonSerializer")
												|| targetFilename.contains("AbstractCustomJacksonDeserializer")));
					}

					if (copyFile) {
						file = new java.io.File(configuration.getTargetSourceFolder(), targetFilename);

						file.getParentFile().mkdirs();
						try (OutputStream fos = new FileOutputStream(file)) {
							while ((nbBytesRead = jar.read(bytes, 0, bytes.length)) > 0) {
								fos.write(bytes, 0, nbBytesRead);
							}
						}
					}
				}
			}
		} // if (server mode)
	}

	/**
	 * Utility method to centralize the common actions around the file generation.
	 * 
	 * @param objects
	 *            The list of objects to send to the template
	 * @param type
	 *            The kind of graphql object (object, query, mutation...), just for proper logging
	 * @param templateFilename
	 *            The absolute path for the template (or relative to the current path)
	 * @param utilityClass
	 *            true if this class is a utility class, false if it is not. A utility class it a class the is not
	 *            directly the transposition of an item in the GraphQL schema (like object, interface, union, query...)
	 * @throws IOException
	 */
	int generateTargetFiles(List<? extends Type> objects, String type, String templateFilename, boolean utilityClass)
			throws RuntimeException {
		int ret = 0;
		for (Type object : objects) {
			ret += generateTargetFile(object, type, templateFilename, utilityClass);
		}
		return ret;
	}

	/**
	 * Utility method to centralize the common actions around the file generation.
	 * 
	 * @param object
	 *            The object to send to the template. It can be null, in which case the method doesn't do anything, and
	 *            just return 0.
	 * @param type
	 *            The kind of graphql object (object, query, mutation...), just for proper logging
	 * @param templateFilename
	 *            The absolute path for the template (or relative to the current path)
	 * @param utilityClass
	 *            true if this class is a utility class, false if it is not. A utility class it a class the is not
	 *            directly the transposition of an item in the GraphQL schema (like object, interface, union, query...)
	 * @return 1 if one file was generated, or 0 if object is null.
	 */
	int generateTargetFile(Type object, String type, String templateFilename, boolean utilityClass) {
		if (object == null) {
			return 0;
		} else {
			String targetFileName = (String) execWithOneStringParam("getTargetFileName", object, type);
			if (type.equals("executor") && configuration.getSpringBeanSuffix() != null) {
				targetFileName += configuration.getSpringBeanSuffix();
			}
			File targetFile = getJavaFile(targetFileName, utilityClass);
			String msg = "Generating " + type + " '" + object.getName() + "' into " + targetFile.getAbsolutePath();

			VelocityContext context = getVelocityContext();
			context.put("object", object);
			context.put("targetFileName", targetFileName);
			context.put("type", type);

			generateOneFile(targetFile, msg, context, templateFilename);
			return 1;
		}
	}

	/**
	 * Generates the GraphQLRequest class . This method expects at most one query, one mutation and one subscription,
	 * which is compliant with the GraphQL specification
	 */
	int generateGraphQLRequest() {
		VelocityContext context = getVelocityContext();

		context.put("query", generateCodeDocumentParser.getQueryType());
		context.put("mutation", generateCodeDocumentParser.getMutationType());
		context.put("subscription", generateCodeDocumentParser.getSubscriptionType());

		return generateOneFile(getJavaFile(//
				(configuration.getSpringBeanSuffix() == null) ? "GraphQLRequest"
						: "GraphQLRequest" + configuration.getSpringBeanSuffix(), //
				true), "generating GraphQLRequest", context, resolveTemplate(CodeTemplate.GRAPHQL_REQUEST));
	}

	/**
	 * Generates the server classes
	 * 
	 * @return The number of classes created, that is: 1
	 * @throws IOException
	 */
	int generateServerFiles() throws IOException {
		int ret = 0;
		logger.debug("Starting server specific code generation");

		if (configuration.isGenerateUtilityClasses()) {
			logger.debug("Generating server utility classes");

			VelocityContext context = getVelocityServerContext();

			// List of found schemas
			List<String> schemaFiles = new ArrayList<>();
			for (org.springframework.core.io.Resource res : resourceSchemaStringProvider.schemas(false)) {
				schemaFiles.add(res.getFilename());
			}
			context.put("schemaFiles", schemaFiles);

			logger.debug("Generating GraphQLServerMain");
			ret += generateOneFile(getJavaFile("GraphQLServerMain", true), "generating GraphQLServerMain", context,
					resolveTemplate(CodeTemplate.SERVER));

			logger.debug("Generating GraphQLWiring");
			ret += generateOneFile(getJavaFile("GraphQLWiring", true), "generating GraphQLWiring", context,
					resolveTemplate(CodeTemplate.WIRING));

			for (DataFetchersDelegate dataFetcherDelegate : generateCodeDocumentParser.dataFetchersDelegates) {
				context.put("dataFetchersDelegate", dataFetcherDelegate);
				context.put("dataFetchersDelegates", generateCodeDocumentParser.getDataFetchersDelegates());
				context.put("batchLoaders", generateCodeDocumentParser.getBatchLoaders());

				String entityControllerName = graphqlUtils.getJavaName(dataFetcherDelegate.getType().getName())
						+ "Controller";
				logger.debug("Generating " + entityControllerName);
				ret += generateOneFile(getJavaFile(entityControllerName, true), "generating " + entityControllerName,
						context, resolveTemplate(CodeTemplate.ENTITY_CONTROLLER));

				logger.debug("Generating " + dataFetcherDelegate.getPascalCaseName());
				ret += generateOneFile(getJavaFile(dataFetcherDelegate.getPascalCaseName(), true),
						"generating " + dataFetcherDelegate.getPascalCaseName(), context,
						resolveTemplate(CodeTemplate.DATA_FETCHER_DELEGATE));
			}
		}

		// We're in server mode. So, When the addRelayConnections parameter is true, we must generate the resulting
		// GraphQL schema, so that the graphql-java can access it at runtime.
		// Otherwise, we just need to copy the schema file to the ./graphql folder, so that spring-graphql can find
		// them.
		if (!configuration.isAddRelayConnections()) {
			copySchemaFilesToGraphqlFolder();
		} else {
			GenerateGraphQLSchemaConfiguration generateGraphQLSchemaConf = new GenerateGraphQLSchemaConfiguration() {

				@Override
				public Integer getMaxTokens() {
					return configuration.getMaxTokens();
				}

				@Override
				public File getProjectDir() {
					return configuration.getProjectDir();
				}

				@Override
				public File getSchemaFileFolder() {
					return configuration.getSchemaFileFolder();
				}

				@Override
				public String getSchemaFilePattern() {
					return configuration.getSchemaFilePattern();
				}

				@Override
				public Map<String, String> getTemplates() {
					return configuration.getTemplates();
				}

				@Override
				public boolean isAddRelayConnections() {
					return configuration.isAddRelayConnections();
				}

				@Override
				public String getTypePrefix() {
					return configuration.getTypePrefix();
				}

				@Override
				public String getTypeSuffix() {
					return configuration.getTypeSuffix();
				}

				@Override
				public String getInputPrefix() {
					return configuration.getInputPrefix();
				}

				@Override
				public String getInputSuffix() {
					return configuration.getInputSuffix();
				}

				@Override
				public String getUnionPrefix() {
					return configuration.getUnionPrefix();
				}

				@Override
				public String getUnionSuffix() {
					return configuration.getUnionSuffix();
				}

				@Override
				public String getInterfacePrefix() {
					return configuration.getInterfacePrefix();
				}

				@Override
				public String getInterfaceSuffix() {
					return configuration.getInterfaceSuffix();
				}

				@Override
				public String getEnumPrefix() {
					return configuration.getEnumPrefix();
				}

				@Override
				public String getEnumSuffix() {
					return configuration.getEnumSuffix();
				}

				@Override
				public String getResourceEncoding() {
					return "UTF-8";
				}

				@Override
				public File getTargetFolder() {
					return new File(configuration.getTargetResourceFolder(), configuration.getTargetSchemaSubFolder());
				}

				@Override
				public String getTargetSchemaFileName() {
					return GenerateGraphQLSchemaConfiguration.DEFAULT_TARGET_SCHEMA_FILE_NAME;
				}

				@Override
				public String getDefaultTargetSchemaFileName() {
					return DEFAULT_TARGET_SCHEMA_FILE_NAME;
				}

				@Override
				public boolean isSkipGenerationIfSchemaHasNotChanged() {
					// If we're here, it means the the code generation is done. So the addRelayConnection schema
					// must be
					// always created. We won't skip it.
					return false;
				}
			};
			GenerateGraphQLSchema generateGraphQLSchema = new GenerateGraphQLSchema(generateCodeDocumentParser,
					graphqlUtils, generateGraphQLSchemaConf, resourceSchemaStringProvider);
			generateGraphQLSchema.generateGraphQLSchema();
		}

		return ret;

	}

	/**
	 * This method makes sure that the schema files are available to spring-graphql at runtime. So either the schema
	 * files are in the src/main/resources/graphql folder of the current project, or they will be copied into the
	 * {generatesResource}/graphql folder. <br/>
	 * This is useful only for the server mode.
	 * 
	 * @throws IOException
	 */
	private void copySchemaFilesToGraphqlFolder() throws IOException {
		String standardSpringGraphqlSchemaPath = new File(configuration.getProjectDir(), "src/main/resources/graphql")
				.getCanonicalPath();
		if (!configuration.getSchemaFileFolder().getCanonicalPath().equals(standardSpringGraphqlSchemaPath)) {
			// The schema file(s) is(are) not where spring-graphql expects it (that is in the graphql of the
			// classpath).
			// So we copy it/them in the correct location
			for (Resource r : resourceSchemaStringProvider.schemas(false)) {
				File folder = new File(configuration.getTargetResourceFolder(),
						configuration.getTargetSchemaSubFolder());
				File f = new File(folder, r.getFilename());

				logger.debug("Copying {} from  {} to {}", r.getFilename(), r.getFile().getAbsolutePath(),
						f.getAbsolutePath());

				f.getParentFile().mkdirs();
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(f, false))) {
					writer.append(resourceSchemaStringProvider.readSchema(r));
				}
			}
		}
	}

	/**
	 * Generates one file from the given parameter, based on a Velocity context and template.
	 * 
	 * @param targetFile
	 *            The file to be generated. It will be either created or rewrited
	 * @param msg
	 *            A log message. It will be logged in debug mode, or send as the error message if an exception is
	 *            raised.
	 * @param context
	 *            The Velocity context
	 * @param templateFilename
	 *            The Velocity template
	 * @return The number of classes created, that is: 1
	 */
	int generateOneFile(File targetFile, String msg, VelocityContext context, String templateFilename) {
		try {
			Writer writer = null;
			logger.debug(msg);

			Template template = velocityEngine.getTemplate(templateFilename, "UTF-8");

			targetFile.getParentFile().mkdirs();
			try {
				if (configuration.getSourceEncoding() != null) {
					writer = new OutputStreamWriter(new FileOutputStream(targetFile),
							Charset.forName(configuration.getSourceEncoding()));
				} else {
					writer = new OutputStreamWriter(new FileOutputStream(targetFile));
				}
				template.merge(context, writer);
				writer.flush();
			} finally {
				if (writer != null) {
					writer.close();
				}
			}

			// Let's return the number of created files. That is: 1.
			// Not very useful. But it helps making simpler the code of the caller for this
			// method
			return 1;
		} catch (ResourceNotFoundException | ParseErrorException | TemplateInitException | MethodInvocationException
				| IOException e) {
			throw new RuntimeException("Error when " + msg, e);
		}
	}

	/**
	 * This method returns the {@link File} where the class is to be generated. It adds the preceding path, and the
	 * suffix ".java" to the given parameter.
	 * 
	 * @param simpleClassname
	 *            The classname, without the package
	 * @param utilityClass
	 *            true if this class is a utility class, false if it is not. A utility class it a class the is not
	 *            directly the transposition of an item in the GraphQL schema (like object, interface, union, query...)
	 * @return
	 */
	File getJavaFile(String simpleClassname, boolean utilityClass) {
		String packageName;

		if (simpleClassname.startsWith(CLIENT_SPRING_AUTO_CONFIGURATION_CLASS)) {
			packageName = configuration.getSpringAutoConfigurationPackage();
		} else {
			packageName = (utilityClass && configuration.isSeparateUtilityClasses())
					? generateCodeDocumentParser.getUtilPackageName()
					: configuration.getPackageName();
		}

		String relativePath = packageName.replace('.', '/') + '/' + simpleClassname + ".java";
		File file = new File(configuration.getTargetSourceFolder(), relativePath);
		file.getParentFile().mkdirs();
		return file;
	}

	/**
	 * This method returns the {@link File} where this resource must be generated. It adds the preceding path, and
	 * creates the missing folders, if any
	 * 
	 * @param filename
	 *            The relative filename, starting from the root of the class file (for instance:
	 *            META-INF/spring.factories)
	 * @return
	 */
	File getResourceFile(String filename) {
		File file = new File(configuration.getTargetResourceFolder(), filename);
		file.getParentFile().mkdirs();
		return file;
	}

	/**
	 * Calls the 'methodName' method on the given object
	 * 
	 * @param methodName
	 *            The name of the method name
	 * @param object
	 *            The given node, on which the 'methodName' method is to be called
	 * @return
	 */
	Object exec(String methodName, Object object) {
		try {
			Method getType = object.getClass().getMethod(methodName);
			return getType.invoke(object);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new RuntimeException("Error when trying to execute '" + methodName + "' on '"
					+ object.getClass().getName() + "': " + e.getMessage(), e);
		}
	}

	/**
	 * Calls the 'methodName' method on the given object
	 * 
	 * @param methodName
	 *            The name of the method name
	 * @param object
	 *            The given node, on which the 'methodName' method is to be called
	 * @return
	 */
	Object execWithOneStringParam(String methodName, Object object, String param) {
		try {
			Method getType = object.getClass().getMethod(methodName, String.class);
			return getType.invoke(object, param);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			throw new RuntimeException("Error when trying to execute '" + methodName + "' (with a String param) on '"
					+ object.getClass().getName() + "': " + e.getMessage(), e);
		}
	}

	/**
	 * Returns a {@link VelocityContext} with all default values filled.
	 * 
	 * @return
	 */
	VelocityContext getVelocityContext() {
		VelocityContext context = new VelocityContext();
		context.put("carriageReturn", "\r");
		context.put("configuration", configuration);
		context.put("dollar", "$");
		context.put("lineFeed", "\n");
		context.put("exceptionThrower", new ExceptionThrower());
		context.put("graphqlUtils", graphqlUtils);
		context.put("javaKeywordPrefix", GraphqlUtils.JAVA_KEYWORD_PREFIX);
		context.put("sharp", "#");
		context.put("velocityUtils", VelocityUtils.velocityUtils);

		// Velocity can't access to enum values. So we add it into the context
		context.put("isPluginModeClient", configuration.getMode() == PluginMode.client);

		context.put("packageUtilName", generateCodeDocumentParser.getUtilPackageName());
		context.put("customScalars", generateCodeDocumentParser.getCustomScalars());
		context.put("directives", generateCodeDocumentParser.getDirectives());
		return context;
	}

	/**
	 * @return
	 */
	private VelocityContext getVelocityServerContext() {
		if (serverContext == null) {
			serverContext = getVelocityContext();
			serverContext.put("dataFetchersDelegates", generateCodeDocumentParser.getDataFetchersDelegates());
			serverContext.put("batchLoaders", generateCodeDocumentParser.getBatchLoaders());
			serverContext.put("interfaces", generateCodeDocumentParser.getInterfaceTypes());
			serverContext.put("unions", generateCodeDocumentParser.getUnionTypes());
		}
		return serverContext;
	}

	/**
	 * Resolves the template for the given key
	 * 
	 * @param templateKey
	 * @param defaultValue
	 * @return
	 */
	protected String resolveTemplate(CodeTemplate template) {
		if (configuration.getTemplates().containsKey(template.name())) {
			return configuration.getTemplates().get(template.name());
		} else {
			return template.getDefaultValue();
		}
	}
}
