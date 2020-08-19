package comparator;

import game.Field;

import java.util.Comparator;

public class IncreasingXFieldComparator implements Comparator<Field> {

	@Override
	public int compare(Field f1, Field f2) {
		int x1 = f1.getX();
		int x2 = f2.getX();
		
		if(x1 == x2) {
			return 0;
		}
		return (x1 < x2) ? -1 : 1;
	}

}
