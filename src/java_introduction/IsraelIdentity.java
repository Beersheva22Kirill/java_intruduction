package java_introduction;

import java.util.Iterator;

public class IsraelIdentity {

	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false control sum should be multiple on
	 *         10 (sum % 10 ==0) for even indexes (0,2,4,6,8) digits as is for odd
	 *         indexes (1,3,5,7,9) digits = digits*2, if result > 9 the sum of inner
	 *         digits is taken example, 123456782 => 1 + 4(2*2) + 3 + 8(4*2) + 5 + 3
	 *         (6 * 2 = 12 => 1 + 2 ) + 7 + 7(8 * 2 = 16 => 7) + 2 = 40 40 % 10 = 0;
	 */
public static int iterCounter = 0;
public static final int N_DIGITS_ID = 9;

	public static boolean verify(int id) {
		
		int [] digits = new int [Numbers.getNdigits(id)];
		
		boolean res = false;
		if (N_DIGITS_ID == digits.length) {
			if (MyArrays.getControlSum(digits) % 10 == 0 ) {
				res = true;
			}	
		}
			
		return res;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel Id first digits not 0
	 *         cycle not more than 9 iteration
	 */
	public static int generateRandomId() {
		int [] NumberZeut = new int[9];
		int i = 0, res = 0, dif = 0;
		int ControlSum = 0;
		NumberZeut[0] = Numbers.getRandom(1, 9);
		i++;
		
		while (i < N_DIGITS_ID - 1) {			
			dif = Numbers.getRandom(0, 9);					
				NumberZeut[i] = dif;				
				i++;			
				iterCounter++;
		}
		ControlSum = MyArrays.getControlSum(NumberZeut);
		NumberZeut[8] = getLastDigit(ControlSum);
		res = Numbers.getNumberFromDigits(NumberZeut);

		return res;
	}

	
	public static int getLastDigit(int controlSum) {
		
		int rem = controlSum % 10;
		int res = 0;
		if (rem != 0) {
			res = 10 - rem;
		}
		return res;
	}
}
