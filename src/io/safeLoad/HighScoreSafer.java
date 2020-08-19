package io.safeLoad;

import game.HighScore;
import io.parseTree.TreeElement;
import io.parseTree.XMLTreeWriter;

import java.io.IOException;


public class HighScoreSafer {
	
	private static final String safePath = "safe/player/_score";

	public static boolean safeScore(HighScore highscore) {
		if(highscore == null) {
			return false;
		}
		
		TreeElement treeRoot = ParseTreeHighScoreTranslator.createScoreTree(highscore);
		XMLTreeWriter treeWriter = new XMLTreeWriter(safePath, treeRoot);
		try {
			treeWriter.write();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
