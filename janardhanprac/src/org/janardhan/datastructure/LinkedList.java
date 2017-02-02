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

	/*
	 * Function to swap Nodes x and y in linked list by changing links
	 */
	public void swapNodes(T x, T y) {

		// Nothing to do if x and y are same
		if (x == y)
			return;

		// Search for x (keep track of prevX and CurrX)
		SinglyListNode<T> prevX = null, currX = head;
		while (currX != null && currX.getData() != x) {
			prevX = currX;
			currX = currX.getNextNode();
		}

		// Search for y (keep track of prevY and currY)
		SinglyListNode<T> prevY = null, currY = head;
		while (currY != null && currY.getData() != y) {
			prevY = currY;
			currY = currY.getNextNode();
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return;

		// If x is not head of linked list
		if (prevX != null)
			prevX.setNextNode(currY);
		else // make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.setNextNode(currX);
		else // make x the new head
			head = currX;

		// Swap next pointers
		SinglyListNode<T> temp = currX.getNextNode();
		currX.setNextNode(currY.getNextNode());
		currY.setNextNode(temp);
	}

	/* Takes index as argument and return data at index */
	public int GetNth(int index) {
		SinglyListNode<T> current = head;
		int count = 0; /*
						 * index of Node we are currently looking at
						 */
		while (current != null) {
			if (count == index)
				return (int) current.getData();
			count++;
			current = current.getNextNode();
		}

		/*
		 * if we get to this line, the caller was asking for a non-existent
		 * element so we assert fail
		 */
		assert (false);
		return 0;
	}

	/* Function to print middle of linked list */
	void printMiddle() {

		SinglyListNode<T> slow_ptr = head;
		SinglyListNode<T> fast_ptr = head;

		if (head != null) {

			while (fast_ptr != null && fast_ptr.getNextNode() != null) {

				fast_ptr = fast_ptr.getNextNode().getNextNode();
				slow_ptr = slow_ptr.getNextNode();
			}

			System.out.println("The middle element is [" + slow_ptr.getData() + "] \n");
		}
	}

	/*
	 * Function to get the nth node from the last of a linked list
	 */
	void printNthFromLast(int n) {

		int len = 0;

		SinglyListNode<T> temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {

			temp = temp.getNextNode();
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n)
			return;

		temp = head;

		// 2) get the (n-len+1)th node from the begining
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.getNextNode();

		System.out.println(temp.getData());
	}

	/* Function deletes the entire linked list */
	void deleteList() {
		head = null;
	}

	/*
	 * Counts the no. of occurences of a node (search_for) in a linked list
	 * (head)
	 */
	public int count(T search_for) {

		SinglyListNode<T> current = head;
		int count = 0;
		while (current != null) {
			if (current.getData() == search_for)
				count++;
			current = current.getNextNode();
		}
		return count;
	}

	/* Function to reverse the linked list iteratively */
	public SinglyListNode<T> reverse(SinglyListNode<T> node) {

		SinglyListNode<T> prev = null;
		SinglyListNode<T> current = node;
		SinglyListNode<T> next = null;

		while (current != null) {

			next = current.getNextNode();
			current.setNextNode(prev);
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	public void reverseRecUtil(SinglyListNode<T> node) {

		if (node == null)
			return;
		SinglyListNode<T> currentNode = node;

		if (node.getNextNode() == null)
			return;

		reverseRecUtil(node.getNextNode());

		currentNode.getNextNode().setNextNode(currentNode);

		currentNode.setNextNode(null);

		node = currentNode.getNextNode();
	}

	public void reverseRecursively() {
		reverseRecUtil(head);
	}

	/**
	 * Floyd’s Cycle-Finding Algorithm
	 * 
	 */
	public int detectLoop() {

		SinglyListNode<T> slow_p = head, fast_p = head;

		while (slow_p != null && fast_p != null && fast_p.getNextNode() != null) {

			slow_p = slow_p.getNextNode();
			fast_p = fast_p.getNextNode().getNextNode();

			if (slow_p == fast_p) {

				System.out.println("Found loop");
				return 1;
			}
		}
		return 0;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////
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
