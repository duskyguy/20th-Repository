package com.graphql_java_generator.client.domain.starwars;

/**
 * @author generated by graphql-java-generator
 * @See https://github.com/graphql-java-generator/graphql-java-generator
 */
public class QueryTypeHuman {

	Human human;

	public void setHuman(Human human) {
		this.human = human;
	}

	public Human getHuman() {
		return human;
	}

	@Override
	public String toString() {
		return "QueryTypeHuman {human: " + human + "}";
	}
}
