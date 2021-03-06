package org.janardhan.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefixConversionMain {

	public static void main(String[] args) {

		String infixString = new Scanner(System.in).nextLine();

		// reverse everything except brakcets
		infixString = reverseString(infixString);

		// After replace ( )
		InfixToPrefixConversionMain.InfixToPrefixConversion infixToPrefixConversion = new InfixToPrefixConversionMain().new InfixToPrefixConversion();

		// call same method as in infix to postfix
		String postfixString = infixToPrefixConversion.convertToPostfix(infixString);

		postfixString = reverseString(postfixString);

		System.out.println(postfixString);
	}

	private static String reverseString(String infixString) {

		if (infixString == null || infixString.length() <= 1) {

			return infixString;
		}
		return reverseString(infixString.substring(1)) + infixString.charAt(0);
	}

	private class InfixToPrefixConversion {

		public String convertToPostfix(String infixString) {

			char ch;
			String postfixString = "";

			Stack<Character> stack = new Stack<>();

			if (infixString == null || infixString.equals(""))
				return postfixString;

			for (int i = 0; i < infixString.length(); i++) {

				ch = infixString.charAt(i);

				if (Character.isLetter(ch))
					postfixString = postfixString + ch;
				else if (ch == '(')
					stack.push(ch);
				else if (ch == ')') {
					while (stack.peek() != '(')
						postfixString = postfixString + stack.pop();
					stack.pop();
				}
				else {
					while (!stack.empty() && !(stack.peek() == '(') && precedence(ch) <= precedence(stack.peek())) {
						postfixString = postfixString + stack.pop();
					}
					stack.push(ch);
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
