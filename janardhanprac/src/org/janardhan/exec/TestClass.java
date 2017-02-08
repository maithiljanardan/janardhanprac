package org.janardhan.exec;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
	public static void main(String args[]) throws Exception {

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int count = 0;

		for (int i = 0; i < N; i++) {
			String var = "";
			String val = "";
			String str = br.readLine().trim();
			try {
				var = str.split("=")[0].trim();
			}
			catch (Exception e) {

			}

			try {
				val = str.split("=")[1].trim();
			}
			catch (Exception e) {

			}

			if (str.contains("=") && !var.equals("") && !var.contains(" ")) {
				count++;
			}

		}
		System.out.println(count);
	}
}
