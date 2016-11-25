package org.janardhan.functions;

public class MathFunctions {

	/**
	 * This method takes number as input and checks whether it is divisible by
	 * three or not
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isDivisibleByThree(int number) {

		int odd_count = 0;
		int even_count = 0;

		// If negative make it positive
		number = Math.abs(number);

		if (number == 0)
			return true;
		if (number == 1)
			return false;

		while (number != 0) {

			// count odd position
			if ((number & 1) == 1) {
				odd_count++;

			}
			// Shift
			number = number >> 1;

			// count even position
			if ((number & 1) == 1) {
				even_count++;

			}
			// shift
			number = number >> 1;
		}
		return isDivisibleByThree(Math.abs(odd_count - even_count));
	}

	public static boolean isArmstrongNumber(int number) {

		int sum = 0;
		int temp;
		int originalNumber = number;

		int order = getNumberofDigitsInNumber(number);

		while (number != 0) {

			temp = number % 10;
			number = number / 10;
			sum = sum + power(temp, order);
		}
		if (sum == originalNumber)
			return true;
		else
			return false;
	}

	private static int power(int r, int n) {

		if (n == 0)
			return 1;

		if (n % 2 == 0)
			return power(r, n / 2) * power(r, n / 2);

		return r * power(r, n / 2) * power(r, n / 2);
	}

	public static int getNumberofDigitsInNumber(int number) {

		int numOfDigits = 0;

		while (number != 0) {
			numOfDigits++;
			number = number / 10;
		}

		return numOfDigits;
	}
}
