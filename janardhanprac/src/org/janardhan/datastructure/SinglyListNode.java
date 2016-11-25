package org.janardhan.datastructure;

public class SinglyListNode<T> implements Comparable<T> {

	private T data;
	private SinglyListNode<T> nextNode;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyListNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(SinglyListNode<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public int compareTo(T element) {

		if (element == this.data) {
			return 1;
		} else {
			return 0;
		}

	}

}
