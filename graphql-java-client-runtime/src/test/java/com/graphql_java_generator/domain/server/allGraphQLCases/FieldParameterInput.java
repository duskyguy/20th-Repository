/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.Date;

import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href=
 *      "https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("FieldParameterInput")
public class FieldParameterInput {

	public FieldParameterInput() {
		// No action
	}

	@GraphQLScalar(fieldName = "uppercase", graphQLTypeSimpleName = "Boolean", javaClass = Boolean.class)
	Boolean uppercase;

	@GraphQLScalar(fieldName = "date", graphQLTypeSimpleName = "Date", javaClass = Date.class)
	Date date;

	public void setUppercase(Boolean uppercase) {
		this.uppercase = uppercase;
	}

	public Boolean getUppercase() {
		return uppercase;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "FieldParameterInput {" + "uppercase: " + uppercase + ", " + "date: " + date + "}";
	}

	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder
	 */
	public static class Builder {
		private Boolean uppercase;
		private Date date;

		public Builder withUppercase(Boolean uppercase) {
			this.uppercase = uppercase;
			return this;
		}

		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}

		public FieldParameterInput build() {
			FieldParameterInput _object = new FieldParameterInput();
			_object.setUppercase(uppercase);
			_object.setDate(date);
			return _object;
		}
	}
}