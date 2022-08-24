/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;


import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.List;

/**
 * #############################################################################################################
 * ###############  ALL GRAPHQL CASES TEST CASES################################################################
 * #############################################################################################################
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("AllFieldCasesInput")
@SuppressWarnings("unused")
public class AllFieldCasesInput 
{


	public AllFieldCasesInput(){
		// No action
	}

	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = java.util.UUID.class)
	java.util.UUID id;


	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String name;


	@GraphQLScalar(fieldName = "forname", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String forname;


	@GraphQLScalar(fieldName = "age", graphQLTypeSimpleName = "Long", javaClass = java.lang.Long.class)
	java.lang.Long age;


	@GraphQLScalar(fieldName = "date", graphQLTypeSimpleName = "Date", javaClass = java.util.Date.class)
	java.util.Date date;


	@GraphQLScalar(fieldName = "dateTime", graphQLTypeSimpleName = "DateTime", javaClass = java.time.OffsetDateTime.class)
	java.time.OffsetDateTime dateTime;


	@GraphQLScalar(fieldName = "dates", graphQLTypeSimpleName = "Date", javaClass = java.util.Date.class)
	List<java.util.Date> dates;


	@GraphQLScalar(fieldName = "nbComments", graphQLTypeSimpleName = "Int", javaClass = java.lang.Integer.class)
	java.lang.Integer nbComments;


	@GraphQLScalar(fieldName = "comments", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> comments;


	@GraphQLScalar(fieldName = "booleans", graphQLTypeSimpleName = "Boolean", javaClass = java.lang.Boolean.class)
	List<java.lang.Boolean> booleans;


	@GraphQLScalar(fieldName = "aliases", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> aliases;


	@GraphQLScalar(fieldName = "planets", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> planets;


	@GraphQLScalar(fieldName = "matrix", graphQLTypeSimpleName = "Float", javaClass = java.lang.Double.class)
	List<List<java.lang.Double>> matrix;


	@GraphQLNonScalar(fieldName = "withIdSubtype", graphQLTypeSimpleName = "AllFieldCasesWithIdSubtypeInput", javaClass = AllFieldCasesWithIdSubtypeInput.class)
	List<AllFieldCasesWithIdSubtypeInput> withIdSubtype;


	@GraphQLNonScalar(fieldName = "withoutIdSubtype", graphQLTypeSimpleName = "AllFieldCasesWithoutIdSubtypeInput", javaClass = AllFieldCasesWithoutIdSubtypeInput.class)
	List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype;


	@GraphQLScalar(fieldName = "extendedField", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String extendedField;



	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public java.util.UUID getId() {
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
		

	public void setMatrix(List<List<java.lang.Double>> matrix) {
		this.matrix = matrix;
	}

	public List<List<java.lang.Double>> getMatrix() {
		return matrix;
	}
		

	public void setWithIdSubtype(List<AllFieldCasesWithIdSubtypeInput> withIdSubtype) {
		this.withIdSubtype = withIdSubtype;
	}

	public List<AllFieldCasesWithIdSubtypeInput> getWithIdSubtype() {
		return withIdSubtype;
	}
		

	public void setWithoutIdSubtype(List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype) {
		this.withoutIdSubtype = withoutIdSubtype;
	}

	public List<AllFieldCasesWithoutIdSubtypeInput> getWithoutIdSubtype() {
		return withoutIdSubtype;
	}
		

	public void setExtendedField(java.lang.String extendedField) {
		this.extendedField = extendedField;
	}

	public java.lang.String getExtendedField() {
		return extendedField;
	}
		

     public String toString() {
        return "AllFieldCasesInput {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
				+ ", "
				+ "forname: " + forname
				+ ", "
				+ "age: " + age
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
				+ "matrix: " + matrix
				+ ", "
				+ "withIdSubtype: " + withIdSubtype
				+ ", "
				+ "withoutIdSubtype: " + withoutIdSubtype
				+ ", "
				+ "extendedField: " + extendedField
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
		private java.util.UUID id;
		private java.lang.String name;
		private java.lang.String forname;
		private java.lang.Long age;
		private java.util.Date date;
		private java.time.OffsetDateTime dateTime;
		private List<java.util.Date> dates;
		private java.lang.Integer nbComments;
		private List<java.lang.String> comments;
		private List<java.lang.Boolean> booleans;
		private List<java.lang.String> aliases;
		private List<java.lang.String> planets;
		private List<List<java.lang.Double>> matrix;
		private List<AllFieldCasesWithIdSubtypeInput> withIdSubtype;
		private List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype;
		private java.lang.String extendedField;

		public Builder withId(java.util.UUID id) {
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
		public Builder withMatrix(List<List<java.lang.Double>> matrix) {
			this.matrix = matrix;
			return this;
		}
		public Builder withWithIdSubtype(List<AllFieldCasesWithIdSubtypeInput> withIdSubtype) {
			this.withIdSubtype = withIdSubtype;
			return this;
		}
		public Builder withWithoutIdSubtype(List<AllFieldCasesWithoutIdSubtypeInput> withoutIdSubtype) {
			this.withoutIdSubtype = withoutIdSubtype;
			return this;
		}
		public Builder withExtendedField(java.lang.String extendedField) {
			this.extendedField = extendedField;
			return this;
		}

		public AllFieldCasesInput build() {
			AllFieldCasesInput _object = new AllFieldCasesInput();
			_object.setId(id);
			_object.setName(name);
			_object.setForname(forname);
			_object.setAge(age);
			_object.setDate(date);
			_object.setDateTime(dateTime);
			_object.setDates(dates);
			_object.setNbComments(nbComments);
			_object.setComments(comments);
			_object.setBooleans(booleans);
			_object.setAliases(aliases);
			_object.setPlanets(planets);
			_object.setMatrix(matrix);
			_object.setWithIdSubtype(withIdSubtype);
			_object.setWithoutIdSubtype(withoutIdSubtype);
			_object.setExtendedField(extendedField);
			return _object;
		}
	}
}
