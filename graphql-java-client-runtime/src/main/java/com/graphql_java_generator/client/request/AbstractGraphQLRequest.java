package com.graphql_java_generator.client.request;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.ResponseError;
import org.springframework.graphql.ResponseField;
import org.springframework.graphql.client.ClientGraphQlResponse;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.GraphQlClient.RequestSpec;
import org.springframework.web.reactive.socket.client.WebSocketClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql_java_generator.annotation.GraphQLScalar;
import com.graphql_java_generator.annotation.RequestType;
import com.graphql_java_generator.client.GraphQLObjectMapper;
import com.graphql_java_generator.client.GraphQLRequestObject;
import com.graphql_java_generator.client.SpringContextBean;
import com.graphql_java_generator.client.SubscriptionCallback;
import com.graphql_java_generator.client.SubscriptionClient;
import com.graphql_java_generator.client.SubscriptionClientReactiveImpl;
import com.graphql_java_generator.client.request.InputParameter.InputParameterType;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;

import reactor.core.publisher.Flux;

/**
 * This class contains the description for a GraphQL request that will be sent to the server. It's an abstract class,
 * and can not be use directly: a concrete class is generated by the plugin, when in client mode. This concrete class
 * provides all the necessary context to this abstract class for it to work properly.<BR/>
 * This class stores:
 * <UL>
 * <LI>The query part, if any</LI>
 * <LI>The mutation part, if any</LI>
 * <LI>The subscription part, if any</LI>
 * <LI>The fragments, if any</LI>
 * </UL>
 * 
 * @author etienne-sf
 */
public abstract class AbstractGraphQLRequest {

	/** Logger for this class */
	private static Logger logger = LoggerFactory.getLogger(AbstractGraphQLRequest.class);

	final GraphQlClient graphQlClient;

	/** The query, if any */
	QueryField query = null;

	/** The mutation, if any */
	QueryField mutation = null;

	/** The mutation, if any */
	QueryField subscription = null;

	/**
	 * This maps contains the {@link Field}, that matches each alias, of each GraphQL type. This allows a proper
	 * deserialization of each alias value returned in the json response
	 */
	Map<Class<?>, Map<String, Field>> aliasFields = new HashMap<>();

	/** All the fragments defined for this query */
	List<Fragment> fragments = new ArrayList<>();

	/** The string that has been used to create this GraphQL request */
	final String graphQLRequest;

	/**
	 * Null if the request is a full request. Mandatory if the request is a partial request. When this GraphQLRequest is
	 * built for a partial query, that is for a particular query/mutation/subscription, then fieldName states whether
	 * this queryName is actually a query, a mutation or a subscription.
	 */
	RequestType requestType;
	/**
	 * Null if the request is a full request. Mandatory if the request is a partial request.<BR/>
	 * When this GraphQLRequest is built for a partial query, that is for a particular query/mutation/subscription, then
	 * queryName is the name of the query, mutation or subscription. This allow to check that the GraphQLRequest is the
	 * good to be executed for this partial query.
	 */
	final String requestName;
	/**
	 * The package name, where the GraphQL generated classes are. It's used to load the class definition, and get the
	 * GraphQL metadata coming from the GraphQL schema.
	 */
	protected final String packageName;

	/** Indicates what is being read, when reading the GraphQL variable list */
	private enum Step {
		NAME, TYPE
	};

	/**
	 * This class contains the payload that will be sent to the server. This payload is serialized differently,
	 * depending on the transport, for instance: http POST for query and mutation, or web socket with the
	 * graphql-transport-ws protocol for query, mutation and subscription.
	 * 
	 * @author etienne_sf
	 */
	public static class Payload {
		String query = null;
		Map<String, Object> variables = new HashMap<>();
		String operationName = null;

		public String getQuery() {
			return query;
		}

		public Map<String, Object> getVariables() {
			return variables;
		}

		public String getOperationName() {
			return operationName;
		}

	}

	/**
	 * Create the instance, from the GraphQL request, for a partial request.<BR/>
	 * 
	 * <B><U>Important note:</U></B> this constructor <B>SHOULD NOT</B> be called by external application. Its signature
	 * may change in the future. To prepare Partial Requests, application code <B>SHOULD</B> call the
	 * getXxxxGraphQLRequests methods, that are generated in the query/mutation/subscription java classes.
	 * 
	 * @param graphQlClient
	 *            The {@link GraphQlClient} that is responsible for the actual execution of the request
	 * @param schema
	 *            value of the <i>springBeanSuffix</i> plugin parameter for the searched schema. When there is only one
	 *            schema, this plugin parameter is usually not set. In this case, its default value ("") is used.
	 * @param graphQLRequest
	 *            The <B>partial</B> GraphQL request, in text format. Writing partial request allows use to execute a
	 *            query/mutation/subscription, and only define what's expected as a response for this
	 *            query/mutation/subscription. You can send the parameters for this query/mutation/subscription as
	 *            parameter of the java method, without dealing with bind variable in the GraphQL query. Please read the
	 *            <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">client doc
	 *            page</A> for more information, including hints and limitations.
	 * @param requestType
	 *            The information whether this queryName is actually a query, a mutation or a subscription
	 * @param fieldName
	 *            The name of the query, mutation or subscription, for instance "createHuman", in the GraphQL request
	 *            "mutation {createHuman (...) { ...}}".
	 * @param inputParams
	 *            The list of input parameters for this query/mutation/subscription
	 * @throws GraphQLRequestPreparationException
	 */
	public AbstractGraphQLRequest(String schema, String graphQLRequest, RequestType requestType, String fieldName,
			InputParameter... inputParams) throws GraphQLRequestPreparationException {
		if (requestType == null) {
			throw new NullPointerException("requestType is mandatory, but a null value has been provided");
		}
		if (fieldName == null) {
			throw new NullPointerException("fieldName is mandatory, but a null value has been provided");
		}
		this.graphQlClient = SpringContextBean.getGraphQlClient(schema);
		this.requestType = requestType;
		this.requestName = null;
		this.graphQLRequest = graphQLRequest;
		this.packageName = getGraphQLClassesPackageName();

		QueryField field;
		switch (requestType) {
		case query:
			query = getQueryContext();// Get the query field from the concrete class
			field = new QueryField(query.clazz, fieldName);
			query.fields.add(field);
			break;
		case mutation:
			mutation = getMutationContext();// Get the mutation field from the concrete class
			field = new QueryField(mutation.clazz, fieldName);
			mutation.fields.add(field);
			break;
		case subscription:
			subscription = getSubscriptionContext();// Get the subscription field from the concrete class
			field = new QueryField(subscription.clazz, fieldName);
			subscription.fields.add(field);
			break;
		default:
			throw new GraphQLRequestPreparationException("Non managed request type '" + requestType
					+ " while reading the GraphQL request: " + graphQLRequest);
		}

		// Let's add the input parameters to this new field
		field.inputParameters = Arrays.asList(inputParams);

		// Ok, we have to parse a string which looks like that: "query {human(id: &humanId) { id name friends{name}}}"
		// We tokenize the string, by using the space as a delimiter, and all other special GraphQL characters
		QueryTokenizer qt = new QueryTokenizer(this.graphQLRequest);

		// The graphQLRequest may be null (for instance for a scalar, or if we want the plugin to automatically add all
		// scalar fields for this query/mutation/subscription)
		if (!qt.hasMoreTokens()) {
			// Ok, we're done
		} else {
			// The first token must be a {
			// And we must read it first, before parsing the request content
			String token = qt.nextToken();
			if (!"{".equals(token)) {
				throw new GraphQLRequestPreparationException(
						"The Partial GraphQL Request should start by a '{', but it doesn't: " + graphQLRequest);
			}
			field.readTokenizerForResponseDefinition(qt, aliasFields, schema);
		}

		// Let's finish the job
		finishRequestPreparation();
	}

	/**
	 * Creates the GraphQL request, for a full request. It will:
	 * <UL>
	 * <LI>Read the query and/or the mutation</LI>
	 * <LI>Read all fragment definitions</LI>
	 * <LI>For all non scalar field, subfields (and so on recursively), if they are empty (that is the query doesn't
	 * define the requested fields of a non scalar field, then all its scalar fields are added)</LI>
	 * <LI>Add the introspection __typename field to all scalar field list, if it doesnt't already exist. This is
	 * necessary to allow proper deserialization of interfaces and unions.</LI>
	 * </UL>
	 * 
	 * @param schema
	 *            value of the <i>springBeanSuffix</i> plugin parameter for the searched schema. When there is only one
	 *            schema, this plugin parameter is usually not set. In this case, its default value ("") is used.
	 * @param graphQLRequest
	 *            The GraphQL request, in text format, as defined in the GraphQL specifications, and as it can be used
	 *            in GraphiQL. Please read the
	 *            <A HREF="https://graphql-maven-plugin-project.graphql-java-generator.com/client.html">client doc
	 *            page</A> for more information, including hints and limitations.
	 * 
	 * @throws GraphQLRequestPreparationException
	 */
	public AbstractGraphQLRequest(String schema, String graphQLRequest) throws GraphQLRequestPreparationException {
		this.graphQlClient = SpringContextBean.getGraphQlClient(schema);
		String localQueryName = null;
		this.graphQLRequest = graphQLRequest;
		this.packageName = getGraphQLClassesPackageName();
		this.requestType = RequestType.query; // query is the default value, as if there is no query, mutation or
												// subscription keyword, then it must be a query.
		boolean requestTypeHasBeenRead = false; // Used for a basic check in unknown tokens, to see if this token can be
												// the request name
		List<InputParameter> inputParameters = new ArrayList<>(); // The list of GraphQL variables for this query

		// Ok, we have to parse a string which looks like that: "query {human(id: &humanId) { id name friends{name}}}"
		// We tokenize the string, by using the space as a delimiter, and all other special GraphQL characters
		QueryTokenizer qt = new QueryTokenizer(this.graphQLRequest);

		// We scan the input string. It may contain fragment definition and query/mutation/subscription
		while (qt.hasMoreTokens()) {
			String token = qt.nextToken();

			switch (token) {
			case "fragment":
				fragments.add(new Fragment(qt, aliasFields, packageName, false, null, schema));
				break;
			case "query":
			case "mutation":
			case "subscription":
				requestType = RequestType.valueOf(token);
				requestTypeHasBeenRead = true;// We'll know accept an unknown token as the request name
				break;
			case "(":
				try {
					readRequestParameters(qt, inputParameters, schema);
				} catch (Exception e) {
					throw new GraphQLRequestPreparationException(
							e.getMessage() + " (while reading the request parameters)", e);
				}
				break;
			case "{":
				// We read the query/mutation/subscription like any field.
				switch (requestType) {
				case query:
					query = getQueryContext();// Get the query field from the concrete class
					query.inputParameters = inputParameters;
					query.readTokenizerForResponseDefinition(qt, aliasFields, schema);
					break;
				case mutation:
					mutation = getMutationContext();// Get the mutation field from the concrete class
					mutation.inputParameters = inputParameters;
					mutation.readTokenizerForResponseDefinition(qt, aliasFields, schema);
					break;
				case subscription:
					subscription = getSubscriptionContext();// Get the subscription field from the concrete class
					subscription.inputParameters = inputParameters;
					subscription.readTokenizerForResponseDefinition(qt, aliasFields, schema);
					break;
				default:
					throw new GraphQLRequestPreparationException("Non managed request type '" + requestType
							+ " while reading the GraphQL request: " + graphQLRequest);
				}
				break;
			default:
				if (requestTypeHasBeenRead) {
					localQueryName = token;
				} else {
					throw new GraphQLRequestPreparationException(
							"Unknown token '" + token + " while reading the GraphQL request: " + graphQLRequest);
				}
			}
		}

		if (query == null && mutation == null && subscription == null) {
			throw new GraphQLRequestPreparationException("No response definition found");
		}

		// Let's finish the job

		// As the query name can't be changed, we have to set in a temporary variable, to allow changing its value when
		// we found one
		this.requestName = localQueryName;
		finishRequestPreparation();
	}

	/**
	 * Reads the parameters of the request. These parameters are actually GraphQL variables, according to the GraphQL
	 * spec.
	 * 
	 * @param qt
	 *            The {@link QueryTokenizer} current token is the '(' that starts the parameter list. When the method
	 *            returns, the {@link QueryTokenizer} current token is the ')'
	 * @param inputParameters
	 *            The empty list if {@link InputParameter}s.
	 * @throws GraphQLRequestPreparationException
	 */
	private void readRequestParameters(QueryTokenizer qt, List<InputParameter> inputParameters, String schema)
			throws GraphQLRequestPreparationException {
		String token;
		// We're reading the request parameters. It should be something like "($param1: Type1, $param2: Type2!)"
		Step step = Step.NAME;
		String name = null;

		while (true) {
			token = qt.nextToken();

			// Are we done?
			if (token.equals(")")) {
				if (step.equals(Step.TYPE)) {
					throw new GraphQLRequestPreparationException(
							"Found a ')', while expecting a value for the '" + name + "' query parameter");
				} else {
					// Ok we're done
					break;
				}
			} else if (token.equals(",")) {
				// We should be waiting for the name of the GraphQL variable
				if (!step.equals(Step.NAME)) {
					throw new GraphQLRequestPreparationException("unexpected ','");
				}
				// Let's go to the next token, that should be the GraphQL type
				token = qt.nextToken();
			} else if (token.equals(":")) {
				// We should be waiting for the type of the GraphQL variable
				if (!step.equals(Step.TYPE)) {
					throw new GraphQLRequestPreparationException("unexpected ':'");
				}
				// Let's go to the next token, that should be the GraphQL type
				token = qt.nextToken();
			}

			switch (step) {
			case NAME:
				if (!token.startsWith("$")) {
					throw new GraphQLRequestPreparationException(
							"The GraphQL variable names should start by a '$', but this one doesn't: '" + token + "'");
				}
				// We store the name, without the leading '$'
				name = token.substring(1);
				// The next token should be the value
				step = Step.TYPE;
				break;
			case TYPE:
				// The current token is the GraphQL variable type, for instance "[[Human!]]!". Let's parse it.
				int currentDepth = 0;
				String graphQLTypeName = null;
				boolean mandatory = false;
				int listDepth = 0;
				boolean itemMandatory = false;
				while (true) {
					switch (token) {
					case "[":
						listDepth += 1;
						currentDepth += 1;
						break;
					case "]":
						currentDepth -= 1;
						break;
					case "!":
						// If we're here, it means the depth is at least one.
						itemMandatory = true;
						break;
					case ",":
					case ")":// Too bad, the query is wrongly written
						throw new GraphQLRequestPreparationException(
								"Syntax error in the query, while reading the type of the '" + name
										+ "' parameter of the request");
					default:
						// We have the GraphQL type name
						graphQLTypeName = token;
					}

					// Are we done?
					if (currentDepth == 0) {
						break;
					}

					token = qt.nextToken();
				}
				;

				// We get here if the item is not a list, or after reading the last ']'.
				// Let's check if there is a trailing '!'
				if (qt.checkNextToken("!")) {
					mandatory = true;
					// Then we pass this token
					token = qt.nextToken();
				} else {
					mandatory = false;
				}

				inputParameters.add(InputParameter.newGraphQLVariableParameter(schema, name, graphQLTypeName, mandatory,
						listDepth, itemMandatory));
				// The next token should be either the end of parameters (with a ')') or a name
				step = Step.NAME;
				break;
			}// switch
		} // while
	}

	/**
	 * This method executes the current GraphQL as a <B>query</B> or <B>mutation</B> GraphQL request, and return its
	 * response mapped in the relevant POJO. This method executes a partial GraphQL query, or a full GraphQL
	 * request.<BR/>
	 * <B>Note:</B> Don't forget to free the server's resources by calling the {@link WebSocketClient#stop()} method of
	 * the returned object.
	 * 
	 * @param <T>
	 * @param t
	 *            The type of the POJO which should be returned. It must be the query or the mutation class, generated
	 *            by the plugin
	 * @param params
	 * @return
	 * @throws GraphQLRequestExecutionException
	 */
	public <T extends GraphQLRequestObject> T exec(Class<T> t, Map<String, Object> params)
			throws GraphQLRequestExecutionException {
		if (getRequestType().equals(RequestType.subscription))
			throw new GraphQLRequestExecutionException("This method may not be called for subscriptions");

		// Building of the request
		Payload payload = getPayload(params);
		RequestSpec requestSpec = graphQlClient.document(payload.query);
		if (payload.variables.size() > 0)
			requestSpec.variables(payload.variables);
		if (payload.operationName != null)
			requestSpec.operationName(payload.operationName);

		// Actual execution of the request
		logger.trace("Executing query or mutation {}", payload.query);
		ClientGraphQlResponse response = requestSpec.execute().block();

		// Does this response contain errors?
		if (response.getErrors() != null && response.getErrors().size() > 0) {
			throw new GraphQLRequestExecutionException(response.getErrors());
		}

		// No error, let's go!
		return response.toEntity(t);
	}

	/**
	 * Execution of the given <B>subscription</B> GraphQL request, and return its response mapped in the relevant POJO.
	 * This method executes a partial GraphQL query, or a full GraphQL request.<BR/>
	 * <B>Note:</B> Don't forget to free the server's resources by calling the {@link WebSocketClient#stop()} method of
	 * the returned object.
	 * 
	 * @param <R>
	 *            The class that is generated from the subscription definition in the GraphQL schema. It contains one
	 *            attribute, for each available subscription. The data tag of the GraphQL server response will be mapped
	 *            into an instance of this class.
	 * @param <T>
	 *            The type that must is returned by the subscription in the GraphQL schema, which is actually the type
	 *            that will be sent in each notification received from this subscription.
	 * @param t
	 *            The type of the POJO which should be returned. It must be the query or the mutation class, generated
	 *            by the plugin
	 * @param params
	 *            the input parameters for this query. If the query has no parameters, it may be null or an empty list.
	 * @param subscriptionCallback
	 *            The object that will be called each time a message is received, or an error on the subscription
	 *            occurs. This object is provided by the application.
	 * @param subscriptionName
	 *            The name of the subscription that should be subscribed by this method call. It will be used to check
	 *            that the correct GraphQLRequest has been provided by the caller.
	 * @param subscriptionType
	 *            The R class
	 * @param messageType
	 *            The T class
	 * @return The Subscription client. It allows to stop the subscription, by executing its
	 *         {@link SubscriptionClient#unsubscribe()} method. This will stop the incoming notification flow, and will
	 *         free resources on both the client and the server.
	 * @throws GraphQLRequestExecutionException
	 *             When an error occurs during the request execution, typically a network error, an error from the
	 *             GraphQL server or if the server response can't be parsed
	 * @throws IOException
	 */
	public <R, T> SubscriptionClient exec(Map<String, Object> params, SubscriptionCallback<T> subscriptionCallback,
			Class<R> subscriptionType, Class<T> messageType) throws GraphQLRequestExecutionException {
		// This method accepts only subscription at a time (no query and no mutation)
		if (!requestType.equals(RequestType.subscription))
			throw new GraphQLRequestExecutionException("This method may be called only for subscriptions");

		// Subscription may be subscribed only once at a time, as this method allows only one subscriptionCallback
		if (subscription.getFields().size() != 1) {
			throw new GraphQLRequestExecutionException(
					"This method may be called only for one subscription at a time, but there was "
							+ subscription.getFields().size() + " subscriptions in this GraphQLRequest");
		}

		// Building of the request
		Payload payload = getPayload(params);
		RequestSpec requestSpec = graphQlClient.document(payload.query);
		if (payload.variables.size() > 0)
			requestSpec.variables(payload.variables);
		if (payload.operationName != null)
			requestSpec.operationName(payload.operationName);

		// Actual execution of the request
		logger.trace("Executing subscription {}", payload.query);
		Flux<ClientGraphQlResponse> flux = requestSpec//
				.executeSubscription()//
				// on subscription
				.doOnSubscribe(new Consumer<Subscription>() {
					@Override
					public void accept(Subscription t) {
						subscriptionCallback.onConnect();
					}
				})
				// Next message
				.doOnNext(new Consumer<ClientGraphQlResponse>() {
					@Override
					public void accept(ClientGraphQlResponse response) {
						if (!response.isValid()) {
							subscriptionCallback.onError(new GraphQLRequestExecutionException(response.getErrors()));
						} else {
							ResponseField field = response.field(subscription.getFields().get(0).getName());
							if (!field.hasValue()) {
								if (field.getError() != null) {
									// Field failure...
									List<ResponseError> errors = Arrays.asList(field.getError());
									subscriptionCallback.onError(new GraphQLRequestExecutionException(errors));
								} else {
									// Optional field set to null...
									subscriptionCallback.onMessage(null);
								}
							} else {
								// It's a valid value. Let's notify the callback
								Object o = field.getValue();
								if (o == null) {
									subscriptionCallback.onMessage(null);
								} else if (o instanceof List<?>) {
									try {
										subscriptionCallback.onMessage(
												getGraphQLObjectMapper().treeToValue((List<?>) o, messageType));
									} catch (JsonProcessingException e) {
										throw new RuntimeException(e.getMessage(), e);
									}
								} else if (o instanceof Map<?, ?>) {
									try {
										subscriptionCallback.onMessage(
												getGraphQLObjectMapper().treeToValue((Map<?, ?>) o, messageType));
									} catch (JsonProcessingException e) {
										throw new RuntimeException(e.getMessage(), e);
									}
								} else {
									subscriptionCallback.onMessage(field.getValue());
								}
							}
						}
					}
				})
				// on error
				.doOnError(new Consumer<Throwable>() {
					@Override
					public void accept(Throwable t) {
						subscriptionCallback.onError(t);
					}
				})
				// on completion
				.doOnComplete(() -> subscriptionCallback.onClose(0, null)) //
		;

		return new SubscriptionClientReactiveImpl(flux.subscribe());
	}

	/**
	 * Adds the <I>__typename</I> fields to all non scalar types
	 * 
	 * @param graphQLRequest
	 * @throws GraphQLRequestPreparationException
	 */
	private void addTypenameFields() throws GraphQLRequestPreparationException {

		// We need the __typename fields, to properly parse the JSON response for interfaces and unions.
		// So we add it for every returned object.
		if (query != null) {
			query.addTypenameFields();
		}
		if (mutation != null) {
			mutation.addTypenameFields();
		}
		if (subscription != null) {
			subscription.addTypenameFields();
		}

		for (Fragment f : fragments) {
			f.addTypenameFields();
		}
	}

	/**
	 * Finish the preparation of the GraphQL request, once everything has been read:
	 * <UL>
	 * <LI>add the scalar fields, for all empty non scalar fields.</LI>
	 * <LI>Add the __typename field in fragments and field lists, to be sure to get it in return. This is necessary to
	 * properly deserialize the GRaphQL interfaces and unions
	 * </UL>
	 * 
	 * @throws GraphQLRequestPreparationException
	 */
	private void finishRequestPreparation() throws GraphQLRequestPreparationException {// For each non scalar field, we
																						// add its non scalar fields, if
																						// none was defined
		AddScalarFieldToEmptyNonScalarField(query);
		AddScalarFieldToEmptyNonScalarField(mutation);
		AddScalarFieldToEmptyNonScalarField(subscription);

		// Let's add the <I>__typename</I> fields to all non scalar types
		addTypenameFields();

	}

	private void AddScalarFieldToEmptyNonScalarField(QueryField field) throws GraphQLRequestPreparationException {// If
																													// this
																													// field
																													// contains
																													// no
																													// subfield,
																													// and
																													// is
																													// not
																													// a
																													// scalar,
																													// we
																													// add
																													// all
																													// its
																													// scalar
																													// fields,
																													// as
																													// requested
																													// fields.
		if (field == null || field.isScalar()) {// No action
		} else if (field.fields.size() == 0 && field.fragments.size() == 0 && field.inlineFragments.size() == 0) {// This
																													// non
																													// scalar
																													// field
																													// has
																													// no
																													// subfields
																													// in
																													// the
																													// GraphQL
																													// request.
																													// It
																													// also
																													// have
																													// no
																													// fragment
			// We'll request all it scalar fields.

			if (field.clazz.isInterface()) {// For interfaces, we look for getters
				for (Method m : field.clazz.getDeclaredMethods()) {
					if (m.getName().startsWith("get")) {
						GraphQLScalar graphQLScalar = m.getAnnotation(GraphQLScalar.class);
						if (graphQLScalar != null) {// We've found a subfield that is a scalar. Let's add it.
							field.fields.add(new QueryField(field.clazz, graphQLScalar.fieldName()));
						}
					}
				}
			} else {// For objects, we look for class's attributes
				for (Field f : field.clazz.getDeclaredFields()) {
					GraphQLScalar graphQLScalar = f.getAnnotation(GraphQLScalar.class);
					if (graphQLScalar != null) {// We've found a subfield that is a scalar. Let's add it.
						field.fields.add(new QueryField(field.clazz, graphQLScalar.fieldName()));
					}
				}
			}
		} else {// This non scalar fields contains requested subfield. We recurse into each of its fields.
			for (QueryField f : field.fields)
				AddScalarFieldToEmptyNonScalarField(f);
		} // for
	}

	/**
	 * Returns the payload for this request. This payload can then be serialized, according to the transport protocol
	 * used.
	 * 
	 * @param params
	 * @return
	 * @throws GraphQLRequestExecutionException
	 */
	public Payload getPayload(Map<String, Object> params) throws GraphQLRequestExecutionException {
		Payload payload = new Payload();
		StringBuilder sb = new StringBuilder();

		// sbGraphQLValues contains the variable declaration of the query
		StringBuilder sbGraphQLVariables = new StringBuilder();

		// Let's start by the fragments
		for (Fragment fragment : fragments) {
			fragment.appendToGraphQLRequests(sb, params);
		}

		// Then the other parts of the request
		QueryField request;
		if (query != null) {
			request = query;
		} else if (mutation != null) {
			request = mutation;
		} else if (subscription != null) {
			request = subscription;
		} else {
			throw new GraphQLRequestExecutionException("[Internal error] no request has been initialized");
		}

		// The name of the query/mutation/subscription follows special rules (including the request name and GraphQL
		// variables). So we need to add these things here, and not from the QueryField class.
		sb.append(request.name);
		if (requestName != null) {
			sb.append(" ").append(requestName);
		}

		//////////////////////////////////////////////////////////////////////////////////
		// Step 2 : collect the GraphQL variables
		String separator = "";
		for (InputParameter param : request.inputParameters) {
			if (param.getType() == InputParameterType.GRAPHQL_VARIABLE) {//////////////////////////////////////////////////////////////////////
				// Let's complete the variable list
				sbGraphQLVariables.append(separator)//
						.append("$")//
						.append(param.getBindParameterName())//
						.append(":");

				// The String.repeat(int) method needs Java 11 minimum
				for (int i = 0; i < param.getListDepth(); i += 1) {
					sbGraphQLVariables.append("[");
				} // for

				sbGraphQLVariables.append(param.getGraphQLTypeName())//
						.append(param.isItemMandatory() ? "!" : "");

				// The String.repeat(int) method needs Java 11 minimum
				for (int i = 0; i < param.getListDepth(); i += 1) {
					sbGraphQLVariables.append("]");
				} // for

				sbGraphQLVariables.append(param.isMandatory() ? "!" : "");

				//////////////////////////////////////////////////////////////////////
				// And the variable value list (for the json variables field)
				payload.variables.put(param.getBindParameterName(), param.getValueForGraphqlQuery(params));

				separator = ",";
			}
		}

		// Are there some GraphQL variables?
		String graphQLVariables = sbGraphQLVariables.toString();
		if (graphQLVariables.length() > 0) {
			sb.append("(").append(graphQLVariables).append(")");
		}

		// Let's add the whole request
		request.appendToGraphQLRequests(sb, params, false);

		// And add the result in the output map
		payload.query = sb.toString();

		// Step 3 : add the operationName
		//
		// This parameter is not mandatory, and is not transmitted by the plugin

		return payload;
	}

	/**
	 * This method creates and configures a Jackson {@link ObjectMapper} that is ready to parse the response for this
	 * GraphQL. The main configuration is the management for the GraphQL aliases.
	 * 
	 * @return
	 */
	public GraphQLObjectMapper getGraphQLObjectMapper() {
		return new GraphQLObjectMapper(getGraphQLClassesPackageName(), aliasFields);
	}

	/**
	 * Retrieve the request String that has been provided to create this instance
	 * 
	 * @return
	 */
	public String getGraphQLRequest() {
		return graphQLRequest;
	}

	/**
	 * This method returns the package name, where the GraphQL generated classes are. It's used to load the class
	 * definition, and get the GraphQL metadata coming from the GraphQL schema.
	 * 
	 * @return
	 */
	protected abstract String getGraphQLClassesPackageName();

	/**
	 * Retrieved the {@link QueryField} for the query (that is the query type coming from the GraphQL schema) from the
	 * concrete class.
	 * 
	 * @return
	 * @throws GraphQLRequestPreparationException
	 */
	protected abstract QueryField getQueryContext() throws GraphQLRequestPreparationException;

	/**
	 * Retrieved the {@link QueryField} for the mutation (that is the mutation type coming from the GraphQL schema) from
	 * the concrete class.
	 * 
	 * @return
	 */
	protected abstract QueryField getMutationContext() throws GraphQLRequestPreparationException;

	/**
	 * Retrieved the {@link QueryField} for the subscription (that is the subscription type coming from the GraphQL
	 * schema) from the concrete class.
	 * 
	 * @return
	 */
	protected abstract QueryField getSubscriptionContext() throws GraphQLRequestPreparationException;

	public QueryField getQuery() {
		return query;
	}

	public QueryField getMutation() {
		return mutation;
	}

	public QueryField getSubscription() {
		return subscription;
	}

	public List<Fragment> getFragments() {
		return fragments;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public String getRequestName() {
		return requestName;
	}

}
