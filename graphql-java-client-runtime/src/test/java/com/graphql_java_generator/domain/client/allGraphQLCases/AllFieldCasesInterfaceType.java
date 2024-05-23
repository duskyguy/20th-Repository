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
 *  A concrete class that just implements the above interface
 *  As we added a field in this interface, we need to add this field into every type that implements it
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLObjectType("AllFieldCasesInterfaceType")
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("unused")
public class AllFieldCasesInterfaceType 
	implements AllFieldCasesInterface, WithID{


	/**
	 * This map contains the deserialized values for the alias, as parsed from the json response from the GraphQL
	 * server. The key is the alias name, the value is the deserialiazed value (taking into account custom scalars,
	 * lists, ...)
	 */
	@com.graphql_java_generator.annotation.GraphQLIgnore
	Map<String, Object> aliasValues = new HashMap<>();

	public AllFieldCasesInterfaceType(){
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
	@GraphQLScalar(fieldName = "age", graphQLTypeSimpleName = "Long", javaClass = java.lang.Long.class)
	java.lang.Long age;


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


	/**
	 *  @RelayConnection should be but is not applied on the friends field (this allows the unit test that checks that a warning is correctly generated)
	 */
	@JsonProperty("friends")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListHuman.class)
	@GraphQLNonScalar(fieldName = "friends", graphQLTypeSimpleName = "Human", javaClass = Human.class)
	List<Human> friends;


	@JsonProperty("oneWithIdSubType")
	@GraphQLNonScalar(fieldName = "oneWithIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	AllFieldCasesWithIdSubtype oneWithIdSubType;


	@JsonProperty("listWithIdSubTypes")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListAllFieldCasesWithIdSubtype.class)
	@GraphQLInputParameters(names = {"nbItems", "uppercaseName", "textToAppendToTheForname"}, types = {"Int", "Boolean", "String"}, mandatories = {true, false, false}, listDepths = {0, 0, 0}, itemsMandatory = {false, false, false})
	@GraphQLNonScalar(fieldName = "listWithIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtype", javaClass = AllFieldCasesWithIdSubtype.class)
	List<AllFieldCasesWithIdSubtype> listWithIdSubTypes;


	@JsonProperty("oneWithoutIdSubType")
	@GraphQLInputParameters(names = {"input"}, types = {"FieldParameterInput"}, mandatories = {false}, listDepths = {0}, itemsMandatory = {false})
	@GraphQLNonScalar(fieldName = "oneWithoutIdSubType", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	AllFieldCasesWithoutIdSubtype oneWithoutIdSubType;


	@JsonProperty("listWithoutIdSubTypes")
	@JsonDeserialize(using = CustomJacksonDeserializers.ListAllFieldCasesWithoutIdSubtype.class)
	@GraphQLInputParameters(names = {"nbItems", "input", "textToAppendToTheForname"}, types = {"Int", "FieldParameterInput", "String"}, mandatories = {true, false, false}, listDepths = {0, 0, 0}, itemsMandatory = {false, false, false})
	@GraphQLNonScalar(fieldName = "listWithoutIdSubTypes", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtype", javaClass = AllFieldCasesWithoutIdSubtype.class)
	List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes;


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


	/**
	 */
	@Override
	@JsonIgnore
	public void setName(java.lang.String name) {
		if (name == null || name instanceof java.lang.String) {
			this.name = (java.lang.String) name;
		} else {
			throw new IllegalArgumentException("The given name should be an instance of java.lang.String, but is an instance of "
					+ name.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.lang.String getName() {
		return name;
	}


	/**
	 */
	@Override
	@JsonIgnore
	public void setForname(java.lang.String forname) {
		if (forname == null || forname instanceof java.lang.String) {
			this.forname = (java.lang.String) forname;
		} else {
			throw new IllegalArgumentException("The given forname should be an instance of java.lang.String, but is an instance of "
					+ forname.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.lang.String getForname() {
		return forname;
	}


	/**
	 */
	@Override
	@JsonIgnore
	public void setAge(java.lang.Long age) {
		if (age == null || age instanceof java.lang.Long) {
			this.age = (java.lang.Long) age;
		} else {
			throw new IllegalArgumentException("The given age should be an instance of java.lang.Long, but is an instance of "
					+ age.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.lang.Long getAge() {
		return age;
	}


	/**
	 */
	@Override
	@JsonIgnore
	public void setNbComments(java.lang.Integer nbComments) {
		if (nbComments == null || nbComments instanceof java.lang.Integer) {
			this.nbComments = (java.lang.Integer) nbComments;
		} else {
			throw new IllegalArgumentException("The given nbComments should be an instance of java.lang.Integer, but is an instance of "
					+ nbComments.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.lang.Integer getNbComments() {
		return nbComments;
	}


	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setComments(List<java.lang.String> comments) {
		if (comments == null || comments instanceof List) {
			this.comments = (List<java.lang.String>) (Object) comments;
		} else {
			throw new IllegalArgumentException("The given comments should be an instance of List<java.lang.String>, but is an instance of "
					+ comments.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<java.lang.String> getComments() {
		return (List<java.lang.String>) (Object) comments;
	}

	/**
	 */
	public List<java.lang.String> getCommentsString() {
		return comments;
	}


	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setBooleans(List<java.lang.Boolean> booleans) {
		if (booleans == null || booleans instanceof List) {
			this.booleans = (List<java.lang.Boolean>) (Object) booleans;
		} else {
			throw new IllegalArgumentException("The given booleans should be an instance of List<java.lang.Boolean>, but is an instance of "
					+ booleans.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<java.lang.Boolean> getBooleans() {
		return (List<java.lang.Boolean>) (Object) booleans;
	}

	/**
	 */
	public List<java.lang.Boolean> getBooleansBoolean() {
		return booleans;
	}


	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setAliases(List<java.lang.String> aliases) {
		if (aliases == null || aliases instanceof List) {
			this.aliases = (List<java.lang.String>) (Object) aliases;
		} else {
			throw new IllegalArgumentException("The given aliases should be an instance of List<java.lang.String>, but is an instance of "
					+ aliases.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<java.lang.String> getAliases() {
		return (List<java.lang.String>) (Object) aliases;
	}

	/**
	 */
	public List<java.lang.String> getAliasesString() {
		return aliases;
	}


	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setPlanets(List<java.lang.String> planets) {
		if (planets == null || planets instanceof List) {
			this.planets = (List<java.lang.String>) (Object) planets;
		} else {
			throw new IllegalArgumentException("The given planets should be an instance of List<java.lang.String>, but is an instance of "
					+ planets.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<java.lang.String> getPlanets() {
		return (List<java.lang.String>) (Object) planets;
	}

	/**
	 */
	public List<java.lang.String> getPlanetsString() {
		return planets;
	}


	/**
	 *  @RelayConnection should be but is not applied on the friends field (this allows the unit test that checks that a warning is correctly generated)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setFriends(List<Human> friends) {
		if (friends == null || friends instanceof List) {
			this.friends = (List<Human>) (Object) friends;
		} else {
			throw new IllegalArgumentException("The given friends should be an instance of List<Human>, but is an instance of "
					+ friends.getClass().getName());
		}
	}
 

 	/**
	 *  @RelayConnection should be but is not applied on the friends field (this allows the unit test that checks that a warning is correctly generated)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Human> getFriends() {
		return (List<Human>) (Object) friends;
	}

	/**
	 *  @RelayConnection should be but is not applied on the friends field (this allows the unit test that checks that a warning is correctly generated)
	 */
	public List<Human> getFriendsHuman() {
		return friends;
	}


	/**
	 */
	@Override
	@JsonIgnore
	public void setOneWithIdSubType(AllFieldCasesWithIdSubtype oneWithIdSubType) {
		if (oneWithIdSubType == null || oneWithIdSubType instanceof AllFieldCasesWithIdSubtype) {
			this.oneWithIdSubType = (AllFieldCasesWithIdSubtype) oneWithIdSubType;
		} else {
			throw new IllegalArgumentException("The given oneWithIdSubType should be an instance of AllFieldCasesWithIdSubtype, but is an instance of "
					+ oneWithIdSubType.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public AllFieldCasesWithIdSubtype getOneWithIdSubType() {
		return oneWithIdSubType;
	}


	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setListWithIdSubTypes(List<AllFieldCasesWithIdSubtype> listWithIdSubTypes) {
		if (listWithIdSubTypes == null || listWithIdSubTypes instanceof List) {
			this.listWithIdSubTypes = (List<AllFieldCasesWithIdSubtype>) (Object) listWithIdSubTypes;
		} else {
			throw new IllegalArgumentException("The given listWithIdSubTypes should be an instance of List<AllFieldCasesWithIdSubtype>, but is an instance of "
					+ listWithIdSubTypes.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<AllFieldCasesWithIdSubtype> getListWithIdSubTypes() {
		return (List<AllFieldCasesWithIdSubtype>) (Object) listWithIdSubTypes;
	}

	/**
	 */
	public List<AllFieldCasesWithIdSubtype> getListWithIdSubTypesAllFieldCasesWithIdSubtype() {
		return listWithIdSubTypes;
	}


	/**
	 */
	@Override
	@JsonIgnore
	public void setOneWithoutIdSubType(AllFieldCasesWithoutIdSubtype oneWithoutIdSubType) {
		if (oneWithoutIdSubType == null || oneWithoutIdSubType instanceof AllFieldCasesWithoutIdSubtype) {
			this.oneWithoutIdSubType = (AllFieldCasesWithoutIdSubtype) oneWithoutIdSubType;
		} else {
			throw new IllegalArgumentException("The given oneWithoutIdSubType should be an instance of AllFieldCasesWithoutIdSubtype, but is an instance of "
					+ oneWithoutIdSubType.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public AllFieldCasesWithoutIdSubtype getOneWithoutIdSubType() {
		return oneWithoutIdSubType;
	}


	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	@JsonIgnore
	public void setListWithoutIdSubTypes(List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes) {
		if (listWithoutIdSubTypes == null || listWithoutIdSubTypes instanceof List) {
			this.listWithoutIdSubTypes = (List<AllFieldCasesWithoutIdSubtype>) (Object) listWithoutIdSubTypes;
		} else {
			throw new IllegalArgumentException("The given listWithoutIdSubTypes should be an instance of List<AllFieldCasesWithoutIdSubtype>, but is an instance of "
					+ listWithoutIdSubTypes.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<AllFieldCasesWithoutIdSubtype> getListWithoutIdSubTypes() {
		return (List<AllFieldCasesWithoutIdSubtype>) (Object) listWithoutIdSubTypes;
	}

	/**
	 */
	public List<AllFieldCasesWithoutIdSubtype> getListWithoutIdSubTypesAllFieldCasesWithoutIdSubtype() {
		return listWithoutIdSubTypes;
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
        return "AllFieldCasesInterfaceType {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
				+ ", "
				+ "forname: " + forname
				+ ", "
				+ "age: " + age
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
				+ "oneWithIdSubType: " + oneWithIdSubType
				+ ", "
				+ "listWithIdSubTypes: " + listWithIdSubTypes
				+ ", "
				+ "oneWithoutIdSubType: " + oneWithoutIdSubType
				+ ", "
				+ "listWithoutIdSubTypes: " + listWithoutIdSubTypes
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
		private java.lang.Integer nbComments;
		private List<java.lang.String> comments;
		private List<java.lang.Boolean> booleans;
		private List<java.lang.String> aliases;
		private List<java.lang.String> planets;
		private List<Human> friends;
		private AllFieldCasesWithIdSubtype oneWithIdSubType;
		private List<AllFieldCasesWithIdSubtype> listWithIdSubTypes;
		private AllFieldCasesWithoutIdSubtype oneWithoutIdSubType;
		private List<AllFieldCasesWithoutIdSubtype> listWithoutIdSubTypes;
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
		public Builder withExtendedField(java.lang.String extendedField) {
			this.extendedField = extendedField;
			return this;
		}

		public AllFieldCasesInterfaceType build() {
			AllFieldCasesInterfaceType _object = new AllFieldCasesInterfaceType();
			_object.setId(id);
			_object.setName(name);
			_object.setForname(forname);
			_object.setAge(age);
			_object.setNbComments(nbComments);
			_object.setComments(comments);
			_object.setBooleans(booleans);
			_object.setAliases(aliases);
			_object.setPlanets(planets);
			_object.setFriends(friends);
			_object.setOneWithIdSubType(oneWithIdSubType);
			_object.setListWithIdSubTypes(listWithIdSubTypes);
			_object.setOneWithoutIdSubType(oneWithoutIdSubType);
			_object.setListWithoutIdSubTypes(listWithoutIdSubTypes);
			_object.setExtendedField(extendedField);
			_object.set__typename("AllFieldCasesInterfaceType");
			return _object;
		}
	}
}