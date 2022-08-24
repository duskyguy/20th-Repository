/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import com.graphql_java_generator.annotation.GraphQLInterfaceType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;



/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInterfaceType("IFoo3")
@SuppressWarnings("unused")
public interface IFoo3 extends IFoo1, IFoo2 {

	
	
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = java.util.UUID.class)
	public void setId(java.util.UUID id);

	
	
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = java.util.UUID.class)
	public java.util.UUID getId();

	@GraphQLNonScalar(fieldName = "bar", graphQLTypeSimpleName = "IBar12", javaClass = IBar12.class)
	public void setBar(IBar12 bar);

	@GraphQLNonScalar(fieldName = "bar", graphQLTypeSimpleName = "IBar12", javaClass = IBar12.class)
	public IBar12 getBar();
}
