package org.janardhan.datastructure;

public class StackUsingLinkedListMain {

	public static void main(String[] args) {

		StackUsingLinkedList<Integer> stackUsingLinkedList = new StackUsingLinkedList<>();

		stackUsingLinkedList.push(1);
		stackUsingLinkedList.printStack();
		stackUsingLinkedList.push(2);
		stackUsingLinkedList.printStack();
		stackUsingLinkedList.pop();
		stackUsingLinkedList.printStack();

	}
}
