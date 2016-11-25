package org.janardhan.exec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import org.janardhan.datastructure.StudentComparable;
import org.janardhan.functions.MathFunctions;
import org.janardhan.functions.StringFunctions;

public class ScannerInput {

	public static void main(String[] args) {

		// Scanner scanner = new Scanner(System.in);
		//
		// int testCases = scanner.nextInt();
		//
		// for (int i = 0; i < testCases; i++) {
		//
		// String str = scanner.nextLine();
		//
		// StringFunctions.printPermutation(str);
		//
		// }

		ArrayList<StudentComparable> listOfStudent = new ArrayList<StudentComparable>();
		listOfStudent.add(new StudentComparable(325345, "Janardhan Maithi", 26));
		listOfStudent.add(new StudentComparable(374565, "Jatin Maithi", 22));
		listOfStudent.add(new StudentComparable(546435, "Pradhyumna Maithi", 23));
		listOfStudent.add(new StudentComparable(867854, "Ashwani Maithi", 17));
		listOfStudent.add(new StudentComparable(243457, "Ayush Maithi", 13));
		listOfStudent.add(new StudentComparable(235345, "Rajat Maithi", 18));

		System.out.println(listOfStudent);
		Collections.sort(listOfStudent);
		System.out.println(listOfStudent);
	}
}
