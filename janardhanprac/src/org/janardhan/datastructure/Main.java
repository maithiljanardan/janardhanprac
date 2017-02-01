package org.janardhan.datastructure;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.janardhan.input.InputParser;

public class Main {

	public static void main(String[] args) throws Exception {

		InputStream inputStream = System.in;
		InputParser inputParser = new InputParser(inputStream);
		OutputStream outputStream = System.out;
		PrintWriter printWriter = new PrintWriter(outputStream);

		LinkedList<Integer> linkedList = new LinkedList<Integer>(null, null);

		char choice;

		System.out.println("Singly Linked List Operations\n");
		System.out.println("A. insert at begining");
		System.out.println("B. insert at end");
		System.out.println("C. insert at position");
		System.out.println("D. delete at position");
		System.out.println("E. check empty");
		System.out.println("F. get size");
		System.out.println("G. search");

		do {

			choice = inputParser.nextChar();

			switch (choice) {
			case 'A':
				linkedList.insertAtBeginning(inputParser.nextInt());
				linkedList.printList();
				break;
			case 'B':
				linkedList.insertAtEnd(inputParser.nextInt());
				linkedList.printList();
				break;
			case 'C':
				linkedList.insertAtPosition(inputParser.nextInt(), inputParser.nextInt());
				linkedList.printList();
				break;

			case 'D':
				linkedList.deleteAtPosition(inputParser.nextInt());
				linkedList.printList();
				break;

			case 'E':
				linkedList.checkIfEmpty();
				break;

			case 'F':
				linkedList.showSize();
				break;
			case 'G':
				int pos = linkedList.searchNode(null,5);
				System.out.println("Node found at position " + pos);
				break;
			default:
				break;
			}
			System.out.println("Do you with to continue??");
		} while (inputParser.nextChar() == 'Y');

		printWriter.close();
	}

}
