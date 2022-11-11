package java_introduction;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {

		int b = 10;
		short a = 2000;
		char c = 'd';

		long l = (long) 10.1;
		byte b1 = (byte) 1000;
		a = (short) l;

		float fl = 10.2f;
		int b2 = 0xfffffff6;

		assertEquals(-10, b2);

	}

	@Test
	@Disabled
	void operatorTest() {

		int a = 10;

		assertEquals(13, a + 3);
		assertEquals(1, a % 3);

		int number = 123;

		System.out.println(number);

		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
		assertEquals(3, getThirdDigit(number));

	}

	private int getThirdDigit(int number) {

		int number1 = number % 10;
		System.out.println(number1);

		return number1;
	}

	private int getSecondDigit(int number) {

		return number / 10 % 10;
	}

	private int getFirstDigit(int number) {

		return number / 100 % 10;
	}

	@Test
	void getBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101
								// 0011 1010 1011 0111 1101 0101
								// 0011 1010 1011 0111 1111 0101
		assertEquals(1, BitOperation.getBitValue(number, 5));
		assertEquals(0, BitOperation.getBitValue(number, 11));
		assertEquals(0, BitOperation.getBitValue(number, 1));
		assertEquals(1, BitOperation.getBitValue(number, 2));
		assertEquals(-1, BitOperation.getBitValue(number, -2));

		number = -1;
		assertEquals(1, BitOperation.getBitValue(number, 63));
	}

	@Test
	void setBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101
								// 0011 1010 1011 0111 1111 0101
		assertEquals(0x3ab7d5, BitOperation.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperation.setBitValue(number, 5, true));

	}

	@Test
	void revertBitValueTest() {
		long number = 0x3ab7f5; // 0011 1010 1011 0111 1111 0101
		assertEquals(0x3ab7d5, BitOperation.invertBitValue(number, 5));
		number = BitOperation.invertBitValue(number, 62); // 63 not work
		assertEquals(0, BitOperation.getBitValue(number, 63));

	}

	@Test
	void digitsNumberTest() {
		int number = 5673;
		assertEquals(4, Numbers.getNdigits(number));
	}

	@Test
	void ledingZerosTest() {
		long number = 0x3ab7f0; // 0011 1010 1011 0111 1111 0000
		assertEquals(42, BitOperation.leadingZeros(number));
	}

	@Test
	void onesInNumberTest() {
		int number = 0x3ab7f0; // 0011 1010 1011 0111 1111 0000
		assertEquals(14, BitOperation.onesInNumber(number));
	}

	@Test
	@Disabled
	void isHappyNumberTest() {
		int numHappy = 627906;
		int numNotHappy = 543986;
		assertEquals(true, Numbers.isHappyNumber(numHappy));
		assertEquals(false, Numbers.isHappyNumber(numNotHappy));
		assertFalse(Numbers.isHappyNumber(numNotHappy));
		assertTrue(Numbers.isHappyNumber(numHappy));
	}
	
	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = {1,2,3,4};
		Numbers.getDigits(1234);
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}
	
	@Test
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int []{1,2,3,4}));
	}
	@Test
	void verifyTest( ) {
		assertEquals(true, IsraelIdentity.verify(346872658));
	}
	@Test
	void generateRandomIdTest() {
		assertEquals(9, Numbers.getNdigits(IsraelIdentity.generateRandomId()));
	}
	
	@Test 
	void addsNumderTest() {
		int originalArray[] = {1,2,3,4};
		int expected[] = {1,2,3,4,5};
		assertArrayEquals(expected, MyArrays.addsNumder(originalArray, 5));
	}
	
	@Test
	void removeNumbertest() {
		int originalArray[] = {1,2,3,4,5,9,12,4,6,8,34,27,43};
		int expected[] = {1,2,3,4,5,9,4,6,8,34,27,43};
		int expectedFalse[] = {1,2,3,4,5,9,12,4,6,8,34,27,43};
		assertArrayEquals(expected, MyArrays.removeNumber(originalArray, 6));
		assertArrayEquals(new int []{1,2,3,4,5,9,12,4,6,8,34,27}, MyArrays.removeNumber(originalArray, 12));
		assertArrayEquals(new int []{2,3,4,5,9,12,4,6,8,34,27,43}, MyArrays.removeNumber(originalArray, 0));
		assertArrayEquals(expectedFalse, MyArrays.removeNumber(originalArray, 16));
	}
	@Test
	void insertSortedTest() {
		int originalArray[] = {1,2,3,4,5,6,7,8};
		int expected[] = {1,2,3,4,4,5,6,7,8};
		assertArrayEquals(expected, MyArrays.insertSorted(originalArray, 4));
	}
	
	@Test 
	void arrOneStepToSortTest() {
		
		assertTrue(MyArrays.arrOneStepToSort(new int []{1,2,3,5,4,9,12,14,16,18,22,27}));
		assertFalse(MyArrays.arrOneStepToSort(new int []{1,2,3,4,5,9,12,4,6,8,34,27}));
		assertFalse(MyArrays.arrOneStepToSort(new int []{1,2,3,4,5,9,12,14,16,18,22,27}));
	}
	
	@Test 
	void bubleSortArrTest() {
		int expected[] = {1,2,3,4,4,5,6,7,8};
		assertArrayEquals(expected, MyArrays.bubleSortArr(new int []{1,3,2,4,4,8,7,6,5}));
	}
	
	@Test 
	void sumEventIndexesTest() {
		assertEquals(20, MyArrays.sumEventIndexes(new int []{1,2,9,8,6,5,4,3,0}) );
	}
	
	@Test 
	void sumOddIndexesTest( ) {
		assertEquals(18, MyArrays.sumOddIndexes(new int []{1,2,9,8,6,5,4,3,0}) );
	}
	
	@Test
	void binarySearchFirstIndexTest() {
		assertEquals(4, MyArrays.binarySearchFirstIndex(new int []{1,2,3,4,6,6,6,6,8,9,13,14}, 6) );
		assertEquals(1, MyArrays.binarySearchFirstIndex(new int []{1,2,2,2,6,6,6,6,8,9,13,14}, 2) );
		assertEquals(9, MyArrays.binarySearchFirstIndex(new int []{1,2,3,4,4,5,5,6,8,9,9,9}, 9) );
		assertEquals(4, MyArrays.binarySearchFirstIndex(new int []{1,2,3,4,5,6,6,6,8,9,13,14}, 5) );
	}
}
