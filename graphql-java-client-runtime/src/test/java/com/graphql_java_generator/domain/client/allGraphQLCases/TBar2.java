/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("TBar2")
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("unused")
public class TBar2 
	implements IBar2, IBar1{


	/**
	 * This map contains the deserialized values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public TBar2(){
		// No action
	}

	@JsonProperty("id")
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = java.lang.String.class)
	java.lang.String id;


	@JsonProperty("__typename")
	@GraphQLScalar(fieldName = "__typename", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String __typename;




	/**
	 */
	@Override
	@JsonIgnore
	public void setId(java.lang.String id) {
		if (id == null || id instanceof java.lang.String) {
			this.id = (java.lang.String) id;
		} else {
			throw new IllegalArgumentException("The given id should be an instance of java.lang.String, but is an instance of "
					+ id.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.lang.String getId() {
		return id;
	}


	/**
	 */
	@Override
	@JsonIgnore
	public void set__typename(java.lang.String __typename) {
		if (__typename == null || __typename instanceof java.lang.String) {
			this.__typename = (java.lang.String) __typename;
		} else {
			throw new IllegalArgumentException("The given __typename should be an instance of java.lang.String, but is an instance of "
					+ __typename.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.lang.String get__typename() {
		return __typename;
	}

 
	/**
	 * This method is called during the json deserialization process, by the {@link GraphQLObjectMapper}, each time an
	 * alias value is read from the json.
	 * 
	 * @param aliasName
	 * @param aliasDeserializedValue
	 */
	public void setAliasValue(String aliasName, Object aliasDeserializedValue) {
		aliasValues.put(aliasName, aliasDeserializedValue);
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
		return aliasValues.get(alias);
	}

    public String toString() {
        return "TBar2 {"
				+ "id: " + id
				+ ", "
				+ "__typename: " + __typename
        		+ "}";
    }

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * The Builder that helps building instance of this POJO. You can get an instance of this class, by calling the
	 * {@link #builder()}
	 */
	public static class Builder {
		private java.lang.String id;

		public Builder withId(java.lang.String id) {
			this.id = id;
			return this;
		}

		public TBar2 build() {
			TBar2 _object = new TBar2();
			_object.setId(id);
			_object.set__typename("TBar2");
			return _object;
		}
	}
}
