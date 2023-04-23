/**
 * 
 */
package com.graphql_java_generator.plugin.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains all parameters for the <I>generateClientCode</I> goal/task.
 * 
 * @author etienne-sf
 */
public interface GenerateClientCodeConfiguration extends GenerateCodeCommonConfiguration {

	// The String constant must be a constant expression, for use in the GraphqlMavenPlugin class.
	// So all these are String, including Boolean and Enum. Boolean are either "true" or "false"
	public final String DEFAULT_GENERATE_DEPRECATED_REQUEST_RESPONSE = "false";

	/**
	 * <P>
	 * <I>Since 1.7.1 version</I>
	 * </P>
	 * <P>
	 * Generates a XxxxResponse class for each query/mutation/subscription, and (if separateUtilityClasses is true) Xxxx
	 * classes in the util subpackage. This allows to keep compatibility with code Developed with the 1.x versions of
	 * the plugin.
	 * </P>
	 * <P>
	 * The best way to use the plugin is to directly use the Xxxx query/mutation/subscription classes, where Xxxx is the
	 * query/mutation/subscription name defined in the GraphQL schema.
	 * </P>
	 */
	public boolean isGenerateDeprecatedRequestResponse();

	/**
	 * {@inheritDoc}
	 * <P>
	 * In client mode, the <A HREF="https://github.com/FasterXML/jackson">Jackson</A> annotations are always generated
	 * </P>
	 */
	@Override
	default public boolean isGenerateJacksonAnnotations() {
		return true;
	}

	/** Logs all the configuration parameters (only when in the debug level) */
	@Override
	public default void logConfiguration() {
		Logger logger = LoggerFactory.getLogger(getClass());
		if (logger.isDebugEnabled()) {
			logger.debug("-- start configuration --");
			logger.debug("The graphql-java-generator Plugin Configuration for the generateClientCode goal/task is -->");
			logger.debug("    generateDeprecatedRequestResponse: " + isGenerateDeprecatedRequestResponse());
			logGenerateCodeCommonConfiguration();
			logger.debug("-- end configuration --");
		}
	}

}
