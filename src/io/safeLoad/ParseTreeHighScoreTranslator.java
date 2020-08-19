package io.safeLoad;

import game.HighScore;
import io.parseTree.Leaf;
import io.parseTree.Node;
import io.parseTree.TreeElement;

public class ParseTreeHighScoreTranslator {
	
	public static final String LabelScore 			= "Score";
	private static final String LabelLevel 			= "Level";
	private static final String AttributeCheckSum 	= "CheckSum";
	private static final String AttributePlayer		= "Player";
	private static final String AttributeLevelNr 	= "LevelNr";
	private static final String AttributeLevelMoves	= "LevelMoves";
	
	
	// translate level
	public static TreeElement createScoreTree(HighScore highscore) {
		Node root = new Node(LabelScore);
		root.setAttribute(AttributeCheckSum, Integer.toString(highscore.getCheckSum()));
		
		for(int level : highscore.getScores().keySet()) {
			if(highscore.getScore(level) != 0) {
				Leaf leaf = new Leaf(LabelLevel);
				leaf.setAttribute(AttributeLevelNr, Integer.toString(level));
				leaf.setAttribute(AttributeLevelMoves, Integer.toString(highscore.getScore(level)));
				leaf.setAttribute(AttributePlayer, highscore.getName(level));
				root.addChild(leaf);
			}
		}
		return root;
	}

	public static HighScore createScore(TreeElement treeRoot) throws ParseTreeStructureException {
		if(!treeRoot.getName().equals(LabelScore)) {
			throw new ParseTreeStructureException("wrong tree structure");
		}
		if(treeRoot.isLeaf()) {
			throw new ParseTreeStructureException("wrong tree structure");
		}
		Node topNode = (Node) treeRoot;
		
		if(!topNode.hasAttribute(AttributeCheckSum)) {
			throw new ParseTreeStructureException("attribute not found");
		}
		
		int checkSum;
		try {
			checkSum = Integer.parseInt(topNode.getAttribute(AttributeCheckSum));
		} catch(NumberFormatException e) {
			throw new ParseTreeStructureException("couldn't parse string to integer");
		}
		
		HighScore highscore = new HighScore();
		// get fields
		for(TreeElement element : topNode.getChildren(LabelLevel)) {
			if(!element.isLeaf()) {
				throw new ParseTreeStructureException("wrong tree structure");
			}
			
			Leaf leaf = (Leaf) element;
			if(!leaf.hasAttribute(AttributeLevelNr) || !leaf.hasAttribute(AttributeLevelMoves) ||
					!leaf.hasAttribute(AttributePlayer)) {
				throw new ParseTreeStructureException("attribute not found");
			}

			String player = leaf.getAttribute(AttributePlayer);
			int nr, moves;
			try {
				nr    = Integer.parseInt(leaf.getAttribute(AttributeLevelNr));
				moves = Integer.parseInt(leaf.getAttribute(AttributeLevelMoves));
			} catch(NumberFormatException e) {
				throw new ParseTreeStructureException("couldn't parse level information");
			}
			highscore.set(nr, player, moves);
		}
		
		if(checkSum != highscore.getCheckSum()) {
			throw new ParseTreeStructureException("check sum wrong -- calculated: " + checkSum + ", expected: " + highscore.getCheckSum());
		}
		
		return highscore;
	}

}
