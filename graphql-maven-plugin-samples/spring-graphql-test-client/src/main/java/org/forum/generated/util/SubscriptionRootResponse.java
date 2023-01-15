/** Generated by the default template from graphql-java-generator */
package org.forum.generated.util;

import java.util.List;

import org.forum.generated.Subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.client.response.Error;

public class SubscriptionRootResponse {

	@JsonProperty("data")
	@GraphQLNonScalar(fieldName = "Subscription", graphQLTypeSimpleName = "Subscription", javaClass = org.forum.generated.Subscription.class)
	Subscription subscription;

	@JsonProperty("errors")
	@JsonDeserialize(contentAs = Error.class)
	public List<Error> errors;

	@JsonProperty("extensions")
	public JsonNode extensions;

	// This getter is needed for the Json serialization
	public Subscription getData() {
		return this.subscription;
	}

	// This setter is needed for the Json deserialization
	public void setData(Subscription subscription) {
		this.subscription = subscription;
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