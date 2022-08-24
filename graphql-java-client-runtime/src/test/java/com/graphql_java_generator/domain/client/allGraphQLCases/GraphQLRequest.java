/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.client.allGraphQLCases;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.client.GraphQlClient;

import com.graphql_java_generator.annotation.RequestType;
import com.graphql_java_generator.client.GraphqlClientUtils;
import com.graphql_java_generator.client.SubscriptionCallback;
import com.graphql_java_generator.client.SubscriptionClient;
import com.graphql_java_generator.client.request.InputParameter;
import com.graphql_java_generator.client.request.ObjectResponse;
import com.graphql_java_generator.client.request.QueryField;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import com.graphql_java_generator.util.GraphqlUtils;

/**
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@SuppressWarnings("unused")
public class GraphQLRequest extends ObjectResponse {

	/** Logger for this class */
	private static Logger logger = LoggerFactory.getLogger(GraphQLRequest.class);

	final GraphqlUtils graphqlUtils = new GraphqlUtils();
	final GraphqlClientUtils graphqlClientUtils = new GraphqlClientUtils();

	// This initialization must occur before the execution of the constructors, in order to properly parse the GraphQL
	// request
	static {
		CustomScalarRegistryInitializer.initCustomScalarRegistry();
		DirectiveRegistryInitializer.initDirectiveRegistry();
	}

	public GraphQLRequest(GraphQlClient graphQlClient, String graphQLRequest)
			throws GraphQLRequestPreparationException {
		super(graphQlClient, "MySchema", graphQLRequest);
	}

	public GraphQLRequest(GraphQlClient graphQlClient, String graphQLRequest, RequestType requestType, String queryName,
			InputParameter... inputParams) throws GraphQLRequestPreparationException {
		super(graphQlClient, "MySchema", graphQLRequest, requestType, queryName, inputParams);
	}

	/**
	 * This method executes the current GraphQL request as a full query request. It offers a logging of the call (if in
	 * debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * Here is a sample (and please have a look to the
	 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">graphql-java-generator
	 * website</A> for more information):
	 * 
	 * <PRE>
	 * GraphQLRequest request;
	 * 
	 * public void setup() {
	 *  GraphQLRequest.setStaticConfiguration(...);
	 * 	// Preparation of the query
	 * 	request = myQueryType.getResponseBuilder()
	 * 			.withQueryResponseDef("query{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * Map<String, Object> params = new HashMap<>();
	 * params.put("heroParam", heroParamValue);
	 * params.put("skip", Boolean.FALSE);
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * MyQueryTypeResponse response = request.exec(params);
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@SuppressWarnings("deprecation")
	public MyQueryTypeResponse execQuery(Map<String, Object> parameters) throws GraphQLRequestExecutionException {
		logExecution(RequestType.mutation, parameters);
		return exec(MyQueryTypeResponse.class, parameters);
	}

	/**
	 * This method executes the current GraphQL request as a full query request. It offers a logging of the call (if in
	 * debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * Here is a sample (and please have a look to the
	 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">graphql-java-generator
	 * website</A> for more information):
	 * 
	 * <PRE>
	 * GraphQLRequest request;
	 * 
	 * public void setup() {
	 *  GraphQLRequest.setStaticConfiguration(...);
	 * 	// Preparation of the query
	 * 	request = new GraphQLRequest("query{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * MyQueryTypeResponse response = request.exec("heroParam", heroParamValue, "skip", Boolean.FALSE);
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@SuppressWarnings("deprecation")
	public MyQueryTypeResponse execQuery(Object... paramsAndValues) throws GraphQLRequestExecutionException {
		return exec(MyQueryTypeResponse.class, graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues));
	}

	/**
	 * This method executes the current GraphQL request as a full mutation request. It offers a logging of the call (if
	 * in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * Here is a sample (and please have a look to the
	 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">graphql-java-generator
	 * website</A> for more information):
	 * 
	 * <PRE>
	 * GraphQLRequest request;
	 * 
	 * public void setup() {
	 *  GraphQLRequest.setStaticConfiguration(...);
	 * 	// Preparation of the query
	 * 	request = myQueryType.getResponseBuilder()
	 * 			.withQueryResponseDef("mutation{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * Map<String, Object> params = new HashMap<>();
	 * params.put("heroParam", heroParamValue);
	 * params.put("skip", Boolean.FALSE);
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * AnotherMutationTypeResponse response = request.exec(params);
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@SuppressWarnings("deprecation")
	public AnotherMutationTypeResponse execMutation(Map<String, Object> parameters)
			throws GraphQLRequestExecutionException {
		logExecution(RequestType.mutation, parameters);
		return exec(AnotherMutationTypeResponse.class, parameters);
	}

	/**
	 * This method executes the current GraphQL request as a full mutation request. It offers a logging of the call (if
	 * in debug mode), or of the call and its parameters (if in trace mode).<BR/>
	 * Here is a sample (and please have a look to the
	 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">graphql-java-generator
	 * website</A> for more information):
	 * 
	 * <PRE>
	 * GraphQLRequest request;
	 * 
	 * public void setup() {
	 *  GraphQLRequest.setStaticConfiguration(...);
	 * 	// Preparation of the query
	 * 	request = new GraphQLRequest("mutation{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * AnotherMutationTypeResponse response = request.exec("heroParam", heroParamValue, "skip", Boolean.FALSE);
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	@SuppressWarnings("deprecation")
	public AnotherMutationTypeResponse execMutation(Object... paramsAndValues) throws GraphQLRequestExecutionException {
		return exec(AnotherMutationTypeResponse.class,
				graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues));
	}

	/**
	 * This method executes the current GraphQL request as a full subscription request. It offers a logging of the call
	 * (if in debug mode), or of the call and its parameters (if in trace mode). You can to the
	 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">graphql-java-generator
	 * website</A> to read more information.<BR/>
	 * <B>Please note:</B>
	 * <UL>
	 * <LI>Using partial request is easier</LI>
	 * <LI>The full request may bot contain more than one subscription at a time</LI>
	 * </UL>
	 * Here is a sample (and please have a look to the GraphQL site for more information):
	 * 
	 * <PRE>
	 * GraphQLRequest request;
	 * 
	 * public void setup() {
	 *  GraphQLRequest.setStaticConfiguration(...);
	 * 	// Preparation of the query
	 * 	request = myQueryType.getResponseBuilder()
	 * 			.withQueryResponseDef("subscription{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * Map<String, Object> params = new HashMap<>();
	 * params.put("heroParam", heroParamValue);
	 * params.put("skip", Boolean.FALSE);
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * TheSubscriptionTypeResponse response = request.exec(params);
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param <T>
	 *            The type that must is returned by the subscription in the GraphQL schema, which is actually the type
	 *            that will be sent in each notification received from this subscription.
	 * @param subscriptionCallback
	 *            The object that will be called each time a message is received, or an error on the subscription
	 *            occurs. This object is provided by the application.
	 * @param messageType
	 *            The T class
	 * @param parameters
	 *            The list of values, for the bind variables defined in the query. If there is no bind variable in the
	 *            defined Query, this argument may be null or an empty {@link Map}
	 * @return The Subscription client. It allows to stop the subscription, by executing its
	 *         {@link SubscriptionClient#unsubscribe()} method. This will stop the incoming notification flow, and will
	 *         free resources on both the client and the server.
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public <T> SubscriptionClient execSubscription(SubscriptionCallback<T> subscriptionCallback, Class<T> messageType,
			Map<String, Object> parameters) throws GraphQLRequestExecutionException {
		return exec(parameters, subscriptionCallback, TheSubscriptionType.class, messageType);
	}

	/**
	 * This method executes the current GraphQL request as a full subscription request. It offers a logging of the call
	 * (if in debug mode), or of the call and its parameters (if in trace mode). You can to the
	 * <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">graphql-java-generator
	 * website</A> to read more information.<BR/>
	 * <B>Please note:</B>
	 * <UL>
	 * <LI>Using partial request is easier</LI>
	 * <LI>The full request may bot contain more than one subscription at a time</LI>
	 * </UL>
	 * Here is a sample (and please have a look to the GraphQL site for more information):
	 * 
	 * <PRE>
	 * GraphQLRequest request;
	 * 
	 * public void setup() {
	 *  GraphQLRequest.setStaticConfiguration(...);
	 * 	// Preparation of the query
	 * 	request = new GraphQLRequest("subscription{hero(param:?heroParam) @include(if:true) {id name @skip(if: ?skip) appearsIn friends {id name}}}").build();
	 * }
	 * 
	 * public void doTheJob() {
	 * ..
	 * // This will set the value sinceValue to the sinceParam field parameter
	 * TheSubscriptionTypeResponse response = request.exec("heroParam", heroParamValue, "skip", Boolean.FALSE);
	 * ...
	 * }
	 * </PRE>
	 * 
	 * @param <T>
	 *            The type that must is returned by the subscription in the GraphQL schema, which is actually the type
	 *            that will be sent in each notification received from this subscription.
	 * @param subscriptionCallback
	 *            The object that will be called each time a message is received, or an error on the subscription
	 *            occurs. This object is provided by the application.
	 * @param messageType
	 *            The T class
	 * @param paramsAndValues
	 *            This parameter contains all the name and values for the Bind Variables defined in the objectResponse
	 *            parameter, that must be sent to the server. Optional parameter may not have a value. They will be
	 *            ignored and not sent to the server. Mandatory parameter must be provided in this argument.<BR/>
	 *            This parameter contains an even number of parameters: it must be a series of name and values :
	 *            (paramName1, paramValue1, paramName2, paramValue2...)
	 * @return The Subscription client. It allows to stop the subscription, by executing its
	 *         {@link SubscriptionClient#unsubscribe()} method. This will stop the incoming notification flow, and will
	 *         free resources on both the client and the server.
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 */
	public <T> SubscriptionClient execSubscription(SubscriptionCallback<T> subscriptionCallback, Class<T> messageType,
			Object... paramsAndValues) throws GraphQLRequestExecutionException {
		return exec(graphqlClientUtils.generatesBindVariableValuesMap(paramsAndValues), subscriptionCallback,
				TheSubscriptionType.class, messageType);
	}

	/**
	 * 
	 * @param executionOf
	 *            A string
	 * @param parameters
	 */
	private void logExecution(RequestType requestType, Map<String, Object> parameters) {
		if (logger.isTraceEnabled()) {
			if (parameters == null) {
				logger.trace("Executing of " + requestType.toString() + " without parameters");
			} else {
				StringBuffer sb = new StringBuffer("Executing of root mutation with parameters: ");
				boolean addComma = false;
				for (String key : parameters.keySet()) {
					sb.append(key).append(":").append(parameters.get(key));
					if (addComma)
						sb.append(", ");
					addComma = true;
				}
				logger.trace(sb.toString());
			}
		} else if (logger.isDebugEnabled()) {
			logger.debug("Executing of mutation 'MutationType'");
		}
	}

	/**
	 * This method returns the package name, where the GraphQL generated classes are. It's used to load the class
	 * definition, and get the GraphQL metadata coming from the GraphQL schema.
	 * 
	 * @return
	 */
	@Override
	protected String getGraphQLClassesPackageName() {
		return "com.graphql_java_generator.domain.client.allGraphQLCases";
	}

	@Override
	public QueryField getQueryContext() throws GraphQLRequestPreparationException {
		return new QueryField(MyQueryTypeRootResponse.class, "query");
	}

	@Override
	public QueryField getMutationContext() throws GraphQLRequestPreparationException {
		return new QueryField(AnotherMutationTypeRootResponse.class, "mutation");
	}

	@Override
	public QueryField getSubscriptionContext() throws GraphQLRequestPreparationException {
		return new QueryField(TheSubscriptionTypeRootResponse.class, "subscription");
	}

}
