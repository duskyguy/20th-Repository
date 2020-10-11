##
## Velocity template for the CustomScalarRegistryInitializer (client side). 
##
## The generated class contains the code that registers all the custom scalars in CustomScalarRegistryImpl.customScalarRegistry
##
##
## This template has these inputs:
## packageUtilName
## customScalars
##
/** Generated by the default template from graphql-java-generator */
package ${packageUtilName};

import java.util.UUID;

import com.graphql_java_generator.customscalars.CustomScalarRegistry;
import com.graphql_java_generator.customscalars.CustomScalarRegistryImpl;
import com.graphql_java_generator.customscalars.GraphQLScalarTypeIDClient;
import com.graphql_java_generator.customscalars.GraphQLScalarTypeIDServer;

public class CustomScalarRegistryInitializer {

	/**
	 * Initialization of the {@link CustomScalarRegistry} with all known custom scalars, that is with all custom scalars
	 * defined in the project pom
	 */
	public static CustomScalarRegistry initCustomScalarRegistry() {
		CustomScalarRegistry customScalarRegistry = new CustomScalarRegistryImpl();

#if ($isPluginModeClient)
		// Registering the ID parser, for client mode
		customScalarRegistry.registerGraphQLScalarType(GraphQLScalarTypeIDClient.ID, String.class);		
#else
		// Registering the ID parser, for server mode
		customScalarRegistry.registerGraphQLScalarType(GraphQLScalarTypeIDServer.ID, UUID.class);		
#end

#foreach ($customScalar in $customScalars)
#if (${customScalar.customScalarDefinition.graphQLScalarTypeClass})
		customScalarRegistry.registerGraphQLScalarType(new ${customScalar.customScalarDefinition.graphQLScalarTypeClass}(), ${customScalar.customScalarDefinition.javaType}.class);
#elseif (${customScalar.customScalarDefinition.graphQLScalarTypeStaticField})
		customScalarRegistry.registerGraphQLScalarType(${customScalar.customScalarDefinition.graphQLScalarTypeStaticField}, ${customScalar.customScalarDefinition.javaType}.class);
#elseif (${customScalar.customScalarDefinition.graphQLScalarTypeGetter})
		customScalarRegistry.registerGraphQLScalarType(${customScalar.customScalarDefinition.graphQLScalarTypeGetter}, ${customScalar.customScalarDefinition.javaType}.class);
#else
		customScalarRegistry.registerGraphQLScalarType: ${customScalar.javaName} : you must define one of graphQLScalarTypeClass, graphQLScalarTypeStaticField or graphQLScalarTypeGetter (in the POM parameters for CustomScalars)
#end
#end

		CustomScalarRegistryImpl.customScalarRegistry = customScalarRegistry;
		return customScalarRegistry;
	}

}
