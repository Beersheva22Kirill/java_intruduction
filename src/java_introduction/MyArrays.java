package java_introduction;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added at end a given number
	 */
	public static int[] addsNumder(int[] array, int number) {
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[res.length - 1] = number;

		return res;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at given index in a given array if index
	 *         does not exist in a given array it return the same array
	 */
	public static int[] removeNumber(int[] array, int index) {

		int NumDigits = index >= 0 && index < array.length ? array.length - 1 : array.length;
		int[] res = new int[NumDigits];

		if (NumDigits == (array.length - 1)) {
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, array.length - index - 1);
		} else {
			System.arraycopy(array, 0, res, 0, array.length);
		}

		return res;

	}

	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at index for keeping array sorted
	 */
	public static int[] insertSorted(int[] arraySorted, int number) {
		int[] res = new int[arraySorted.length + 1];

		int posNumber = Arrays.binarySearch(arraySorted, number);

		if (posNumber < 0) {
			posNumber = posNumber * (-1) - 1;
		}
		System.arraycopy(arraySorted, 0, res, 0, posNumber);
		res[posNumber] = number;
		System.arraycopy(arraySorted, posNumber, res, posNumber + 1, arraySorted.length - posNumber);

		return res;
	}

	private static int[] insertAtIndex(int[] array, int number, int index) {
		int res[] = new int[array.length];
		
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		
		return res;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exist otherwise 0[N] - search number in
	 *         unsorted array 0[logN] - search number in sorted (binary search)
	 * 
	 */
	public static int binarySearchFirstIndex(int arraySorted[], int number) {

		int indexLeft = 0;
		int indexRight = arraySorted.length - 1;
		int middle = 0;
		boolean flag = true;

		while (flag == true) {
			middle = indexRight / 2;
			while (indexLeft <= indexRight && arraySorted[middle] != number) {
				if (number < arraySorted[middle]) {
					indexRight = middle - 1;
				} else {
					indexLeft = middle + 1;
				}
				middle = (indexLeft + indexRight) / 2;
			}
			if (elementBefore(arraySorted, middle) == true && indexLeft < indexRight) {
				indexRight = middle - 1;
			} else {
				flag = false;
			}

		}
		return indexLeft > indexRight ? (middle * (-1)) - 1 : middle;
	}

	private static boolean elementBefore(int[] array, int index) {

		return array[index] == array[index - 1] ? true : false;
	}

	public static boolean arrOneStepToSort(int array[]) {
		int counter = 0;
		int[] arr_sort = new int[array.length];
		System.arraycopy(array, 0, arr_sort, 0, array.length);

		arr_sort = bubleSortArr(arr_sort);

		for (int i = 0; i < array.length; i++) {
			if (arr_sort[i] != array[i]) {
				counter++;
			}
		}
		return counter == 2 ? true : false;
	}

	public static int[] bubleSortArr(int[] array) {

		int[] arraySort = new int[array.length];
		System.arraycopy(array, 0, arraySort, 0, array.length);
		while (moveGreaterRight(arraySort) != arraySort) {
			arraySort = moveGreaterRight(arraySort);
		}

		return arraySort;
	}

	private static int[] moveGreaterRight(int[] array) {
		boolean flag = false;
		int[] arrayTemp = new int[array.length];
		System.arraycopy(array, 0, arrayTemp, 0, array.length);

		for (int i = 0; i < arrayTemp.length - 1; i++) {
			if (arrayTemp[i] > arrayTemp[i + 1]) {
				flag = true;
				int temp = arrayTemp[i];
				arrayTemp[i] = arrayTemp[i + 1];
				arrayTemp[i + 1] = temp;
			}
		}
		return flag == false ? array : arrayTemp;
	}

	public static void printArrToTerminal_Int(int[] array) {
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void printArrToTerminal_Short(short[] array) {
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param array
	 * @return sum of even numbers
	 */
	public static int sumEventIndexes(int[] array) {
		int res = 0;
		for (int i = 0; i < array.length; i += 2) {
			res += array[i];
		}
		return res;
	}

	/**
	 * 
	 * @param array
	 * @return sum of odd numbers
	 */
	public static int controlSumOddIndexes(int[] array) {
		int res = 0;
		int digit = 0;

		for (int i = 1; i < array.length; i += 2) {
			digit = array[i] * 2;
			if (digit > 9) {
				digit = Numbers.sumDigit(digit);
			}
			res += digit;
		}
		return res;
	}

	public static int getControlSum(int[] number) {

		return sumEventIndexes(number) + controlSumOddIndexes(number);
	}

	/**
	 * 
	 * @param array array of short positives numbers
	 * @param sum
	 * @return true if array contains two numbers, sum of which equals a given sum
	 */

	public static boolean isSumTwo(short[] array, short sum) {
		
		boolean res = false;
		boolean[] Helper = new boolean[sum >= 0 ? sum + 1 : 0x7fff + 1];
		int i = 0;
		while (!res && i < array.length) {

			short difSum = (short) (sum - array[i]);
			if (difSum >= 0) {
				if (Helper[difSum]) {
					res = true;
				} else {
					Helper[array[i]] = true;
				}
			}
			i++;
		}
		return res;
	}

}
