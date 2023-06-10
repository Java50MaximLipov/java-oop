package telran.util.tests;

import org.junit.jupiter.api.Test;
import static telran.util.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysTest {
	Integer[] numbers = { 10, 5, -5, 100, 200 };
	String[] strings = { "lmn", "a", "ab", "abc", "b", "ba" };

	@Test
	void addObjectTest() {
		Integer[] expectedNumbers = { 10, 5, -5, 100, 200, 50 };
		assertArrayEquals(expectedNumbers, addObject(numbers, 50));
		String[] expectedStrings = { "lmn", "a", "ab", "abc", "b", "ba", "bb" };
		assertArrayEquals(expectedStrings, addObject(strings, "bb"));
	}

	@Test
	void insertObjectTest() {
		Integer[] expectedLast = { 10, 5, -5, 100, 200, 50 };
		Integer[] expectedFirst = { 50, 10, 5, -5, 100, 200 };
		Integer[] expectedMiddle = { 10, 5, 50, -5, 100, 200 };
		assertArrayEquals(expectedLast, insertObject(numbers, 5, 50));
		assertArrayEquals(expectedFirst, insertObject(numbers, 0, 50));
		assertArrayEquals(expectedMiddle, insertObject(numbers, 2, 50));
	}

	@Test
	void digitsSumComparatorTest() {
		Comparator<Integer> comp = new DigitsSumComparator();
		assertTrue(comp.compare(9, 66) < 0);
		assertTrue(comp.compare(9, 111) > 0);
		assertTrue(comp.compare(3, 111) == 0);
		assertTrue(comp.compare(3, -111) == 0);
	}

	@Test
	void standardSortComparatorTest() {
		Integer[] array = { 10, 5, 110, 9, 22, 33 };
		Integer[] expected = { 10, 110, 22, 5, 33, 9 };
		Arrays.sort(array, new DigitsSumComparator());
		assertArrayEquals(expected, array);
	}

// ######  HW-05  ######
	@Test
	void bubbleSortComparatorTest() {
		Integer[] arrayEvenOdd1 = { 10, 5, -5, 100, 200 };
		Integer[] expectedEvenOdd1 = { 10, 100, 200, 5, -5 };
		bubbleSort(arrayEvenOdd1, new EvenOddComparator());
		assertArrayEquals(expectedEvenOdd1, arrayEvenOdd1);

		Integer[] arrayEvenOdd2 = { 7, 5, 4, 2, 1, 0, -6, -13 };
		Integer[] expectedEvenOdd2 = { -6, 0, 2, 4, 7, 5, 1, -13 };
		bubbleSort(arrayEvenOdd2, new EvenOddComparator());
		assertArrayEquals(expectedEvenOdd2, arrayEvenOdd2);

		Integer[] arrayMinMax1 = { 55, 0, -500, 42, 3 };
		Integer[] expectedMinMax1 = { -500, 0, 3, 42, 55 };
		bubbleSort(arrayMinMax1, new MinMaxIntegerComaparator());
		assertArrayEquals(expectedMinMax1, arrayMinMax1);

		Integer[] arrayMinMax2 = { 10, 5, -5, 100, 200 };
		Integer[] expectedMinMax2 = { -5, 5, 10, 100, 200 };
		bubbleSort(arrayMinMax2, new MinMaxIntegerComaparator());
		assertArrayEquals(expectedMinMax2, arrayMinMax2);
	}

	@Test
	void minMaxIntegerComparator() {
		Comparator<Integer> comp = new MinMaxIntegerComaparator();
		assertTrue(comp.compare(1, 2) < 0);
		assertTrue(comp.compare(2, 1) > 0);
		assertTrue(comp.compare(2, 2) == 0);
		assertTrue(comp.compare(-2, 1) < 0);
	}

}
