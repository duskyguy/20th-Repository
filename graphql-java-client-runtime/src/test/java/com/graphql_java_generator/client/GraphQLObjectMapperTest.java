package com.graphql_java_generator.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.graphql_java_generator.client.GraphQLObjectMapperTestClass.TestEnum;
import com.graphql_java_generator.domain.client.allGraphQLCases.AllFieldCases;
import com.graphql_java_generator.domain.client.allGraphQLCases.AllFieldCasesWithIdSubtype;
import com.graphql_java_generator.domain.client.allGraphQLCases.Episode;
import com.graphql_java_generator.domain.client.allGraphQLCases.Human;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;

class GraphQLObjectMapperTest {

	@Test
	void testBoolean() throws JsonMappingException, JsonProcessingException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(getClass().getPackage().getName(), null);

		// Go, go, go
		GraphQLObjectMapperTestClass test = objectMapper.readValue(
				"{\"boolTrue\":true, \"boolFalse\":false, \"__typename\":\"GraphQLObjectMapperTestClass\"}",
				GraphQLObjectMapperTestClass.class);

		// Verification
		assertEquals(2, test.aliasValues.keySet().size());
		assertTrue((Boolean) test.aliasValues.get("boolTrue"));
		assertFalse((Boolean) test.aliasValues.get("boolFalse"));
	}

	@Test
	void testCustomScalar()
			throws JsonMappingException, JsonProcessingException, NoSuchFieldException, SecurityException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(getClass().getPackage().getName(),
				getAliasFields(GraphQLObjectMapperTestClass.class, "dateAlias", "date"));
		//
		Date date = new Calendar.Builder().setDate(2021, 5 - 1, 9).build().getTime();

		// Go, go, go
		GraphQLObjectMapperTestClass test = objectMapper.readValue(
				"{\"dateAlias\":\"2021-05-09\", \"__typename\":\"GraphQLObjectMapperTestClass\"}",
				GraphQLObjectMapperTestClass.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("dateAlias") instanceof Date);
		assertEquals(date, test.aliasValues.get("dateAlias"));
	}

	@Test
	void testEnum() throws JsonMappingException, JsonProcessingException, NoSuchFieldException,
			GraphQLRequestExecutionException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(getClass().getPackage().getName(),
				getAliasFields(GraphQLObjectMapperTestClass.class, "enumAlias", "enumField"));

		// Go, go, go
		GraphQLObjectMapperTestClass test = objectMapper.readValue(
				"{\"enumAlias\":\"VALUE2\", \"__typename\":\"GraphQLObjectMapperTestClass\"}",
				GraphQLObjectMapperTestClass.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertEquals(TestEnum.VALUE2, test.getAliasValue("enumAlias"));
	}

	@Test
	void testFloat() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(getClass().getPackage().getName(),
				getAliasFields(GraphQLObjectMapperTestClass.class, "doubleAlias", "doubleField"));

		// Go, go, go
		GraphQLObjectMapperTestClass test = objectMapper.readValue(
				"{\"doubleAlias\":123.1, \"__typename\":\"GraphQLObjectMapperTestClass\"}",
				GraphQLObjectMapperTestClass.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertEquals(123.1, test.aliasValues.get("doubleAlias"));
	}

	@Test
	void testInt() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(getClass().getPackage().getName(),
				getAliasFields(GraphQLObjectMapperTestClass.class, "intAlias", "intField"));

		// Go, go, go
		GraphQLObjectMapperTestClass test = objectMapper.readValue(
				"{\"intAlias\":666, \"__typename\":\"GraphQLObjectMapperTestClass\"}",
				GraphQLObjectMapperTestClass.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertEquals(666, test.aliasValues.get("intAlias"));
	}

	@Test
	void testListEmpty() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "commentsAlias", "comments"));

		// Go, go, go
		AllFieldCases test = objectMapper.readValue("{\"commentsAlias\":[], \"__typename\":\"AllFieldCases\"}",
				AllFieldCases.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("commentsAlias") instanceof List);
		assertEquals(0, ((List<?>) test.aliasValues.get("commentsAlias")).size());
	}

	@Test
	void testListOneString() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "commentsAlias", "comments"));

		// Go, go, go
		AllFieldCases test = objectMapper
				.readValue("{\"commentsAlias\":[\"my str\"], \"__typename\":\"AllFieldCases\"}", AllFieldCases.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("commentsAlias") instanceof List);
		assertEquals(1, ((List<?>) test.aliasValues.get("commentsAlias")).size());
		assertTrue(((List<?>) test.aliasValues.get("commentsAlias")).get(0) instanceof String);
		assertEquals("my str", ((List<?>) test.aliasValues.get("commentsAlias")).get(0));
	}

	@Test
	void testListOneObject() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "friendsAlias", "friends"));

		// Go, go, go
		AllFieldCases test = objectMapper.readValue(""//
				+ "{"//
				+ "\"friendsAlias\":[{\"name\":\"the name\", \"__typename\":\"Human\"}], "
				+ "\"__typename\":\"AllFieldCases\""//
				+ "}", AllFieldCases.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("friendsAlias") instanceof List);
		assertEquals(1, ((List<?>) test.aliasValues.get("friendsAlias")).size());
		assertTrue(((List<?>) test.aliasValues.get("friendsAlias")).get(0) instanceof Human);
		Human verif = (Human) ((List<?>) test.aliasValues.get("friendsAlias")).get(0);
		assertEquals("the name", verif.getName());
	}

	@Test
	void testListTwoEnums() throws JsonMappingException, JsonProcessingException, NoSuchFieldException,
			GraphQLRequestExecutionException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(Human.class.getPackage().getName(),
				getAliasFields(Human.class, "appearsInAlias", "appearsIn"));

		// Go, go, go
		Human test = objectMapper.readValue(""//
				+ "{"//
				+ "\"appearsInAlias\":[\"NEWHOPE\", \"JEDI\"], " + "\"__typename\":\"Human\""//
				+ "}", Human.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("appearsInAlias") instanceof List);
		assertEquals(2, ((List<?>) test.aliasValues.get("appearsInAlias")).size());
		assertEquals(Episode.NEWHOPE, ((List<?>) test.getAliasValue("appearsInAlias")).get(0));
		assertEquals(Episode.JEDI, ((List<?>) test.aliasValues.get("appearsInAlias")).get(1));
	}

	@Test
	void testListTwoCustomScalars() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "datesAlias", "dates"));
		Date date1 = new Calendar.Builder().setDate(2021, 5 - 1, 9).build().getTime();
		Date date2 = new Calendar.Builder().setDate(2021, 5 - 1, 10).build().getTime();

		// Go, go, go
		AllFieldCases test = objectMapper.readValue(""//
				+ "{"//
				+ "\"datesAlias\":[\"2021-05-09\", \"2021-05-10\"], " + "\"__typename\":\"AllFieldCases\""//
				+ "}", AllFieldCases.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("datesAlias") instanceof List);
		assertEquals(2, ((List<?>) test.aliasValues.get("datesAlias")).size());
		//
		assertTrue(((List<?>) test.aliasValues.get("datesAlias")).get(0) instanceof Date);
		assertEquals(date1, ((List<?>) test.aliasValues.get("datesAlias")).get(0));
		//
		assertTrue(((List<?>) test.aliasValues.get("datesAlias")).get(1) instanceof Date);
		assertEquals(date2, ((List<?>) test.aliasValues.get("datesAlias")).get(1));
	}

	@Test
	void testListTwoStrings() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "commentsAlias", "comments"));

		// Go, go, go
		AllFieldCases test = objectMapper.readValue(
				"{\"commentsAlias\":[\"my str1\", \"my str2\"], \"__typename\":\"AllFieldCases\"}",
				AllFieldCases.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("commentsAlias") instanceof List);
		//
		assertEquals(2, ((List<?>) test.aliasValues.get("commentsAlias")).size());
		//
		assertTrue(((List<?>) test.aliasValues.get("commentsAlias")).get(0) instanceof String);
		assertEquals("my str1", ((List<?>) test.aliasValues.get("commentsAlias")).get(0));
		//
		assertTrue(((List<?>) test.aliasValues.get("commentsAlias")).get(1) instanceof String);
		assertEquals("my str2", ((List<?>) test.aliasValues.get("commentsAlias")).get(1));
	}

	@SuppressWarnings("unchecked")
	@Test
	void testListListList() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "matrixAlias", "matrix"));

		// Go, go, go
		AllFieldCases test = objectMapper.readValue(
				"{\"matrixAlias\":[[11.11, 222.222],[],[3333.3333]], \"__typename\":\"AllFieldCases\"}",
				AllFieldCases.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("matrixAlias") instanceof List);
		List<?> mainList = (List<?>) test.aliasValues.get("matrixAlias");
		//
		assertEquals(3, mainList.size(), "3 subsublists");
		//
		List<Double> list = (List<Double>) mainList.get(0);
		assertEquals(2, list.size());
		assertEquals(11.11, list.get(0));
		assertEquals(222.222, list.get(1));
		//
		list = (List<Double>) mainList.get(1);
		assertEquals(0, list.size());
		//
		list = (List<Double>) mainList.get(2);
		assertEquals(1, list.size());
		assertEquals(3333.3333, list.get(0));
	}

	@Test
	void testObject() throws JsonMappingException, JsonProcessingException, NoSuchFieldException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "oneWithIdSubTypeAlias", "oneWithIdSubType"));

		// Go, go, go
		AllFieldCases test = objectMapper.readValue(""//
				+ "{"//
				+ "  \"forname\":\"the root str value\", "//
				+ "  \"oneWithIdSubTypeAlias\": {\"name\":\"the alias's str value\", \"__typename\":\"AllFieldCasesWithIdSubtype\"},"
				+ "  \"__typename\":\"AllFieldCases\" " //
				+ "}", AllFieldCases.class);

		// Verification
		assertEquals("the root str value", test.getForname());

		assertEquals(1, test.aliasValues.keySet().size());
		assertTrue(test.aliasValues.get("oneWithIdSubTypeAlias") instanceof AllFieldCasesWithIdSubtype);
		AllFieldCasesWithIdSubtype verif = (AllFieldCasesWithIdSubtype) test.aliasValues.get("oneWithIdSubTypeAlias");
		assertEquals("the alias's str value", verif.getName());
	}

	@Test
	void testString() throws JsonMappingException, JsonProcessingException, NoSuchFieldException,
			GraphQLRequestExecutionException {
		// Preparation
		GraphQLObjectMapper objectMapper = new GraphQLObjectMapper(AllFieldCases.class.getPackage().getName(),
				getAliasFields(AllFieldCases.class, "nameAlias", "name"));

		// Go, go, go
		AllFieldCases test = objectMapper.readValue("{\"nameAlias\":\"a String\", \"__typename\":\"AllFieldCases\"}",
				AllFieldCases.class);

		// Verification
		assertEquals(1, test.aliasValues.keySet().size());
		assertEquals("a String", test.aliasValues.get("nameAlias"));
		assertEquals("a String", test.getAliasValue("nameAlias"));
	}

	private Map<Class<?>, Map<String, Field>> getAliasFields(Class<?> clazz, String aliasName, String fieldName)
			throws NoSuchFieldException {
		Map<String, Field> fields = new HashMap<>();
		fields.put(aliasName, clazz.getDeclaredField(fieldName));
		//
		Map<Class<?>, Map<String, Field>> aliasFields = new HashMap<>();
		aliasFields.put(clazz, fields);
		return aliasFields;
	}
}
