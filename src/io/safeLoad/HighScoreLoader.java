package io.safeLoad;

import java.io.IOException;

import game.HighScore;
import io.parseTree.TreeElement;
import io.parseTree.XMLTreeReader;


public class HighScoreLoader {

	private static final String loadPath = "safe/player/_score";
	
	
	public static HighScore loadScore() throws LoadException {
		
		TreeElement treeRoot = null;
		XMLTreeReader treeReader = new XMLTreeReader(loadPath);
		try {
			treeRoot = treeReader.read();
		} catch (IOException e) {
			e.printStackTrace();
			throw new LoadException("couldn't read highscore file");
		}
		
		if(treeRoot == null) {
			throw new LoadException("error in highscore file");
		}
		
		try {
			HighScore highscore = ParseTreeHighScoreTranslator.createScore(treeRoot);
			return highscore;
		} catch (ParseTreeStructureException e) {
			throw new LoadException("couldn't translate highscore file");
		}
	}
	
}
