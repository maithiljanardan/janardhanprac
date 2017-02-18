package org.janardhan.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		}
		else {
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
		}
		else {

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
		}
		else {
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
		}
		else {
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

	/*
	 * Takes two lists sorted in increasing order, and splices their nodes
	 * together to make one big sorted list which is returned.
	 */
	public SinglyListNode<T> mergeSortedList(LinkedList<T> listA, LinkedList<T> listB) {

		// A dummy node
		SinglyListNode<T> dummyNode = new SinglyListNode<>();

		while (true) {

			if (listA == null) {
				dummyNode.setNextNode(listB.head);
				break;
			}
			else if (listB == null) {
				dummyNode.setNextNode(listA.head);
				break;
			}

			if ((int) listA.head.getData() <= (int) listB.head.getData()) {
				moveNode(dummyNode, listA.head);
			}
			else {
				moveNode(dummyNode, listB.head);
			}

			dummyNode = dummyNode.getNextNode();
		}

		return dummyNode.getNextNode();

	}

	/**
	 * write code to add node to the result list
	 * 
	 * @param destNode
	 * @param sourceNode
	 */
	private void moveNode(SinglyListNode<T> destNode, SinglyListNode<T> sourceNode) {

	}

	/**
	 * 
	 * @param nodeA
	 *            this is the head node of list A
	 * @param nodeB
	 *            this is the head node of list B
	 * @return
	 */
	public SinglyListNode<T> mergeSortedListRecursively(SinglyListNode<T> nodeA, SinglyListNode<T> nodeB) {

		SinglyListNode<T> result = new SinglyListNode<>();

		// If listA is empty result is listB
		if (nodeA == null) {
			return nodeB;
		}
		else if (nodeB == null) {
			return nodeA;
		}

		// recur
		if ((int) nodeA.getData() <= (int) nodeB.getData()) {
			result = nodeA;
			result.setNextNode(mergeSortedListRecursively(nodeA.getNextNode(), nodeB));
		}
		else {
			result = nodeB;
			result.setNextNode(mergeSortedListRecursively(nodeA, nodeB.getNextNode()));
		}
		return result;
	}

	/**
	 * @author jd
	 * @param headNode
	 * @param newNode
	 */
	public void insertIntoSortedList(SinglyListNode<T> headNode, SinglyListNode<T> newNode) {

		SinglyListNode<T> currentNode;

		/* Special case for the head end */
		if (headNode == null || (int) headNode.getData() >= (int) newNode.getData()) {
			newNode.setNextNode(headNode);
			headNode = newNode;
		}
		else {

			/* Locate the node before the point of insertion */
			currentNode = headNode;

			while (currentNode.getNextNode() != null && (int) currentNode.getNextNode().getData() < (int) newNode.getData()) {
				currentNode = currentNode.getNextNode();
			}

			newNode.setNextNode(currentNode.getNextNode());
			currentNode.setNextNode(newNode);
		}
	}

	/**
	 * Function to print reverse of linked list
	 * 
	 * @author jd
	 * @param head
	 */
	public void printReverse(SinglyListNode<T> node) {
		if (node == null)
			return;

		// print list of head node
		printReverse(node.getNextNode());

		// After everything else is printed
		System.out.print(node.getData() + " ");
	}

	/**
	 * reverse k nodes
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public SinglyListNode<T> reverse(SinglyListNode<T> node, int k) {

		SinglyListNode<T> currentNode = node;
		SinglyListNode<T> nextNode = null;
		SinglyListNode<T> prevNode = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (nextNode != null)
			node.setNextNode(reverse(nextNode, k));

		// prev is now head of input list
		return prevNode;
	}

	/**
	 * @author jd Reverses alternate k nodes and returns the pointer to the new
	 *         head node
	 */
	public SinglyListNode<T> kAltReverse(SinglyListNode<T> node, int k) {

		SinglyListNode<T> currentNode = node;
		SinglyListNode<T> nextNode = null, prevNode = null;
		int count = 0;

		/* 1) reverse first k nodes of the linked list */
		while (currentNode != null && count < k) {

			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
			count++;
		}

		/*
		 * 2) Now head points to the kth node. So change next of head to (k+1)th
		 * node
		 */
		if (node != null) {
			node.setNextNode(currentNode);
		}

		/*
		 * 3) We do not want to reverse next k nodes. So move the current
		 * pointer to skip next k nodes
		 */
		count = 0;
		while (count < k - 1 && currentNode != null) {
			currentNode = currentNode.getNextNode();
			count++;
		}

		/*
		 * 4) Recursively call for the list starting from current->next. And
		 * make rest of the list as next of first node
		 */
		if (currentNode != null) {
			currentNode.setNextNode(kAltReverse(currentNode.getNextNode(), k));
		}

		/* 5) prev is new head of the input list */
		return prevNode;
	}

	/**
	 * @author jd
	 * 
	 *         Deletes nodes which have a greater value on right side
	 */
	public SinglyListNode<T> deleteRightNodeWithGrValue(SinglyListNode<T> node) {

		SinglyListNode<T> prevNode, currentNode, nextNode;

		// make current node as head node
		currentNode = node;

		// make previous node as null
		prevNode = null;

		while (currentNode.getNextNode() != null) {

			// get the next node
			nextNode = currentNode.getNextNode();

			if ((int) currentNode.getData() < (int) nextNode.getData()) {
				// If current node is smaller than the next Node and its the
				// head node also then move the head pointer to the next node
				if (prevNode == null) {
					node = node.getNextNode();
				}

				// else just delete the current node
				else {
					prevNode.setNextNode(nextNode);
				}

			}

			else {
				prevNode = currentNode;
			}
			currentNode = nextNode;

		}

		return node;

	}

	/**
	 * This function rotates a linked list counter-clockwise and updates the
	 * head. The function assumes that k is smaller than size of linked list. It
	 * doesn't modify the list if k is greater than or equal to size
	 * 
	 * @author jd
	 * @param k
	 */

	public void rotateList(int k) {
		if (k == 0)
			return;

		// Let us understand the below code for example k = 4
		// and list = 10->20->30->40->50->60.
		SinglyListNode<T> currentNode = head;

		// current will either point to kth or NULL after this
		// loop. current will point to node 40 in the above example
		int count = 1;
		while (count < k && currentNode != null) {
			currentNode = currentNode.getNextNode();
			count++;
		}

		// If current is NULL, k is greater than or equal to count
		// of nodes in linked list. Don't change the list in this case
		if (currentNode == null)
			return;

		// current points to kth node. Store it in a variable.
		// kthNode points to node 40 in the above example
		SinglyListNode<T> kthNode = currentNode;

		// current will point to last node after this loop
		// current will point to node 60 in the above example
		while (currentNode.getNextNode() != null)
			currentNode = currentNode.getNextNode();

		// Change next of last node to previous head
		// Next of 60 is now changed to node 10

		currentNode.setNextNode(head);

		// Change head to (k+1)th node
		// head is now changed to node 50
		head = kthNode.getNextNode();

		// change next of kth node to null
		kthNode.setNextNode(null);

	}

	/**
	 * This method sorts a list which contains 0s, 1s and 2s only. The algo is
	 * 1) Traverse the list and count the number of 0s, 1s and 2s. Let the
	 * counts be n1, n2 and n3 respectively. 2) Traverse the list again, fill
	 * the first n1 nodes with 0, then n2 nodes with 1 and finally n3 nodes with
	 * 2.
	 * 
	 * @param node
	 */
	public void sortListWithZeroOneAndTwo(SinglyListNode<T> node) {

		// initialize count of 0 1 and 2 as 0
		int count[] = { 0, 0, 0 };

		SinglyListNode<T> ptr = head;

		/*
		 * count total number of '0', '1' and '2' count[0] will store total
		 * number of '0's count[1] will store total number of '1's count[2] will
		 * store total number of '2's
		 */
		while (ptr != null) {
			count[(int) ptr.getData()]++;
			ptr = ptr.getNextNode();
		}

		int i = 0;
		ptr = head;

		/*
		 * Let say count[0] = n1, count[1] = n2 and count[2] = n3 now start
		 * traversing list from head node, 1) fill the list with 0, till n1 > 0
		 * 2) fill the list with 1, till n2 > 0 3) fill the list with 2, till n3
		 * > 0
		 */
		while (ptr != null) {
			if (count[i] == 0)
				i++;
			else {
				// ptr.setData(i); commented since int mofo wont cast to T
				--count[i];
				ptr = ptr.getNextNode();
			}
		}

	}

	/**
	 * Adds contents of two linked lists and return the head node of resultant
	 * list. This method expects lists in reverse order. So the LSB becomes MSB
	 * 
	 * @author jd
	 * @return
	 */
	public SinglyListNode<T> addTwoLists(SinglyListNode<T> first, SinglyListNode<T> second) {

		SinglyListNode<T> res = null; // res is head node of the resultant list
		SinglyListNode<T> prev = null;
		SinglyListNode<T> temp = null;

		int carry = 0, sum;

		while (first != null || second != null) // while both lists exist
		{
			// Calculate value of next digit in resultant list.
			// The next digit is sum of following things
			// (i) Carry
			// (ii) Next digit of first list (if there is a next digit)
			// (ii) Next digit of second list (if there is a next digit)
			sum = carry + (first != null ? (int) first.getData() : 0) + (second != null ? (int) second.getData() : 0);

			// update carry for next calulation
			carry = (sum >= 10) ? 1 : 0;

			// update sum if it is greater than 10
			sum = sum % 10;

			// Create a new node with sum as data
			temp = new SinglyListNode<T>();
			// temp.setData(sum); commented since int mofo wont cast to T

			// if this is the first node then set it as head of
			// the resultant list
			if (res == null) {
				res = temp;
			}
			else // If this is not the first node then connect it to the rest.
			{
				prev.setNextNode(temp);
			}

			// Set prev for next insertion
			prev = temp;

			// Move first and second pointers to next nodes
			if (first != null) {
				first = first.getNextNode();
			}
			if (second != null) {
				second = second.getNextNode();
			}
		}

		if (carry > 0) {
			temp.setNextNode(new SinglyListNode<>());
			// temp.getNextNode().setData(carry);commented since int mofo wont
			// cast to T
		}

		// return head of the resultant list
		return res;
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
			}
			else {
				T data = nextNode.getData();
				nextNode = nextNode.getNextNode();
				return data;
			}
		}

	}

	public SinglyListNode<T> getHead() {
		return head;
	}

	public void setHead(SinglyListNode<T> head) {
		this.head = head;
	}

	public SinglyListNode<T> getTail() {
		return tail;
	}

	public void setTail(SinglyListNode<T> tail) {
		this.tail = tail;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
