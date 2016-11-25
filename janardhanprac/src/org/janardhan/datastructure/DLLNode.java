package org.janardhan.datastructure;

public class DLLNode<T> implements Comparable<T> {

	private T data;
	private DLLNode<T> nextNode;
	private DLLNode<T> previousNode;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DLLNode<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(DLLNode<T> nextNode) {
		this.nextNode = nextNode;
	}

	public DLLNode<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(DLLNode<T> previousNode) {
		this.previousNode = previousNode;
	}

	@Override
	public int compareTo(T t) {

		if (t == this.data) {
			return 1;
		} else {
			return 0;
		}

	}

}
