package org.janardhan.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class BalancingOfSymbolsUsingStackMain {

	public static void main(String[] args) {

		BalancingOfSymbolsUsingStack balancingOfSymbolsUsingStack = new BalancingOfSymbolsUsingStack();
		Scanner scanner = new Scanner(System.in);
		boolean flag = balancingOfSymbolsUsingStack.isTextBalanced(scanner.nextLine());
		if (flag == true) {
			System.out.println("String is Balanced");
		} else {
			System.out.println("String is not Balanced");
		}
		scanner.close();
	}
}

class BalancingOfSymbolsUsingStack {

	Stack<Character> stack = new Stack<>();

	public boolean isTextBalanced(String string) {

		char c;
		if (string == null || string.isEmpty()) {

			return true;
		}

		for (int i = 0; i < string.length(); i++) {

			c = string.charAt(i);

			if (c == ')') {

				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					return false;

				}
			} else if (c == '}') {
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;

				}
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					return false;

				}
			} else if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
