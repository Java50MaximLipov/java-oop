package telran.util.tests;

import java.util.Comparator;

public class MinMaxIntegerComaparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}

}
