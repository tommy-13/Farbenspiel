package io.safeLoad;

import java.util.HashMap;
import java.util.Map;

import player.Player;
import io.parseTree.Leaf;
import io.parseTree.Node;
import io.parseTree.TreeElement;

public class ParseTreePlayerTranslator {
	
	public static final String LabelPlayer 			= "Player";
	private static final String LabelLevel 			= "Level";
	private static final String AttributeCheckSum 	= "CheckSum";
	private static final String AttributeId 		= "Id";
	private static final String AttributeName 		= "Name";
	private static final String AttributeMaxLevel 	= "MaxLevel";
	private static final String AttributeLevelNr 	= "LevelNr";
	private static final String AttributeLevelMoves	= "LevelMoves";
	
	
	// translate level
	public static TreeElement createPlayerTree(Player player) {
		Node root = new Node(LabelPlayer);
		root.setAttribute(AttributeId, Integer.toString(player.getId()));
		root.setAttribute(AttributeName, player.getName());
		root.setAttribute(AttributeMaxLevel, Integer.toString(player.getNextLevel()));
		root.setAttribute(AttributeCheckSum, Integer.toString(player.getCheckSum()));
		
		if(player.getMoves() != null) {
			for(Map.Entry<Integer, Integer> entry : player.getMoves().entrySet()) {
				Leaf leaf = new Leaf(LabelLevel);
				leaf.setAttribute(AttributeLevelNr, Integer.toString(entry.getKey()));
				leaf.setAttribute(AttributeLevelMoves, Integer.toString(entry.getValue()));
				root.addChild(leaf);
			}
		}
		return root;
	}

	public static Player createPlayer(TreeElement treeRoot) throws ParseTreeStructureException {
		if(!treeRoot.getName().equals(LabelPlayer)) {
			throw new ParseTreeStructureException("wrong tree structure");
		}
		if(treeRoot.isLeaf()) {
			throw new ParseTreeStructureException("wrong tree structure");
		}
		Node topNode = (Node) treeRoot;
		
		if(!topNode.hasAttribute(AttributeName) || !topNode.hasAttribute(AttributeCheckSum) ||
				!topNode.hasAttribute(AttributeId) || !topNode.hasAttribute(AttributeMaxLevel)) {
			throw new ParseTreeStructureException("attribute not found");
		}
		
		String name = topNode.getAttribute(AttributeName);
		
		int id, maxLevel, checkSum;
		try {
			id = Integer.parseInt(topNode.getAttribute(AttributeId));
			maxLevel = Integer.parseInt(topNode.getAttribute(AttributeMaxLevel));
			checkSum = Integer.parseInt(topNode.getAttribute(AttributeCheckSum));
		} catch(NumberFormatException e) {
			throw new ParseTreeStructureException("couldn't parse string to integer");
		}
		
		Map<Integer, Integer> levels = new HashMap<Integer, Integer>();
		// get fields
		for(TreeElement element : topNode.getChildren(LabelLevel)) {
			if(!element.isLeaf()) {
				throw new ParseTreeStructureException("wrong tree structure");
			}
			
			Leaf leaf = (Leaf) element;
			if(!leaf.hasAttribute(AttributeLevelNr) || !leaf.hasAttribute(AttributeLevelMoves)) {
				throw new ParseTreeStructureException("attribute not found");
			}

			int nr, moves;
			try {
				nr    = Integer.parseInt(leaf.getAttribute(AttributeLevelNr));
				moves = Integer.parseInt(leaf.getAttribute(AttributeLevelMoves));
			} catch(NumberFormatException e) {
				throw new ParseTreeStructureException("couldn't parse level information");
			}
			
			levels.put(nr, moves);
		}
		
		Player player = new Player(id, name, maxLevel, levels);
		
		if(checkSum != player.getCheckSum()) {
			throw new ParseTreeStructureException("check sum wrong -- calculated: " + checkSum + ", expected: " + player.getCheckSum());
		}
		
		return player;
	}

}
