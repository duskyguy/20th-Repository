package graphql.java.client.domain.starwars;

import java.util.List;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import graphql.java.client.annotation.GraphQLNonScalar;
import graphql.java.client.annotation.GraphQLScalar;

/**
 * @author generated by graphql-maven-plugin
 * @See https://github.com/graphql-java-generator/graphql-java-generator
 */

public class CharacterImpl implements Character {

	@GraphQLScalar(graphqlType = String.class)
	String id;
	
	@GraphQLScalar(graphqlType = String.class)
	String name;
	
	@GraphQLNonScalar(graphqlType = Character.class)
	@JsonDeserialize(contentAs = CharacterImpl.class)
	List<Character> friends;
	
	@GraphQLScalar(graphqlType = Episode.class)
	@JsonDeserialize(contentAs = Episode.class)
	List<Episode> appearsIn;
	

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setFriends(List<Character> friends) {
		this.friends = friends;
	}

	public List<Character> getFriends() {
		return friends;
	}
	
	public void setAppearsIn(List<Episode> appearsIn) {
		this.appearsIn = appearsIn;
	}

	public List<Episode> getAppearsIn() {
		return appearsIn;
	}
	
    public String toString() {
        return "CharacterImpl {"
				+ "id: " + id
				+ ", "
				+ "name: " + name
				+ ", "
				+ "friends: " + friends
				+ ", "
				+ "appearsIn: " + appearsIn
        		+ "}";
    }
}
