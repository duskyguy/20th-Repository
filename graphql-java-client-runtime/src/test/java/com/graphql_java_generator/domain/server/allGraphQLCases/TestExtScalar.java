/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 * #############################################################################################################
 * ############## TEST CASE FOR ISSUES #######################################################################
 * #############################################################################################################
 * ############################ test for issue #35
 * 
 * But removed from this GraphQL schema as enum values in Directives are not supported by graphql-java v14.0 on server
 * side It works Ok on client side
 * 
 * directive @relation( name: String direction: direction ) on FIELD_DEFINITION
 * 
 * enum direction { IN OUT } ############################ ############################ test for issue #36
 *
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("TestExtScalar")
public class TestExtScalar {

	public TestExtScalar() {
		// No action
	}

	@GraphQLScalar(fieldName = "bad", graphQLTypeSimpleName = "NonNegativeInt", javaClass = Integer.class)
	Integer bad;

	public void setBad(Integer bad) {
		this.bad = bad;
	}

	public Integer getBad() {
		return bad;
	}

	@Override
	public String toString() {
		return "TestExtScalar {" + "bad: " + bad + "}";
	}

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder
	 */
	public static class Builder {
		private Integer bad;

		public Builder withBad(Integer bad) {
			this.bad = bad;
			return this;
		}

		public TestExtScalar build() {
			TestExtScalar _object = new TestExtScalar();
			_object.setBad(bad);
			return _object;
		}
	}
}