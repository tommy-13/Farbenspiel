package io.safeLoad;

import io.parseTree.TreeElement;
import io.parseTree.XMLTreeWriter;

import java.io.IOException;

import player.Player;


public class PlayerSafer {
	
	public static final String safeFolder = "safe/player/player";

	public static boolean safePlayer(Player player) {
		if(player == null) {
			return false;
		}
		
		String safePath = safeFolder + player.getId() + ".ply";
		TreeElement treeRoot = ParseTreePlayerTranslator.createPlayerTree(player);
		XMLTreeWriter treeWriter = new XMLTreeWriter(safePath, treeRoot);
		try {
			treeWriter.write();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
