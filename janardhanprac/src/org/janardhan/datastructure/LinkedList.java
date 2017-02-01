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

	/**
	 * This method inserts a new nod at the beginning of the list
	 * 
	 * @param data
	 */
	public void insertAtBeginning(T data) {

		// if no node is present create a new node and mark it head node
		if (head == null) {
			SinglyListNode<T> node = new SinglyListNode<T>();
			node.setData(data);
			node.setNextNode(null);
			head = node;
			tail = node;

		}
		// Create a new node and point it to head and then make this node head
		// node
		else {
			SinglyListNode<T> node = new SinglyListNode<T>();
			node.setData(data);
			node.setNextNode(head);
			head = node;
		}

		size++; // increment size
	}

	/**
	 * This method inserts a new node at the end of the list
	 * 
	 * @param data
	 */
	public void insertAtEnd(T data) {

		// if list is empty, create a new node and mark it as head node
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

	/**
	 * This method insets a new node at some position
	 * 
	 * @param position
	 * @param data
	 */
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

	/**
	 * Delete a node at some position
	 * 
	 * @param position
	 */
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

	/**
	 * deleting a starting node
	 * 
	 * @return
	 */
	public T deleteAtBeginning() {

		SinglyListNode<T> tempNode = head;
		head = tempNode.getNextNode();

		return tempNode.getData();
	}

	/**
	 * @author jd
	 */
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

	/**
	 * this method print a list
	 */
	public void printList() {

		System.out.println("Size of the list is >>>> " + this.size);
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			T t = (T) iterator.next();
			System.out.print(t + "-->");
		}
		System.out.println();
	}

	/**
	 * wrapper method to get the size of the head
	 * 
	 * @return
	 */
	public int getSize() {
		return getSize(head);
	}

	/**
	 * Iterative version of getting list size
	 * 
	 */
	private int getSize(SinglyListNode<T> node) {
		if (node == null)
			return 0;
		return 1 + getSize(node.getNextNode());
	}

	/**
	 * Recursive implementation of searching a node
	 * 
	 * @param data
	 * @return
	 */
	public int searchNode(SinglyListNode<T> node, T data) {

		// Code to prevent the loop to go into eternity still need to be written
		if (node == null)
			node = head;
		if (node.getData() == data)
			return 1;
		return 1 + searchNode(node.getNextNode(), data);

	}

	@Override
	public Iterator<T> iterator() {

		return new LinkedListIterator<T>();
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
