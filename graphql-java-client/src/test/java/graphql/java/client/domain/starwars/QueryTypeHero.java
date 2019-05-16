package graphql.java.client.domain.starwars;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author generated by graphql-maven-plugin
 * @See https://github.com/graphql-java-generator/graphql-java-generator
 */
public class QueryTypeHero {

	@JsonDeserialize(as = CharacterImpl.class)
	Character hero;

	public void setHero(Character hero) {
		this.hero = hero;
	}

	public Character getHero() {
		return hero;
	}
	
    public String toString() {
        return "QueryTypeHero {hero: " + hero + "}";
    }
}
