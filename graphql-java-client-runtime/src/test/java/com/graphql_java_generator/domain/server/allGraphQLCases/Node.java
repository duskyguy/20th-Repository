/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.UUID;

import com.graphql_java_generator.annotation.GraphQLInterfaceType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInterfaceType("Node")
public interface Node {

	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	public void setId(UUID id);

	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = UUID.class)
	public UUID getId();
}