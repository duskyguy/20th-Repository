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
@GraphQLInputType("HumanInput")
@SuppressWarnings("unused")
public class HumanInput 
{


	public HumanInput(){
		// No action
	}

	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String name;


	@GraphQLNonScalar(fieldName = "bestFriend", graphQLTypeSimpleName = "CharacterInput", javaClass = CharacterInput.class)
	CharacterInput bestFriend;


	@GraphQLNonScalar(fieldName = "friends", graphQLTypeSimpleName = "CharacterInput", javaClass = CharacterInput.class)
	List<CharacterInput> friends;


	@GraphQLScalar(fieldName = "nbComments", graphQLTypeSimpleName = "Int", javaClass = java.lang.Integer.class)
	java.lang.Integer nbComments;


	@GraphQLScalar(fieldName = "comments", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> comments;


	@GraphQLScalar(fieldName = "appearsIn", graphQLTypeSimpleName = "Episode", javaClass = Episode.class)
	List<Episode> appearsIn;


	@GraphQLScalar(fieldName = "homePlanet", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String homePlanet;



	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return name;
	}
		

	public void setBestFriend(CharacterInput bestFriend) {
		this.bestFriend = bestFriend;
	}

	public CharacterInput getBestFriend() {
		return bestFriend;
	}
		

	public void setFriends(List<CharacterInput> friends) {
		this.friends = friends;
	}

	public List<CharacterInput> getFriends() {
		return friends;
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
		

	public void setAppearsIn(List<Episode> appearsIn) {
		this.appearsIn = appearsIn;
	}

	public List<Episode> getAppearsIn() {
		return appearsIn;
	}
		

	public void setHomePlanet(java.lang.String homePlanet) {
		this.homePlanet = homePlanet;
	}

	public java.lang.String getHomePlanet() {
		return homePlanet;
	}
		

     public String toString() {
        return "HumanInput {"
				+ "name: " + name
				+ ", "
				+ "bestFriend: " + bestFriend
				+ ", "
				+ "friends: " + friends
				+ ", "
				+ "nbComments: " + nbComments
				+ ", "
				+ "comments: " + comments
				+ ", "
				+ "appearsIn: " + appearsIn
				+ ", "
				+ "homePlanet: " + homePlanet
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
		private CharacterInput bestFriend;
		private List<CharacterInput> friends;
		private java.lang.Integer nbComments;
		private List<java.lang.String> comments;
		private List<Episode> appearsIn;
		private java.lang.String homePlanet;

		public Builder withName(java.lang.String name) {
			this.name = name;
			return this;
		}
		public Builder withBestFriend(CharacterInput bestFriend) {
			this.bestFriend = bestFriend;
			return this;
		}
		public Builder withFriends(List<CharacterInput> friends) {
			this.friends = friends;
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
		public Builder withAppearsIn(List<Episode> appearsIn) {
			this.appearsIn = appearsIn;
			return this;
		}
		public Builder withHomePlanet(java.lang.String homePlanet) {
			this.homePlanet = homePlanet;
			return this;
		}

		public HumanInput build() {
			HumanInput _object = new HumanInput();
			_object.setName(name);
			_object.setBestFriend(bestFriend);
			_object.setFriends(friends);
			_object.setNbComments(nbComments);
			_object.setComments(comments);
			_object.setAppearsIn(appearsIn);
			_object.setHomePlanet(homePlanet);
			return _object;
		}
	}
}
