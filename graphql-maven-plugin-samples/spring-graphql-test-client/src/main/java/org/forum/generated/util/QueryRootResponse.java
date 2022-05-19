/** Generated by the default template from graphql-java-generator */
package org.forum.generated.util;

import java.util.List;

import org.forum.generated.Query;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.client.response.Error;

public class QueryRootResponse {

	@JsonProperty("data")
	@GraphQLNonScalar(fieldName = "Query", graphQLTypeSimpleName = "Query", javaClass = org.forum.generated.Query.class)
	Query query;

	@JsonProperty("errors")
	@JsonDeserialize(contentAs = Error.class)
	public List<Error> errors;

	@JsonProperty("extensions")
	public JsonNode extensions;

	// This getter is needed for the Json serialization
	public Query getData() {
		return this.query;
	}

	// This setter is needed for the Json deserialization
	public void setData(Query query) {
		this.query = query;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public JsonNode getExtensions() {
		return extensions;
	}

	public void setExtensions(JsonNode extensions) {
		this.extensions = extensions;
	}

}
