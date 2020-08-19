package io.safeLoad;

import game.Level;
import io.parseTree.TreeElement;
import io.parseTree.XMLTreeWriter;

import java.io.IOException;


public class LevelSafer {
	
	private static final String safeFolder = "safe/level/level";

	public static boolean safeLevel(Level level) {
		if(level.getFields().isEmpty()) {
			return false;
		}
		
		String safePath = safeFolder + level.getLevelNumber() + ".lvl";
		TreeElement treeRoot = ParseTreeLevelTranslator.createLevelTree(level);
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
