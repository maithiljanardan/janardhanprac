package org.janardhan.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLList<T> implements Iterable<T> {

	private DLLNode<T> head;
	private DLLNode<T> tail;
	int size;

	public DLList(DLLNode<T> head, DLLNode<T> tail) {
		head = tail = null;
		size = 0;
	}

	@Override
	public Iterator<T> iterator() {

		return new DLListIterator();
	}

	private class DLListIterator implements Iterator<T> {

		private DLLNode<T> nextNode;

		public DLListIterator() {

			nextNode = head;
		}

		@Override
		public boolean hasNext() {

			return nextNode != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				T data = nextNode.getData();
				nextNode = nextNode.getNextNode();
				return data;
			}
		}

	}

	public void insertAtBeginning(T data) {

		DLLNode<T> dllNode = new DLLNode<T>();
		dllNode.setData(data);

		if (head == null) {
			head = dllNode;
			head.setNextNode(null);
			head.setPreviousNode(null);
		}
		else {
			dllNode.setNextNode(head);
			dllNode.setPreviousNode(null);
			head.setPreviousNode(dllNode);
			head = dllNode;
		}
		size++;
	}

	public void printList() {

		System.out.println("Size of the list is >>>> " + this.size);
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			T t = (T) iterator.next();
			System.out.print(t + "-->");
		}
		System.out.println();
	}

	public void insertAtEnd(int nextInt) {
		// TODO Auto-generated method stub

	}

	public void insertAtPosition(int nextInt, int nextInt2) {
		// TODO Auto-generated method stub

	}

	public void deleteAtPosition(int nextInt) {
		// TODO Auto-generated method stub

	}

	public void checkIfEmpty() {
		// TODO Auto-generated method stub

	}

	public void showSize() {
		// TODO Auto-generated method stub

	}

	public void deleteAtBeginning(int nextInt) {
		// TODO Auto-generated method stub

	}

	public void deleteAtEnd(int nextInt) {
		// TODO Auto-generated method stub

	}

}
