/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;


import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLScalar;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("FieldParameterInput")
@SuppressWarnings("unused")
public class FieldParameterInput 
{


	public FieldParameterInput(){
		// No action
	}

	@GraphQLScalar(fieldName = "uppercase", graphQLTypeSimpleName = "Boolean", javaClass = java.lang.Boolean.class)
	java.lang.Boolean uppercase;


	@GraphQLScalar(fieldName = "date", graphQLTypeSimpleName = "Date", javaClass = java.util.Date.class)
	java.util.Date date;



	public void setUppercase(java.lang.Boolean uppercase) {
		this.uppercase = uppercase;
	}

	public java.lang.Boolean getUppercase() {
		return uppercase;
	}
		

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public java.util.Date getDate() {
		return date;
	}
		

     public String toString() {
        return "FieldParameterInput {"
				+ "uppercase: " + uppercase
				+ ", "
				+ "date: " + date
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
		private java.lang.Boolean uppercase;
		private java.util.Date date;

		public Builder withUppercase(java.lang.Boolean uppercase) {
			this.uppercase = uppercase;
			return this;
		}
		public Builder withDate(java.util.Date date) {
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
