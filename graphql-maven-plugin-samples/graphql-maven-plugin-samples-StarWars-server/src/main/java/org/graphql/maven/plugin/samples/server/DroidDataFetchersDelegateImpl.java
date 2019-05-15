/**
 * 
 */
package org.graphql.maven.plugin.samples.server;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.graphql.maven.plugin.samples.server.Character;
import org.graphql.maven.plugin.samples.server.Droid;
import org.graphql.maven.plugin.samples.server.DroidDataFetchersDelegate;
import org.graphql.maven.plugin.samples.server.Episode;
import org.graphql.maven.plugin.samples.server.jpa.CharacterRepository;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetchingEnvironment;

/**
 * @author EtienneSF
 */
@Component
public class DroidDataFetchersDelegateImpl implements DroidDataFetchersDelegate {

	@Resource
	CharacterRepository characterRepository;

	@Resource
	GraphQLUtil graphQLUtil;

	@Override
	public List<Character> droidFriends(DataFetchingEnvironment dataFetchingEnvironment, Droid source) {
		return graphQLUtil.iterableConcreteClassToListInterface(characterRepository.findFriends(source.getId()));
	}

	@Override
	public List<Episode> droidAppearsIn(DataFetchingEnvironment dataFetchingEnvironment, Droid source) {
		List<String> episodeStr = characterRepository.findAppearsInById(source.getId());
		List<Episode> ret = new ArrayList<>(episodeStr.size());
		for (String s : episodeStr) {
			ret.add(Episode.valueOf(s));
		} // for
		return ret;
	}

}