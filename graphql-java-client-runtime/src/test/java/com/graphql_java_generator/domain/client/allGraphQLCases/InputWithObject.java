/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.allGraphQLCases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import com.graphql_java_generator.client.GraphQLObjectMapper;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("InputWithObject")
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("unused")
public class InputWithObject {

	/**
	 * This map contains the deserialized values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public InputWithObject() {
		// No action
	}

	@JsonProperty("test")
	@GraphQLScalar(fieldName = "test", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class, listDepth = 0)
	java.lang.String test;

	@JsonProperty("object")
	// @JsonSerialize(using = CustomJacksonSerializers.Object.class)
	@GraphQLScalar(fieldName = "object", graphQLTypeSimpleName = "Object", javaClass = java.lang.Object.class, listDepth = 0)
	java.lang.Object object;

	@JsonProperty("objects")
	// @JsonSerialize(using = CustomJacksonSerializers.ListObject.class)
	@GraphQLScalar(fieldName = "objects", graphQLTypeSimpleName = "Object", javaClass = java.lang.Object.class, listDepth = 1)
	List<java.lang.Object> objects;

	@JsonProperty("test")
	public void setTest(java.lang.String test) {
		this.test = test;
	}

	@JsonProperty("test")
	public java.lang.String getTest() {
		return this.test;
	}

	@JsonProperty("object")
	public void setObject(java.lang.Object object) {
		this.object = object;
	}

	@JsonProperty("object")
	public java.lang.Object getObject() {
		return this.object;
	}

	@JsonProperty("objects")
	public void setObjects(List<java.lang.Object> objects) {
		this.objects = objects;
	}

	@JsonProperty("objects")
	public List<java.lang.Object> getObjects() {
		return this.objects;
	}

	/**
	 * This method is called during the json deserialization process, by the {@link GraphQLObjectMapper}, each time an
	 * alias value is read from the json.
	 * 
	 * @param aliasName
	 * @param aliasDeserializedValue
	 */
	public void setAliasValue(String aliasName, Object aliasDeserializedValue) {
		this.aliasValues.put(aliasName, aliasDeserializedValue);
	}

	/**
	 * Retrieves the value for the given alias, as it has been received for this object in the GraphQL response. <BR/>
	 * This method <B>should not be used for Custom Scalars</B>, as the parser doesn't know if this alias is a custom
	 * scalar, and which custom scalar to use at deserialization time. In most case, a value will then be provided by
	 * this method with a basis json deserialization, but this value won't be the proper custom scalar value.
	 * 
	 * @param alias
	 * @return
	 */
	public Object getAliasValue(String alias) {
		return this.aliasValues.get(alias);
	}

	@Override
	public String toString() {
		return "InputWithObject {" //$NON-NLS-1$
				+ "test: " + this.test //$NON-NLS-1$
				+ ", " //$NON-NLS-1$
				+ "object: " + this.object //$NON-NLS-1$
				+ ", " //$NON-NLS-1$
				+ "objects: " + this.objects //$NON-NLS-1$
				+ "}"; //$NON-NLS-1$
	}

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * The Builder that helps building instance of this POJO. You can get an instance of this class, by calling the
	 * {@link #builder()}
	 */
	public static class Builder {
		private java.lang.String test;
		private java.lang.Object object;
		private List<java.lang.Object> objects;

		public Builder withTest(java.lang.String testParam) {
			this.test = testParam;
			return this;
		}

		public Builder withObject(java.lang.Object objectParam) {
			this.object = objectParam;
			return this;
		}

		public Builder withObjects(List<java.lang.Object> objectsParam) {
			this.objects = objectsParam;
			return this;
		}

		public InputWithObject build() {
			InputWithObject _object = new InputWithObject();
			_object.setTest(this.test);
			_object.setObject(this.object);
			_object.setObjects(this.objects);
			return _object;
		}
	}
}