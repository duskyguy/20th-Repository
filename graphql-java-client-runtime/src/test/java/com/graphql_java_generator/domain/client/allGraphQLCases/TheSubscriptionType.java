/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.allGraphQLCases;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLQuery;
import com.graphql_java_generator.annotation.GraphQLScalar;
import com.graphql_java_generator.annotation.RequestType;
import com.graphql_java_generator.client.GraphQLObjectMapper;
import com.graphql_java_generator.client.SubscriptionCallback;
import com.graphql_java_generator.client.SubscriptionClient;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;

/**
 * This class contains the response for a full request. See the
 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client_subscription.html">plugin web
 * site</A> for more information on full and partial requests.<BR/>
 * It also allows access to the _extensions_ part of the response. Take a look at the
 * <A HRE="https://spec.graphql.org/June2018/#sec-Response">GraphQL spec</A> for more information on this.
 * 
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLQuery(name = "TheSubscriptionType", type = RequestType.subscription)
@GraphQLObjectType("TheSubscriptionType")
public class TheSubscriptionType extends TheSubscriptionTypeExecutor
		implements com.graphql_java_generator.client.GraphQLRequestObject {

	private GraphQLObjectMapper extensionMapper = null;
	private JsonNode extensions;
	private Map<String, JsonNode> extensionsAsMap = null;

	/**
	 * This map contains the deserialiazed values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public TheSubscriptionType() {
		// No action
	}

	/**
	 * Will be notified for each Human added to this Episode
	 */
	@JsonProperty("subscribeNewHumanForEpisode")
	@GraphQLInputParameters(names = { "episode" }, types = { "Episode" }, mandatories = { true }, listDepths = {
			0 }, itemsMandatory = { false })
	@GraphQLNonScalar(fieldName = "subscribeNewHumanForEpisode", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	Human subscribeNewHumanForEpisode;

	/**
	 * Issue 54
	 */
	@JsonProperty("subscribeToAList")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListInt.class)
	@GraphQLScalar(fieldName = "subscribeToAList", graphQLTypeSimpleName = "Int", javaClass = Integer.class)
	List<Integer> subscribeToAList;

	/**
	 * issue53 is about custom scalars as parameter for a query/mutation/subscription, that was not properly
	 * serialized/deserialized
	 */
	@JsonProperty("issue53")
	@JsonDeserialize(using = CustomJacksonDeserializers.Date.class)
	@GraphQLInputParameters(names = { "date" }, types = { "Date" }, mandatories = { true }, listDepths = {
			0 }, itemsMandatory = { false })
	@GraphQLScalar(fieldName = "issue53", graphQLTypeSimpleName = "Date", javaClass = Date.class)
	Date issue53;

	@JsonProperty("__typename")
	@GraphQLScalar(fieldName = "__typename", graphQLTypeSimpleName = "String", javaClass = String.class)
	String __typename;

	/**
	 * Will be notified for each Human added to this Episode
	 */
	public void setSubscribeNewHumanForEpisode(Human subscribeNewHumanForEpisode) {
		this.subscribeNewHumanForEpisode = subscribeNewHumanForEpisode;
	}

	/**
	 * Will be notified for each Human added to this Episode
	 */
	public Human getSubscribeNewHumanForEpisode() {
		return subscribeNewHumanForEpisode;
	}

	/**
	 * Issue 54
	 */
	public void setSubscribeToAList(List<Integer> subscribeToAList) {
		this.subscribeToAList = subscribeToAList;
	}

	/**
	 * Issue 54
	 */
	public List<Integer> getSubscribeToAList() {
		return subscribeToAList;
	}

	/**
	 * issue53 is about custom scalars as parameter for a query/mutation/subscription, that was not properly
	 * serialized/deserialized
	 */
	public void setIssue53(Date issue53) {
		this.issue53 = issue53;
	}

	/**
	 * issue53 is about custom scalars as parameter for a query/mutation/subscription, that was not properly
	 * serialized/deserialized
	 */
	public Date getIssue53() {
		return issue53;
	}

	public void set__typename(String __typename) {
		this.__typename = __typename;
	}

	public String get__typename() {
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
	 * @throws GraphQLRequestExecutionException
	 *             If the value can not be parsed
	 */
	public Object getAliasValue(String alias) throws GraphQLRequestExecutionException {
		Object value = aliasValues.get(alias);
		if (value instanceof GraphQLRequestExecutionException)
			throw (GraphQLRequestExecutionException) value;
		else
			return value;
	}

	@Override
	public String toString() {
		return "TheSubscriptionType {" + "subscribeNewHumanForEpisode: " + subscribeNewHumanForEpisode + ", "
				+ "subscribeToAList: " + subscribeToAList + ", " + "issue53: " + issue53 + ", " + "__typename: "
				+ __typename + "}";
	}

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder
	 */
	public static class Builder {
		private Human subscribeNewHumanForEpisode;
		private List<Integer> subscribeToAList;
		private Date issue53;

		public Builder withSubscribeNewHumanForEpisode(Human subscribeNewHumanForEpisode) {
			this.subscribeNewHumanForEpisode = subscribeNewHumanForEpisode;
			return this;
		}

		public Builder withSubscribeToAList(List<Integer> subscribeToAList) {
			this.subscribeToAList = subscribeToAList;
			return this;
		}

		public Builder withIssue53(Date issue53) {
			this.issue53 = issue53;
			return this;
		}

		public TheSubscriptionType build() {
			TheSubscriptionType _object = new TheSubscriptionType();
			_object.setSubscribeNewHumanForEpisode(subscribeNewHumanForEpisode);
			_object.setSubscribeToAList(subscribeToAList);
			_object.setIssue53(issue53);
			_object.set__typename("TheSubscriptionType");
			return _object;
		}
	}

	/** {@inheritDoc} */
	public TheSubscriptionType(String graphqlEndpoint) {
		super(graphqlEndpoint);
	}

	/** {@inheritDoc} */
	public TheSubscriptionType(String graphqlEndpoint, SSLContext sslContext, HostnameVerifier hostnameVerifier) {
		super(graphqlEndpoint, sslContext, hostnameVerifier);
	}

	/** {@inheritDoc} */
	public TheSubscriptionType(String graphqlEndpoint, Client client) {
		super(graphqlEndpoint, client);
	}

	private GraphQLObjectMapper getExtensionMapper() {
		if (extensionMapper == null) {
			extensionMapper = new GraphQLObjectMapper("com.graphql_java_generator.domain.client.allGraphQLCases", null);
		}
		return extensionMapper;
	}

	public JsonNode getExtensions() {
		return extensions;
	}

	@Override
	public void setExtensions(JsonNode extensions) {
		this.extensions = extensions;
	}

	/**
	 * Returns the extensions as a map. The values can't be deserialized, as their type is unknown.
	 * 
	 * @return
	 */
	public Map<String, JsonNode> getExtensionsAsMap() {
		if (extensionsAsMap == null) {
			extensionsAsMap = getExtensionMapper().convertValue(extensions, new TypeReference<Map<String, JsonNode>>() {
			});
		}
		return extensionsAsMap;
	}

	/**
	 * Parse the value for the given _key_, as found in the <I>extensions</I> field of the GraphQL server's response,
	 * into the given _t_ class.
	 * 
	 * @param <T>
	 * @param key
	 * @param t
	 * @return null if the key is not in the <I>extensions</I> map. Otherwise: the value for this _key_, as a _t_
	 *         instance
	 * @throws JsonProcessingException
	 *             When there is an error when converting the key's value into the _t_ class
	 */
	public <T> T getExtensionsField(String key, Class<T> t) throws JsonProcessingException {
		JsonNode node = getExtensionsAsMap().get(key);
		return (node == null) ? null : getExtensionMapper().treeToValue(node, t);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeNewHumanForEpisodeWithBindValues(String queryResponseDef,
			SubscriptionCallback<Human> subscriptionCallback, Episode episode, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return super.subscribeNewHumanForEpisodeWithBindValues(queryResponseDef, subscriptionCallback, episode,
				parameters);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeNewHumanForEpisode(String queryResponseDef,
			SubscriptionCallback<Human> subscriptionCallback, Episode episode, Object... paramsAndValues)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return super.subscribeNewHumanForEpisode(queryResponseDef, subscriptionCallback, episode, paramsAndValues);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeNewHumanForEpisodeWithBindValues(ObjectResponse objectResponse,
			SubscriptionCallback<Human> subscriptionCallback, Episode episode, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException {
		return super.subscribeNewHumanForEpisodeWithBindValues(objectResponse, subscriptionCallback, episode,
				parameters);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeNewHumanForEpisode(ObjectResponse objectResponse,
			SubscriptionCallback<Human> subscriptionCallback, Episode episode, Object... paramsAndValues)
			throws GraphQLRequestExecutionException {
		return super.subscribeNewHumanForEpisode(objectResponse, subscriptionCallback, episode, paramsAndValues);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public com.graphql_java_generator.client.request.Builder getSubscribeNewHumanForEpisodeResponseBuilder()
			throws GraphQLRequestPreparationException {
		return super.getSubscribeNewHumanForEpisodeResponseBuilder();
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public GraphQLRequest getSubscribeNewHumanForEpisodeGraphQLRequest(String partialRequest)
			throws GraphQLRequestPreparationException {
		return super.getSubscribeNewHumanForEpisodeGraphQLRequest(partialRequest);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeToAListWithBindValues(String queryResponseDef,
			SubscriptionCallback<List<java.lang.Integer>> subscriptionCallback, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return super.subscribeToAListWithBindValues(queryResponseDef, subscriptionCallback, parameters);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeToAList(String queryResponseDef,
			SubscriptionCallback<List<java.lang.Integer>> subscriptionCallback, Object... paramsAndValues)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return super.subscribeToAList(queryResponseDef, subscriptionCallback, paramsAndValues);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeToAListWithBindValues(ObjectResponse objectResponse,
			SubscriptionCallback<List<java.lang.Integer>> subscriptionCallback, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException {
		return super.subscribeToAListWithBindValues(objectResponse, subscriptionCallback, parameters);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient subscribeToAList(ObjectResponse objectResponse,
			SubscriptionCallback<List<java.lang.Integer>> subscriptionCallback, Object... paramsAndValues)
			throws GraphQLRequestExecutionException {
		return super.subscribeToAList(objectResponse, subscriptionCallback, paramsAndValues);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public com.graphql_java_generator.client.request.Builder getSubscribeToAListResponseBuilder()
			throws GraphQLRequestPreparationException {
		return super.getSubscribeToAListResponseBuilder();
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public GraphQLRequest getSubscribeToAListGraphQLRequest(String partialRequest)
			throws GraphQLRequestPreparationException {
		return super.getSubscribeToAListGraphQLRequest(partialRequest);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient issue53WithBindValues(String queryResponseDef,
			SubscriptionCallback<java.util.Date> subscriptionCallback, Date date, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return super.issue53WithBindValues(queryResponseDef, subscriptionCallback, date, parameters);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient issue53(String queryResponseDef,
			SubscriptionCallback<java.util.Date> subscriptionCallback, Date date, Object... paramsAndValues)
			throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		return super.issue53(queryResponseDef, subscriptionCallback, date, paramsAndValues);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient issue53WithBindValues(ObjectResponse objectResponse,
			SubscriptionCallback<java.util.Date> subscriptionCallback, Date date, Map<String, Object> parameters)
			throws GraphQLRequestExecutionException {
		return super.issue53WithBindValues(objectResponse, subscriptionCallback, date, parameters);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public SubscriptionClient issue53(ObjectResponse objectResponse,
			SubscriptionCallback<java.util.Date> subscriptionCallback, Date date, Object... paramsAndValues)
			throws GraphQLRequestExecutionException {
		return super.issue53(objectResponse, subscriptionCallback, date, paramsAndValues);
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public com.graphql_java_generator.client.request.Builder getIssue53ResponseBuilder()
			throws GraphQLRequestPreparationException {
		return super.getIssue53ResponseBuilder();
	}

	/**
	 * This method is deprecated: please use {@link TheSubscriptionTypeExecutor} class instead of this class, to execute
	 * this method. It is maintained to keep existing code compatible with the generated code. It will be removed in 2.0
	 * version.
	 */
	@Override
	@Deprecated
	public GraphQLRequest getIssue53GraphQLRequest(String partialRequest) throws GraphQLRequestPreparationException {
		return super.getIssue53GraphQLRequest(partialRequest);
	}

}