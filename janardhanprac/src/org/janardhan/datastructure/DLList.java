package org.janardhan.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.janardhan.tree.TreeNode;

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

	public DLLNode<T> bTreeToCList(DLLNode<T> node) {

		if (node == null)
			return null;

		// Recursively convert left and right subtrees
		DLLNode<T> left = bTreeToCList(node.getPreviousNode());
		DLLNode<T> right = bTreeToCList(node.getNextNode());

		// Make a circular linked list of single node
		// (or root). To do so, make the right and
		// left pointers of this node point to itself
		node.setPreviousNode(node);
		node.setNextNode(node);
		// Step 1 (concatenate the left list with the list
		// with single node, i.e., current node)
		// Step 2 (concatenate the returned list with the
		// right List)
		return concatenate(concatenate(left, node), right);
	}

	// concatenate both the lists and returns the head
	// of the List
	public DLLNode<T> concatenate(DLLNode<T> leftList, DLLNode<T> rightList) {
		// If either of the list is empty, then
		// return the other list
		if (leftList == null)
			return rightList;
		if (rightList == null)
			return leftList;

		// Store the last Node of left List
		DLLNode<T> leftLast = leftList.getPreviousNode();

		// Store the last Node of right List
		DLLNode<T> rightLast = rightList.getNextNode();

		// Connect the last node of Left List
		// with the first Node of the right List
		leftLast.setNextNode(rightLast);
		rightList.setPreviousNode(leftLast);

		// left of first node refers to
		// the last node in the list
		leftList.setPreviousNode(rightLast);

		// Right of last node refers to the first
		// node of the List
		rightLast.setNextNode(leftLast);

		// Return the Head of the List
		return leftList;
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
