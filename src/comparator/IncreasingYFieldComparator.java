package comparator;

import game.Field;

import java.util.Comparator;

public class IncreasingYFieldComparator implements Comparator<Field> {

	@Override
	public int compare(Field f1, Field f2) {
		int y1 = f1.getY();
		int y2 = f2.getY();
		
		if(y1 == y2) {
			return 0;
		}
		return (y1 < y2) ? -1 : 1;
	}

}
