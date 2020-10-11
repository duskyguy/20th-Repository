/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.client.domain.allGraphQLCases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql_java_generator.GraphQLField;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("AllFieldCasesWithIdSubtypeInput")
public class AllFieldCasesWithIdSubtypeInput  {

	public AllFieldCasesWithIdSubtypeInput(){
		// No action
	}

	@JsonProperty("id")
	@GraphQLScalar(list = false, fieldName = "id", graphQLTypeName = "ID", javaClass = String.class)
	String id;


	@JsonProperty("name")
	@GraphQLScalar(list = false, fieldName = "name", graphQLTypeName = "String", javaClass = String.class)
	String name;



	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public String toString() {
        return "AllFieldCasesWithIdSubtypeInput {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
        		+ "}";
    }

    /**
	 * Enum of field names
	 */
	 public static enum Field implements GraphQLField {
		Id("id"),
		Name("name");

		private String fieldName;

		Field(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public Class<?> getGraphQLType() {
			return this.getClass().getDeclaringClass();
		}

	}

	public static Builder builder() {
			return new Builder();
		}



	/**
	 * Builder
	 */
	public static class Builder {
		private String id;
		private String name;


		public Builder withId(String id) {
			this.id = id;
			return this;
		}
		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public AllFieldCasesWithIdSubtypeInput build() {
			AllFieldCasesWithIdSubtypeInput _object = new AllFieldCasesWithIdSubtypeInput();
			_object.setId(id);
			_object.setName(name);
			return _object;
		}
	}
}
