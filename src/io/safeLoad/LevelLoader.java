package io.safeLoad;

import java.io.IOException;

import game.Level;
import io.parseTree.TreeElement;
import io.parseTree.XMLTreeReader;


public class LevelLoader {

	private static final String safeFolder = "safe/level/level";
	
	
	public static Level loadLevel(int levelNumber) throws LoadException {
		
		String loadPath = safeFolder + levelNumber + ".lvl";
		
		TreeElement treeRoot = null;
		XMLTreeReader treeReader = new XMLTreeReader(loadPath);
		try {
			treeRoot = treeReader.read();
		} catch (IOException e) {
			throw new LoadException("couldn't read level file");
		}
		
		if(treeRoot == null) {
			throw new LoadException("error in reading level file");
		}
		
		try {
			Level level = ParseTreeLevelTranslator.createLevel(treeRoot);
			if(level.getLevelNumber() != levelNumber) {
				throw new LoadException("wrong level number in level file");
			}
			return level;
		} catch (ParseTreeStructureException e) {
			throw new LoadException("couldn't translate level file");
		}
	}
	
}
