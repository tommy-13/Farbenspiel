package io.safeLoad;

import java.io.IOException;

import player.Player;
import io.parseTree.TreeElement;
import io.parseTree.XMLTreeReader;


public class PlayerLoader {

	private static final String safeFolder = "safe/player/player";
	
	
	public static Player loadPlayer(int playerId) throws LoadException {
		
		String loadPath = safeFolder + playerId + ".ply";
		
		TreeElement treeRoot = null;
		XMLTreeReader treeReader = new XMLTreeReader(loadPath);
		try {
			treeRoot = treeReader.read();
		} catch (IOException e) {
			throw new LoadException("couldn't read player file");
		}
		
		if(treeRoot == null) {
			throw new LoadException("error loading player file");
		}
		
		try {
			Player player = ParseTreePlayerTranslator.createPlayer(treeRoot);
			if(player.getId() != playerId) {
				throw new LoadException("found wrong player id in file");
			}
			return player;
		} catch (ParseTreeStructureException e) {
			e.printStackTrace();
			throw new LoadException("couldn't translate player file");
		}
	}
	
}
