package org.janardhan.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixConversionMain {

	public static void main(String[] args) {

		// Takes infix expression as input
		String infixString = new Scanner(System.in).nextLine();

		// Instantiating Inner or Non-static class
		InfixToPostfixConversionMain.InfixToPostfixConversion infixToPostfixConversion = new InfixToPostfixConversionMain().new InfixToPostfixConversion();

		String postfixString = infixToPostfixConversion.convertToPostfix(infixString);

		System.out.println(postfixString);
	}

	private class InfixToPostfixConversion {

		public String convertToPostfix(String infixString) {

			char currentChar;
			String postfixString = "";

			Stack<Character> stack = new Stack<>();

			if (infixString == null || infixString.equals(""))
				return postfixString;

			for (int i = 0; i < infixString.length(); i++) {

				// Iterate over the characters in string
				currentChar = infixString.charAt(i);

				// If character is a letter just add it to postfix expression
				if (Character.isLetter(currentChar))
					postfixString = postfixString + currentChar;

				// Push if bracket starts
				else if (currentChar == '(')
					stack.push(currentChar);

				// Pop it bracket end if ) is encountered
				else if (currentChar == ')') {

					while (stack.peek() != '(')
						postfixString = postfixString + stack.pop();

					// finally pop (
					stack.pop();
				}
				else {

					// If the precedence of current character is less than peek
					// valuse and stack is non empty and peek value is not (
					// then pop it
					while (!stack.empty() && !(stack.peek() == '(') && precedence(currentChar) <= precedence(stack.peek())) {
						postfixString = postfixString + stack.pop();
					}
					stack.push(currentChar);
				}

			}
			while (!stack.isEmpty())
				postfixString = postfixString + stack.pop();
			return postfixString;
		}

		public int precedence(char ch) {

			if (ch == '+' || ch == '-')
				return 1;
			else if (ch == '*' || ch == '/' || ch == '%')
				return 2;
			else
				return 0;
		}

	}
}
