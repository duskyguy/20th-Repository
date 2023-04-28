package com.graphql_java_generator.mavenplugin.samples.simple.client.graphql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.generated.graphql.Character;
import com.generated.graphql.Droid;
import com.generated.graphql.Episode;
import com.generated.graphql.Human;
import com.generated.graphql.util.QueryTypeExecutor;
import com.graphql_java_generator.exception.GraphQLRequestExecutionException;
import com.graphql_java_generator.exception.GraphQLRequestPreparationException;
import com.graphql_java_generator.samples.simple.client.Queries;

/**
 * As it is suffixed by "IT", this is an integration test. Thus, it allows us to start the GraphQL StatWars server, see
 * the pom.xml file for details.
 * 
 * @author etienne-sf
 */
abstract class AbstractIT {

	QueryTypeExecutor queryType;
	Queries queries;

	@Test
	void test_heroFull() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// return queryType.hero("{id appearsIn name}", Episode.NEWHOPE);
		Character c = queries.heroFull();

		checkCharacter(c, "heroSimple", "00000000-0000-0000-0000-000000000001", "Bala-Tik", 0, Episode.JEDI);
	}

	@Test
	void test_heroPartial() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// return queryType.hero("{id appearsIn name}", Episode.NEWHOPE);
		Character c = queries.heroPartial(Episode.NEWHOPE);

		checkCharacter(c, "heroSimple", null, "BB-8", 0, Episode.NEWHOPE);
	}

	@Test
	void test_heroFriendsFriendsFriends() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// return queryType.hero("{id appearsIn friends {name friends {friends{id name
		// appearsIn}}}}", Episode.NEWHOPE);
		Character c = queries.heroFriendsFriendsFriends(Episode.NEWHOPE);

		checkCharacter(c, "testHeroFriendsFriendsFriends", "00000000-0000-0000-0000-000000000002", null, 2,
				Episode.NEWHOPE);

		Character friends_0 = c.getFriends().get(0);
		checkCharacter(friends_0, "testHeroFriendsFriendsFriends[friends_0]", null, "Poe Dameron", 0);

		Character friends_1 = c.getFriends().get(1);
		checkCharacter(friends_1, "testHeroFriendsFriendsFriends[friends_1]", null, "Luke Skywalker", 2);

		Character friends_1_0 = friends_1.getFriends().get(0); // "94", "Mara Jade"
		checkCharacter(friends_1_0, "testHeroFriendsFriendsFriends[friends_1_0]", null, null, 1);
		Character friends_1_0_0 = friends_1_0.getFriends().get(0);
		checkCharacter(friends_1_0_0, "testHeroFriendsFriendsFriends[friends_1_0]",
				"00000000-0000-0000-0000-000000000180", "Luke Skywalker", 0, Episode.EMPIRE);

		Character friends_1_1 = friends_1.getFriends().get(1); // "179", "Anakin Skywalker"
		checkCharacter(friends_1_1, "testHeroFriendsFriendsFriends[friends_1_0]", null, null, 1);
		Character friends_1_1_0 = friends_1_1.getFriends().get(0);
		checkCharacter(friends_1_1_0, "testHeroFriendsFriendsFriends[friends_1_0]",
				"00000000-0000-0000-0000-000000000008", "Obi-Wan Kenobi", 0, Episode.NEWHOPE);
	}

	@Test
	void test_humanFull() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// queryType.human("{id appearsIn homePlanet name}", "45");
		Human h = queries.humanFull("00000000-0000-0000-0000-000000000045");

		checkCharacter(h, "testHeroFriendsFriendsFriends[friends_1_0]", "00000000-0000-0000-0000-000000000045",
				"Joruus C'Baoth", 0, Episode.EMPIRE);
		assertEquals("Kashyyyk", h.getHomePlanet());
	}

	@Test
	void test_humanPartial() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// queryType.human("{appearsIn homePlanet name}", "45");
		Human h = queries.humanPartial("00000000-0000-0000-0000-000000000045");

		checkCharacter(h, "humanPartial", null, "Joruus C'Baoth", 0, Episode.EMPIRE);
		assertEquals("Kashyyyk", h.getHomePlanet());
	}

	@Test
	void test_humanFriendsFriendsFriends() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// queryType.human("{id appearsIn name friends {name friends {friends{id name
		// appearsIn}}}}", "180");
		Human h = queries.humanFriendsFriendsFriends("00000000-0000-0000-0000-000000000180");

		checkCharacter(h, "testHeroFriendsFriendsFriends[friends_1]", "00000000-0000-0000-0000-000000000180",
				"Luke Skywalker", 2, Episode.EMPIRE);
		assertNull(h.getHomePlanet());

		Character friends_0 = h.getFriends().get(0); // "94", "Mara Jade"
		checkCharacter(friends_0, "testHeroFriendsFriendsFriends[friends_0]", null, "Mara Jade", 1);
		//
		Character friends_0_0 = friends_0.getFriends().get(0); // "180", "Luke Skywalker"
		checkCharacter(friends_0_0, "testHeroFriendsFriendsFriends[friends_0]", null, null, 2);

		Character friends_1 = h.getFriends().get(1); // "179", "Anakin Skywalker"
		checkCharacter(friends_1, "testHeroFriendsFriendsFriends[friends_0]", null, "Anakin Skywalker", 1);
		Character friends_1_0 = friends_1.getFriends().get(0); // "8", "Obi-Wan Kenobi"
		checkCharacter(friends_1_0, "testHeroFriendsFriendsFriends[friends_0]", null, null, 4);
	}

	@Test
	void test_droidFull() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// queryType.droid("{id appearsIn primaryFunction name}", "3");
		Droid d = queries.droidFull("00000000-0000-0000-0000-000000000003");

		checkCharacter(d, "droidSimple", "00000000-0000-0000-0000-000000000003", "C-3PO", 0, Episode.EMPIRE);
		assertEquals("Function of C-3PO", d.getPrimaryFunction());
	}

	@Test
	void test_droidPartial() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// queryType.droid("{id appearsIn primaryFunction name}", "3");
		Droid d = queries.droidPartial("00000000-0000-0000-0000-000000000003");

		checkCharacter(d, "droidSimple", null, "C-3PO", 0, Episode.EMPIRE);
		assertEquals("Function of C-3PO", d.getPrimaryFunction());
	}

	@Test
	void test_droidFriendsFriendsFriends() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// droid("{id appearsIn name friends {name friends {friends{id name appearsIn}}}
		// primaryFunction }", "2");
		Droid d = queries.droidFriendsFriendsFriends("00000000-0000-0000-0000-000000000002");

		checkCharacter(d, "testDroidFriendsFriendsFriends", "00000000-0000-0000-0000-000000000002", "BB-8", 2,
				Episode.NEWHOPE);
		assertEquals("Function of BB-8", d.getPrimaryFunction());

		Character friends_0 = d.getFriends().get(0); // "52", "Poe Dameron"
		checkCharacter(friends_0, "testDroidFriendsFriendsFriends[friends_0]", null, "Poe Dameron", 0);

		Character friends_1 = d.getFriends().get(1); // "180", "Luke Skywalker"
		checkCharacter(friends_1, "testDroidFriendsFriendsFriends[friends_1]", null, "Luke Skywalker", 2);
	}

	@Test
	void test_droidDoesNotExist() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		assertNull(queries.droidDoesNotExist());
	}

	@Test
	void test_createHuman() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// Preparation
		List<Character> charactersBefore = queryType.characters("{id name}", null);

		// Go, go, go
		Human human = queries.createHuman("A name", "a planet");

		// Verification
		assertNotNull(human.getId());
		assertEquals("A name", human.getName());
		assertEquals("a planet", human.getHomePlanet());
		//
		List<Character> charactersAfter = queryType.characters("{id name }", null);
		assertEquals(charactersBefore.size() + 1, charactersAfter.size());
		// The last character should be the new one
		Character lastCharacter = charactersAfter.get(charactersAfter.size() - 1);
		assertEquals("A name", lastCharacter.getName());
		assertEquals(human.getId(), lastCharacter.getId());
	}

	@Test
	void test_addFriend() throws GraphQLRequestExecutionException, GraphQLRequestPreparationException {
		// Preparation
		String idMaceWindu = "00000000-0000-0000-0000-000000000224";
		Human maceWindu = queries.humanFriendsFriendsFriends(idMaceWindu);
		int nbBefore = (maceWindu.getFriends() == null) ? 0 : maceWindu.getFriends().size();
		//
		List<Character> chars = queryType.characters("{id name friends{id name}}", null);
		int idFriend = (int) (Math.random() * chars.size());
		Character friend = chars.get(idFriend);

		// Go, go, go
		Character characterAfter = queries.addFriend(idMaceWindu, friend.getId());

		// Verification
		assertNotNull(maceWindu);
		assertNotNull(characterAfter);
		assertNotNull(characterAfter.getFriends());
		assertEquals(nbBefore + 1, characterAfter.getFriends().size());
		// The new friend should be somewhere in the list
		boolean found = false;
		for (Character c : characterAfter.getFriends()) {
			if (c.getId().equals(friend.getId())) {
				found = true;
				break;
			}
		}
		assertTrue(found, "We should have found the new friend");
	}

	private void checkCharacter(Character c, String testDecription, String id, String name, int nbFriends,
			Episode... episodes) {
		assertEquals(id, c.getId(), testDecription + " (id)");
		assertEquals(name, c.getName(), testDecription + " (name)");

		// nbFriends is the number of friends... before any call to addFriend
		if (nbFriends == 0) {
			// c.getFriends() may be null
			if (c.getFriends() != null) {
				assertTrue(c.getFriends().size() >= 0, testDecription + " (friends)");
			}
		} else {
			assertTrue(c.getFriends().size() >= nbFriends, testDecription + " (friends)");
		}
		if (episodes.length == 0) {
			assertNull(c.getAppearsIn(), testDecription + " (appearsIn null)");
		} else {
			assertEquals(episodes.length, c.getAppearsIn().size(), testDecription + " (nb appearsIn)");
			int i = 0;
			for (Episode e : episodes) {
				assertEquals(e, c.getAppearsIn().get(i), testDecription + " (appearsIn num" + i + ")");
				i += 1;
			}
		}
	}
}
