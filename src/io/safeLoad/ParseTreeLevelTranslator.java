package io.safeLoad;

import java.util.ArrayList;
import java.util.List;

import game.Field;
import game.FieldColor;
import game.Level;
import io.parseTree.Leaf;
import io.parseTree.Node;
import io.parseTree.TreeElement;

public class ParseTreeLevelTranslator {
	
	public static final String LabelLevel 				= "Level";
	private static final String LabelField 				= "Field";
	private static final String AttributeCheckSum 		= "CheckSum";
	private static final String AttributeLevelNumber 	= "LevelNumber";
	private static final String AttributeMoveOverGaps 	= "MoveOverGaps";
	private static final String AttributeXOnBoard 		= "XOnBoard";
	private static final String AttributeYOnBoard 		= "YOnBoard";
	private static final String AttributeDesiredColor 	= "DesiredColor";
	private static final String AttributeCurrentColor 	= "CurrentColor";
	
	
	// translate level
	public static TreeElement createLevelTree(Level level) {
		Node root = new Node(LabelLevel);
		root.setAttribute(AttributeLevelNumber, Integer.toString(level.getLevelNumber()));
		root.setAttribute(AttributeMoveOverGaps, Boolean.toString(level.getMoveOverGaps()));
		root.setAttribute(AttributeCheckSum, Integer.toString(level.getCheckSum()));
		
		for(Field f : level.getFields()) {
			root.addChild(createFieldTree(f));
		}
		
		return root;
	}

	public static Level createLevel(TreeElement treeRoot) throws ParseTreeStructureException {
		if(!treeRoot.getName().equals(LabelLevel)) {
			throw new ParseTreeStructureException("wrong tree structure");
		}
		if(treeRoot.isLeaf()) {
			throw new ParseTreeStructureException("wrong tree structure");
		}
		Node topNode = (Node) treeRoot;
		
		if(!topNode.hasAttribute(AttributeLevelNumber) || !topNode.hasAttribute(AttributeCheckSum) ||
				!topNode.hasAttribute(AttributeMoveOverGaps)) {
			throw new ParseTreeStructureException("attribute not found");
		}
		
		int levelNr, checkSum;
		try {
			levelNr = Integer.parseInt(topNode.getAttribute(AttributeLevelNumber));
			checkSum = Integer.parseInt(topNode.getAttribute(AttributeCheckSum));
		} catch(NumberFormatException e) {
			throw new ParseTreeStructureException("couldn't parse string to integer");
		}
		
		boolean moveOverGaps = Boolean.parseBoolean(topNode.getAttribute(AttributeMoveOverGaps));

		
		List<Field> fields = new ArrayList<Field>();
		// get fields
		for(TreeElement element : topNode.getChildren(LabelField)) {
			if(element.isLeaf()) {
				Leaf leaf = (Leaf) element;
				if(!leaf.hasAttribute(AttributeYOnBoard) || !leaf.hasAttribute(AttributeXOnBoard) ||
						!leaf.hasAttribute(AttributeDesiredColor) || !leaf.hasAttribute(AttributeCurrentColor)) {
					throw new ParseTreeStructureException("attribute not found");
				}
				
				int x,y;
				try {
					x = Integer.parseInt(leaf.getAttribute(AttributeXOnBoard));
					y = Integer.parseInt(leaf.getAttribute(AttributeYOnBoard));
				} catch(NumberFormatException e) {
					throw new ParseTreeStructureException("field position wrong");
				}
				FieldColor desiredCol = FieldColor.valueOf(leaf.getAttribute(AttributeDesiredColor));
				FieldColor currentCol = FieldColor.valueOf(leaf.getAttribute(AttributeCurrentColor));
				
				fields.add(new Field(x, y, currentCol, desiredCol));
			}
		}
		
		Level level = new Level(levelNr, fields, moveOverGaps);
		
		if(checkSum != level.getCheckSum()) {
			throw new ParseTreeStructureException("check sum wrong -- calculated: " + checkSum + ", expected: " + level.getCheckSum());
		}
		
		return level;
	}
	
	
	private static TreeElement createFieldTree(Field field) {
		Leaf nField = new Leaf(LabelField);
		nField.setAttribute(AttributeXOnBoard, Integer.toString(field.getXOnBoard()));
		nField.setAttribute(AttributeYOnBoard, Integer.toString(field.getYOnBoard()));
		nField.setAttribute(AttributeDesiredColor, field.getDesiredColor().toString());
		nField.setAttribute(AttributeCurrentColor, field.getCurrentColor().toString());
		return nField;
	}

}
