package org.janardhan.datastructure;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.janardhan.input.InputParser;

public class DLLMain {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		InputParser inputParser = new InputParser(inputStream);
		OutputStream outputStream = System.out;
		PrintWriter printWriter = new PrintWriter(outputStream);

		DLList<Integer> dlList = new DLList<Integer>(null, null);

		int choice;

		System.out.println("Doubly Linked List Operations");
		System.out.println("1. insert at begining");
		System.out.println("2. insert at end");
		System.out.println("3. insert at position");
		System.out.println("4. delete at beginning");
		System.out.println("5. delete at end");
		System.out.println("6. delete at position");

		try {

			do {
				System.out.println("Enter your Choice");
				choice = inputParser.nextInt();

				switch (choice) {
				case 1:
					dlList.insertAtBeginning(inputParser.nextInt());
					dlList.printList();
					break;
				case 2:
					dlList.insertAtEnd(inputParser.nextInt());
					dlList.printList();
					break;
				case 3:
					dlList.insertAtPosition(inputParser.nextInt(), inputParser.nextInt());
					dlList.printList();
					break;

				case 4:
					dlList.deleteAtBeginning(inputParser.nextInt());
					dlList.printList();
					break;

				case 5:
					dlList.deleteAtEnd(inputParser.nextInt());
					dlList.printList();
					break;

				case 6:
					dlList.deleteAtPosition(inputParser.nextInt());
					dlList.printList();
					break;

				default:
					break;
				}
				System.out.println("Do you with to continue??");
			}
			while (inputParser.nextChar() == 'y');
			System.out.println("Achha jate kya tum... fir se ana bol k, hau??");
		}
		catch (Exception e) {
			e.printStackTrace();

		}

		printWriter.close();
	}

}
