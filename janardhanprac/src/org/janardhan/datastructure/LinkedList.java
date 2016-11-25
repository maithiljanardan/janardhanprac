package org.janardhan.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

	private SinglyListNode<T> head;
	private SinglyListNode<T> tail;
	private int size;

	public LinkedList(SinglyListNode<T> head, SinglyListNode<T> tail) {
		this.head = head;
		this.tail = tail;
		size = 0;

	}

	public void insertAtBeginning(T data) {

		if (head == null) {
			SinglyListNode<T> node = new SinglyListNode<T>();
			node.setData(data);
			node.setNextNode(null);
			head = node;
			tail = node;

		} else {
			SinglyListNode<T> node = new SinglyListNode<T>();
			node.setData(data);
			node.setNextNode(head);
			head = node;
		}
		size++;
	}

	public void insertAtEnd(T data) {

		if (head == null) {
			SinglyListNode<T> node = new SinglyListNode<T>();
			node.setData(data);
			node.setNextNode(null);
			head = node;
			tail = node;
		} else {
			SinglyListNode<T> node = new SinglyListNode<T>();
			node.setData(data);
			node.setNextNode(null);
			tail.setNextNode(node);
			tail = node;
		}
		size++;
	}

	public void insertAtPosition(int position, T data) {

		SinglyListNode<T> node = new SinglyListNode<T>();
		node.setData(data);
		node.setNextNode(null);

		SinglyListNode<T> temp = head;
		int pointer = 1;

		if (head == null) {
			head = tail = node;
		}
		if (position == 1) {
			node.setNextNode(head);
			head = node;
		} else {

			while (pointer < position - 1 && pointer < size) {

				temp = temp.getNextNode();
				++pointer;
			}
			node.setNextNode(temp.getNextNode());
			temp.setNextNode(node);
		}

		size++;
	}

	public void deleteAtPosition(int position) {

		SinglyListNode<T> tempNode = head;
		SinglyListNode<T> previousNode = null;

		if (position == 1) {
			head = tempNode.getNextNode();
		} else {
			for (int i = 1; i < position; i++) {
				previousNode = tempNode;
				tempNode = tempNode.getNextNode();
			}
			previousNode.setNextNode(tempNode.getNextNode());
		}
		size--;
	}

	public T deleteAtBeginning() {

		SinglyListNode<T> tempNode = head;
		head = tempNode.getNextNode();
		
		return tempNode.getData();
	}

	public void checkIfEmpty() {
		if (this.size == 0) {
			System.out.println("List is empty");
		} else {
			System.out.println("List is not empty");
		}
	}

	public void showSize() {
		System.out.println(this.size);

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

	@Override
	public Iterator<T> iterator() {

		return new LinkedListIterator();
	}

	private class LinkedListIterator<T> implements Iterator<T> {

		private SinglyListNode<T> nextNode;

		public LinkedListIterator() {
			nextNode = (SinglyListNode<T>) head;
		}

		@Override
		public boolean hasNext() {

			return nextNode != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				T data = nextNode.getData();
				nextNode = nextNode.getNextNode();
				return data;
			}
		}

	}

}
