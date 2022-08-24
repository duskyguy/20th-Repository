/** Generated by the default template from graphql-java-generator */
package com.graphql_java_generator.domain.server.allGraphQLCases;

import java.util.HashMap;
import java.util.Map;


import com.graphql_java_generator.annotation.GraphQLNonScalar;
import com.graphql_java_generator.annotation.GraphQLObjectType;
import com.graphql_java_generator.annotation.GraphQLScalar;
import java.util.List;





/**
 *
 * @author generated by graphql-java-generator
 * @see <a href="https://github.com/graphql-java-generator/graphql-java-generator">https://github.com/graphql-java-generator/graphql-java-generator</a>
 */

@GraphQLObjectType("Human")
@SuppressWarnings("unused")
public class Human 
	implements Character, Commented, WithID, AnyCharacter{


	public Human(){
		// No action
	}

	
	
	@GraphQLScalar(fieldName = "id", graphQLTypeSimpleName = "ID", javaClass = java.util.UUID.class)
	java.util.UUID id;


	@GraphQLScalar(fieldName = "name", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String name;


	
	@GraphQLNonScalar(fieldName = "bestFriend", graphQLTypeSimpleName = "Character", javaClass = Character.class)
	Character bestFriend;


	
	@GraphQLNonScalar(fieldName = "friends", graphQLTypeSimpleName = "Character", javaClass = Character.class)
	List<Character> friends;


	@GraphQLScalar(fieldName = "nbComments", graphQLTypeSimpleName = "Int", javaClass = java.lang.Integer.class)
	java.lang.Integer nbComments;


	
	@GraphQLScalar(fieldName = "comments", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	List<java.lang.String> comments;


	
	@GraphQLScalar(fieldName = "appearsIn", graphQLTypeSimpleName = "Episode", javaClass = Episode.class)
	List<Episode> appearsIn;


	@GraphQLScalar(fieldName = "homePlanet", graphQLTypeSimpleName = "String", javaClass = java.lang.String.class)
	java.lang.String homePlanet;




	/**
	 */
	@Override
	public void setId(java.util.UUID id) {
		if (id == null || id instanceof java.util.UUID) {
			this.id = (java.util.UUID) id;
		} else {
			throw new IllegalArgumentException("The given id should be an instance of java.util.UUID, but is an instance of "
					+ id.getClass().getName());
		}
	}
 

	/**
	 */
	@Override
	public java.util.UUID getId() {
		return id;
	}


	/**
	 */
	@Override
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

	public void setBestFriend(Character bestFriend) {
		this.bestFriend = bestFriend;
	}

	public Character getBestFriend() {
		return bestFriend;
	}
		


	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setFriends(List<Character> friends) {
		if (friends == null || friends instanceof List) {
			this.friends = (List<Character>) (Object) friends;
		} else {
			throw new IllegalArgumentException("The given friends should be an instance of List<Character>, but is an instance of "
					+ friends.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Character> getFriends() {
		return (List<Character>) (Object) friends;
	}

	/**
	 */
	public List<Character> getFriendsCharacter() {
		return friends;
	}


	/**
	 */
	@Override
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
	public void setAppearsIn(List<Episode> appearsIn) {
		if (appearsIn == null || appearsIn instanceof List) {
			this.appearsIn = (List<Episode>) (Object) appearsIn;
		} else {
			throw new IllegalArgumentException("The given appearsIn should be an instance of List<Episode>, but is an instance of "
					+ appearsIn.getClass().getName());
		}
	}
 

 	/**
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Episode> getAppearsIn() {
		return (List<Episode>) (Object) appearsIn;
	}

	/**
	 */
	public List<Episode> getAppearsInEpisode() {
		return appearsIn;
	}

	public void setHomePlanet(java.lang.String homePlanet) {
		this.homePlanet = homePlanet;
	}

	public java.lang.String getHomePlanet() {
		return homePlanet;
	}
		

     public String toString() {
        return "Human {"
				+ "id: " + id
				+ ", "
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
		private java.util.UUID id;
		private java.lang.String name;
		private Character bestFriend;
		private List<Character> friends;
		private java.lang.Integer nbComments;
		private List<java.lang.String> comments;
		private List<Episode> appearsIn;
		private java.lang.String homePlanet;

		public Builder withId(java.util.UUID id) {
			this.id = id;
			return this;
		}
		public Builder withName(java.lang.String name) {
			this.name = name;
			return this;
		}
		public Builder withBestFriend(Character bestFriend) {
			this.bestFriend = bestFriend;
			return this;
		}
		public Builder withFriends(List<Character> friends) {
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

		public Human build() {
			Human _object = new Human();
			_object.setId(id);
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
