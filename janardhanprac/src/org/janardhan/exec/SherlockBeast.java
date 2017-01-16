package org.janardhan.exec;

import java.io.PrintWriter;

import org.janardhan.input.InputParser;

public class SherlockBeast {

	public void solve(InputParser in, PrintWriter out) {

		try {

			int num_digits = in.nextInt();
			int num_temp = num_digits;
			int num_threes = 0;
			int num_fives = num_digits;

			while (num_temp > 0) {
				if (num_temp % 3 == 0) {
					num_fives = num_temp;
					break;
				}
				num_temp = num_temp - 5;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
