/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;


import com.graphql_java_generator.annotation.GraphQLInputType;
import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.List;

/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */
@GraphQLInputType("DroidInput")
@SuppressWarnings("unused")
public class DroidInput 
{


	public DroidInput(){
		// No action
	}

	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String name;


	@GraphQLNonScalar(fieldName = "friends", graphQLTypeSimpleName = "CharacterInput", javaClass = CharacterInput.class)
	List<CharacterInput> friends;


	@GraphQLScalar(fieldName = "appearsIn", graphQLTypeSimpleName = "Episode", javaClass = Episode.class)
	List<Episode> appearsIn;


	@GraphQLScalar(fieldName = "primaryFunction", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String primaryFunction;



	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return name;
	}
		

	public void setFriends(List<CharacterInput> friends) {
		this.friends = friends;
	}

	public List<CharacterInput> getFriends() {
		return friends;
	}
		

	public void setAppearsIn(List<Episode> appearsIn) {
		this.appearsIn = appearsIn;
	}

	public List<Episode> getAppearsIn() {
		return appearsIn;
	}
		

	public void setPrimaryFunction(java.lang.String primaryFunction) {
		this.primaryFunction = primaryFunction;
	}

	public java.lang.String getPrimaryFunction() {
		return primaryFunction;
	}
		

     public String toString() {
        return "DroidInput {"
				+ "name: " + name
				+ ", "
				+ "friends: " + friends
				+ ", "
				+ "appearsIn: " + appearsIn
				+ ", "
				+ "primaryFunction: " + primaryFunction
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
		private java.lang.String name;
		private List<CharacterInput> friends;
		private List<Episode> appearsIn;
		private java.lang.String primaryFunction;

		public Builder withName(java.lang.String name) {
			this.name = name;
			return this;
		}
		public Builder withFriends(List<CharacterInput> friends) {
			this.friends = friends;
			return this;
		}
		public Builder withAppearsIn(List<Episode> appearsIn) {
			this.appearsIn = appearsIn;
			return this;
		}
		public Builder withPrimaryFunction(java.lang.String primaryFunction) {
			this.primaryFunction = primaryFunction;
			return this;
		}

		public DroidInput build() {
			DroidInput _object = new DroidInput();
			_object.setName(name);
			_object.setFriends(friends);
			_object.setAppearsIn(appearsIn);
			_object.setPrimaryFunction(primaryFunction);
			return _object;
		}
	}
}