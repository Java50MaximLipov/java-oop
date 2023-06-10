package telran.util.tests;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		boolean isO1Even = o1 % 2 == 0;
		boolean isO2Even = o2 % 2 == 0;
		// both numbers are even or both are odd
		if (isO1Even == isO2Even) {
			if (isO1Even) {
				// Sort even numbers in ascending order
				return compareNumbers(o1, o2);
			} else {
				// Sort odd numbers in descending order
				return compareNumbers(o2, o1);
			}
		}
		// o1 is even and o2 is odd
		if (isO1Even) {
			return -1; // Place even number before odd number
		}
		// o1 is odd and o2 is even
		return 1; // Place odd number after even number
	}

	private int compareNumbers(int num1, int num2) {
		if (num1 < num2) {
			return -1;
		} else if (num1 > num2) {
			return 1;
		}
		return 0;
	}
}
