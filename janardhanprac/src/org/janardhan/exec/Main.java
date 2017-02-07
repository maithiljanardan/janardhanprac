package org.janardhan.exec;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.janardhan.input.InputParser;

public class Main {

	public static void main(String[] args) throws Exception {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputParser in = new InputParser(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		SherlockBeast solver = new SherlockBeast();
		// int testCases = in.nextInt();
		// for (int i = 1; i <= testCases; i++)
		solver.solve(in, out);
		out.close();
	}
}
