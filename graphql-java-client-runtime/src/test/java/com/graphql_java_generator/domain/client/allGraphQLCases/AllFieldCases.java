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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.graphql_java_generator.annotation.GraphQLInputParameters;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.List;

/**
 *  This type is a clone of the InterfaceAllFieldCases interface. 
 *  Both should contains all possible combinations of parameters, data type, list, mandatory field or items...
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("AllFieldCases")
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("unused")
public class AllFieldCases 
	implements WithID, interfaceToTestExtendKeyword{


	/**
	 * This map contains the deserialized values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public AllFieldCases(){
		// No action
	}

	@JsonProperty("id")
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = java.lang.String.class)
	java.lang.String id;


	@JsonProperty("name")
	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String name;


	@JsonProperty("forname")
	@GraphQLInputParameters(names = {"uppercase", "textToAppendToTheForname"}, types = {"Boolean", "String"}, mandatories = {false, false}, listDepths = {0, 0}, itemsMandatory = {false, false})
	@GraphQLScalar(fieldName = "forname", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String forname;


	@JsonProperty("age")
	@JsonDeserialize(using = CustomJacksonDeserializers.Long.class)
	@GraphQLInputParameters(names = {"unit"}, types = {"Unit"}, mandatories = {false}, listDepths = {0}, itemsMandatory = {false})
	@GraphQLScalar(fieldName = "age", graphQLTypeSimpleName = "Long", javaClass = java.lang.Long.class)
	java.lang.Long age;


	@JsonProperty("aFloat")
	@GraphQLScalar(fieldName = "aFloat", graphQLTypeSimpleName = "Float", javaClass = java.lang.Double.class)
	java.lang.Double aFloat;


	@JsonProperty("date")
	@JsonDeserialize(using = CustomJacksonDeserializers.Date.class)
	@GraphQLScalar(fieldName = "date", graphQLTypeSimpleName = "Date", javaClass = java.util.Date.class)
	java.util.Date date;


	@JsonProperty("dateTime")
	@JsonDeserialize(using = CustomJacksonDeserializers.DateTime.class)
	@GraphQLScalar(fieldName = "dateTime", graphQLTypeSimpleName = "DateTime", javaClass = java.time.OffsetDateTime.class)
	java.time.OffsetDateTime dateTime;


	@JsonProperty("dates")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListDate.class)
	@GraphQLScalar(fieldName = "dates", graphQLTypeSimpleName = "Date", javaClass = java.util.Date.class)
	List<java.util.Date> dates;


	@JsonProperty("nbComments")
	@GraphQLScalar(fieldName = "nbComments", graphQLTypeSimpleName = "Int", javaClass = java.lang.Integer.class)
	java.lang.Integer nbComments;


	@JsonProperty("comments")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListString.class)
	@GraphQLScalar(fieldName = "comments", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> comments;


	@JsonProperty("booleans")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListBoolean.class)
	@GraphQLScalar(fieldName = "booleans", graphQLTypeSimpleName = "Boolean", javaClass = java.lang.Boolean.class)
	List<java.lang.Boolean> booleans;


	@JsonProperty("aliases")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListString.class)
	@GraphQLScalar(fieldName = "aliases", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> aliases;


	@JsonProperty("planets")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListString.class)
	@GraphQLScalar(fieldName = "planets", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> planets;


	@JsonProperty("friends")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListHuman.class)
	@GraphQLNonScalar(fieldName = "friends", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	List<Human> friends;


	@JsonProperty("matrix")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListListFloat.class)
	@GraphQLScalar(fieldName = "matrix", graphQLTypeSimpleName = "Float", javaClass = java.lang.Double.class)
	List<List<java.lang.Double>> matrix;


	@JsonProperty("oneWithIdSubType")
	@GraphQLInputParameters(names = {"uppercase"}, types = {"Boolean"}, mandatories = {false}, listDepths = {0}, itemsMandatory = {false})
	@GraphQLNonScalar(fieldName = "oneWithIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	AllFieldCasesWithIdSubtype oneWithIdSubType;


	@JsonProperty("listWithIdSubTypes")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListAllFieldCasesWithIdSubtype.class)
	@GraphQLInputParameters(names = {"nbItems", "date", "dates", "uppercaseName", "textToAppendToTheForname"}, types = {"Long", "Date", "Date", "Boolean", "String"}, mandatories = {true, false, true, false, false}, listDepths = {0, 0, 1, 0, 0}, itemsMandatory = {false, false, false, false, false})
	@GraphQLNonScalar(fieldName = "listWithIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	List<AllFieldCasesWithIdSubtype> listWithIdSubTypes;


	@JsonProperty("oneWithoutIdSubType")
	@GraphQLInputParameters(names = {"input"}, types = {"FieldParameterInput"}, mandatories = {false}, listDepths = {0}, itemsMandatory = {false})
	@GraphQLNonScalar(fieldName = "oneWithoutIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	AllFieldCasesWithoutIdSubtype oneWithoutIdSubType;


	@JsonProperty("listWithoutIdSubTypes")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListAllFieldCasesWithoutIdSubtype.class)
	@GraphQLInputParameters(names = {"nbItems", "input", "textToAppendToTheForname"}, types = {"Long", "FieldParameterInput", "String"}, mandatories = {true, false, false}, listDepths = {0, 0, 0}, itemsMandatory = {false, false, false})
	@GraphQLNonScalar(fieldName = "listWithoutIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes;


	@JsonProperty("issue65")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListAllFieldCasesWithoutIdSubtype.class)
	@GraphQLInputParameters(names = {"inputs"}, types = {"FieldParameterInput"}, mandatories = {false}, listDepths = {1}, itemsMandatory = {true})
	@GraphQLNonScalar(fieldName = "issue65", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	List<AllFieldCasesWithoutIdSubtype> issue65;


	@JsonProperty("issue66")
	@GraphQLInputParameters(names = {"input"}, types = {"AllFieldCasesInput"}, mandatories = {false}, listDepths = {1}, itemsMandatory = {false})
	@GraphQLNonScalar(fieldName = "issue66", graphQLTypeSimpleName = "AllFieldCases", javaClass = AllFieldCases.class)
	AllFieldCases issue66;


	@JsonProperty("extendedField")
	@GraphQLScalar(fieldName = "extendedField", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String extendedField;


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

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return name;
	}
		

	public void setForname(java.lang.String forname) {
		this.forname = forname;
	}

	public java.lang.String getForname() {
		return forname;
	}
		

	public void setAge(java.lang.Long age) {
		this.age = age;
	}

	public java.lang.Long getAge() {
		return age;
	}
		

	public void setAFloat(java.lang.Double aFloat) {
		this.aFloat = aFloat;
	}

	public java.lang.Double getAFloat() {
		return aFloat;
	}
		

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public java.util.Date getDate() {
		return date;
	}
		

	public void setDateTime(java.time.OffsetDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public java.time.OffsetDateTime getDateTime() {
		return dateTime;
	}
		

	public void setDates(List<java.util.Date> dates) {
		this.dates = dates;
	}

	public List<java.util.Date> getDates() {
		return dates;
	}
		

	public void setNbComments(java.lang.Integer nbComments) {
		this.nbComments = nbComments;
	}

	public java.lang.Integer getNbComments() {
		return nbComments;
	}
		

	public void setComments(List<java.lang.String> comments) {
		this.comments = comments;
	}

	public List<java.lang.String> getComments() {
		return comments;
	}
		

	public void setBooleans(List<java.lang.Boolean> booleans) {
		this.booleans = booleans;
	}

	public List<java.lang.Boolean> getBooleans() {
		return booleans;
	}
		

	public void setAliases(List<java.lang.String> aliases) {
		this.aliases = aliases;
	}

	public List<java.lang.String> getAliases() {
		return aliases;
	}
		

	public void setPlanets(List<java.lang.String> planets) {
		this.planets = planets;
	}

	public List<java.lang.String> getPlanets() {
		return planets;
	}
		

	public void setFriends(List<Human> friends) {
		this.friends = friends;
	}

	public List<Human> getFriends() {
		return friends;
	}
		

	public void setMatrix(List<List<java.lang.Double>> matrix) {
		this.matrix = matrix;
	}

	public List<List<java.lang.Double>> getMatrix() {
		return matrix;
	}
		

	public void setOneWithIdSubType(AllFieldCasesWithIdSubtype oneWithIdSubType) {
		this.oneWithIdSubType = oneWithIdSubType;
	}

	public AllFieldCasesWithIdSubtype getOneWithIdSubType() {
		return oneWithIdSubType;
	}
		

	public void setListWithIdSubTypes(List<AllFieldCasesWithIdSubtype> listWithIdSubTypes) {
		this.listWithIdSubTypes = listWithIdSubTypes;
	}

	public List<AllFieldCasesWithIdSubtype> getListWithIdSubTypes() {
		return listWithIdSubTypes;
	}
		

	public void setOneWithoutIdSubType(AllFieldCasesWithoutIdSubtype oneWithoutIdSubType) {
		this.oneWithoutIdSubType = oneWithoutIdSubType;
	}

	public AllFieldCasesWithoutIdSubtype getOneWithoutIdSubType() {
		return oneWithoutIdSubType;
	}
		

	public void setListWithoutIdSubTypes(List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes) {
		this.listWithoutIdSubTypes = listWithoutIdSubTypes;
	}

	public List<AllFieldCasesWithoutIdSubtype> getListWithoutIdSubTypes() {
		return listWithoutIdSubTypes;
	}
		

	public void setIssue65(List<AllFieldCasesWithoutIdSubtype> issue65) {
		this.issue65 = issue65;
	}

	public List<AllFieldCasesWithoutIdSubtype> getIssue65() {
		return issue65;
	}
		

	public void setIssue66(AllFieldCases issue66) {
		this.issue66 = issue66;
	}

	public AllFieldCases getIssue66() {
		return issue66;
	}
		


	/**
	 */
	@Override
	@JsonIgnore
	public void setExtendedField(java.lang.String extendedField) {
		if (extendedField == null || extendedField instanceof java.lang.String) {
			this.extendedField = (java.lang.String) extendedField;
		} else {
			throw new IllegalArgumentException("The given extendedField should be an instance of java.lang.String, but is an instance of "
					+ extendedField.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.lang.String getExtendedField() {
		return extendedField;
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
        return "AllFieldCases {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
				+ ", "
				+ "forname: " + forname
				+ ", "
				+ "age: " + age
				+ ", "
				+ "aFloat: " + aFloat
				+ ", "
				+ "date: " + date
				+ ", "
				+ "dateTime: " + dateTime
				+ ", "
				+ "dates: " + dates
				+ ", "
				+ "nbComments: " + nbComments
				+ ", "
				+ "comments: " + comments
				+ ", "
				+ "booleans: " + booleans
				+ ", "
				+ "aliases: " + aliases
				+ ", "
				+ "planets: " + planets
				+ ", "
				+ "friends: " + friends
				+ ", "
				+ "matrix: " + matrix
				+ ", "
				+ "oneWithIdSubType: " + oneWithIdSubType
				+ ", "
				+ "listWithIdSubTypes: " + listWithIdSubTypes
				+ ", "
				+ "oneWithoutIdSubType: " + oneWithoutIdSubType
				+ ", "
				+ "listWithoutIdSubTypes: " + listWithoutIdSubTypes
				+ ", "
				+ "issue65: " + issue65
				+ ", "
				+ "issue66: " + issue66
				+ ", "
				+ "extendedField: " + extendedField
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
		private java.lang.String name;
		private java.lang.String forname;
		private java.lang.Long age;
		private java.lang.Double aFloat;
		private java.util.Date date;
		private java.time.OffsetDateTime dateTime;
		private List<java.util.Date> dates;
		private java.lang.Integer nbComments;
		private List<java.lang.String> comments;
		private List<java.lang.Boolean> booleans;
		private List<java.lang.String> aliases;
		private List<java.lang.String> planets;
		private List<Human> friends;
		private List<List<java.lang.Double>> matrix;
		private AllFieldCasesWithIdSubtype oneWithIdSubType;
		private List<AllFieldCasesWithIdSubtype> listWithIdSubTypes;
		private AllFieldCasesWithoutIdSubtype oneWithoutIdSubType;
		private List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes;
		private List<AllFieldCasesWithoutIdSubtype> issue65;
		private AllFieldCases issue66;
		private java.lang.String extendedField;

		public Builder withId(java.lang.String id) {
			this.id = id;
			return this;
		}
		public Builder withName(java.lang.String name) {
			this.name = name;
			return this;
		}
		public Builder withForname(java.lang.String forname) {
			this.forname = forname;
			return this;
		}
		public Builder withAge(java.lang.Long age) {
			this.age = age;
			return this;
		}
		public Builder withAFloat(java.lang.Double aFloat) {
			this.aFloat = aFloat;
			return this;
		}
		public Builder withDate(java.util.Date date) {
			this.date = date;
			return this;
		}
		public Builder withDateTime(java.time.OffsetDateTime dateTime) {
			this.dateTime = dateTime;
			return this;
		}
		public Builder withDates(List<java.util.Date> dates) {
			this.dates = dates;
			return this;
		}
		public Builder withNbComments(java.lang.Integer nbComments) {
			this.nbComments = nbComments;
			return this;
		}
		public Builder withComments(List<java.lang.String> comments) {
			this.comments = comments;
			return this;
		}
		public Builder withBooleans(List<java.lang.Boolean> booleans) {
			this.booleans = booleans;
			return this;
		}
		public Builder withAliases(List<java.lang.String> aliases) {
			this.aliases = aliases;
			return this;
		}
		public Builder withPlanets(List<java.lang.String> planets) {
			this.planets = planets;
			return this;
		}
		public Builder withFriends(List<Human> friends) {
			this.friends = friends;
			return this;
		}
		public Builder withMatrix(List<List<java.lang.Double>> matrix) {
			this.matrix = matrix;
			return this;
		}
		public Builder withOneWithIdSubType(AllFieldCasesWithIdSubtype oneWithIdSubType) {
			this.oneWithIdSubType = oneWithIdSubType;
			return this;
		}
		public Builder withListWithIdSubTypes(List<AllFieldCasesWithIdSubtype> listWithIdSubTypes) {
			this.listWithIdSubTypes = listWithIdSubTypes;
			return this;
		}
		public Builder withOneWithoutIdSubType(AllFieldCasesWithoutIdSubtype oneWithoutIdSubType) {
			this.oneWithoutIdSubType = oneWithoutIdSubType;
			return this;
		}
		public Builder withListWithoutIdSubTypes(List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes) {
			this.listWithoutIdSubTypes = listWithoutIdSubTypes;
			return this;
		}
		public Builder withIssue65(List<AllFieldCasesWithoutIdSubtype> issue65) {
			this.issue65 = issue65;
			return this;
		}
		public Builder withIssue66(AllFieldCases issue66) {
			this.issue66 = issue66;
			return this;
		}
		public Builder withExtendedField(java.lang.String extendedField) {
			this.extendedField = extendedField;
			return this;
		}

		public AllFieldCases build() {
			AllFieldCases _object = new AllFieldCases();
			_object.setId(id);
			_object.setName(name);
			_object.setForname(forname);
			_object.setAge(age);
			_object.setAFloat(aFloat);
			_object.setDate(date);
			_object.setDateTime(dateTime);
			_object.setDates(dates);
			_object.setNbComments(nbComments);
			_object.setComments(comments);
			_object.setBooleans(booleans);
			_object.setAliases(aliases);
			_object.setPlanets(planets);
			_object.setFriends(friends);
			_object.setMatrix(matrix);
			_object.setOneWithIdSubType(oneWithIdSubType);
			_object.setListWithIdSubTypes(listWithIdSubTypes);
			_object.setOneWithoutIdSubType(oneWithoutIdSubType);
			_object.setListWithoutIdSubTypes(listWithoutIdSubTypes);
			_object.setIssue65(issue65);
			_object.setIssue66(issue66);
			_object.setExtendedField(extendedField);
			_object.set__typename("AllFieldCases");
			return _object;
		}
	}
}
