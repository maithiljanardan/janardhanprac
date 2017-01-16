package org.janardhan.exec;

import java.util.Scanner;

public class Solution {
	/*
	 * Complete the function below.
	 */

	static void countNumbers(int[][] arr) {

		int[] arrgg = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222, 333, 444, 555, 666, 777, 888, 999, 1111, 2222,
				3333, 4444, 5555, 6666, 7777, 8888, 9999, 11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999,
				111111, 222222, 333333, 444444, 555555, 666666, 777777, 888888, 999999, 1111111, 2222222, 3333333,
				4444444, 5555555, 6666666, 7777777, 8888888, 9999999, 11111111, 22222222, 33333333, 44444444, 55555555,
				66666666, 77777777, 88888888, 99999999 };
		int n = 0;
		int m = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			n = arr[i][0];
			m = arr[i][1];
			count = m - n + 1;
			for (int j = 0; j < arrgg.length; j++) {
				if (arrgg[j] >= n && arrgg[j] <= m) {
					count--;
				}
			}
			System.out.println(count);
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int _arr_rows = 0;
		int _arr_cols = 0;
		_arr_rows = Integer.parseInt(in.nextLine().trim());
		_arr_cols = Integer.parseInt(in.nextLine().trim());

		int[][] _arr = new int[_arr_rows][_arr_cols];
		for (int _arr_i = 0; _arr_i < _arr_rows; _arr_i++) {
			for (int _arr_j = 0; _arr_j < _arr_cols; _arr_j++) {
				_arr[_arr_i][_arr_j] = in.nextInt();

			}
		}

		if (in.hasNextLine()) {
			in.nextLine();
		}

		countNumbers(_arr);
		in.close();
	}
}