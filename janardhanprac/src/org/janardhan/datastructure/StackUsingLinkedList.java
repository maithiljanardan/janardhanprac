package org.janardhan.datastructure;

import java.util.Iterator;

public class StackUsingLinkedList<T> implements Iterable<T> {

	private final LinkedList<T> linkedList;

	public StackUsingLinkedList() {

		linkedList = new LinkedList<>(null, null);
	}

	public void push(T data) {

		linkedList.insertAtBeginning(data);
	}

	public T pop() {
		return linkedList.deleteAtBeginning();
	}

	public boolean isEmpty() {

		return false;
	}

	public void printStack() {
		linkedList.printList();
	}

	@Override
	public Iterator<T> iterator() {

		return linkedList.iterator();
	}

}
