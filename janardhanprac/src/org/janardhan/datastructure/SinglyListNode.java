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
		}
		else {
			return 0;
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nextNode == null) ? 0 : nextNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinglyListNode other = (SinglyListNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		}
		else if (!data.equals(other.data))
			return false;
		if (nextNode == null) {
			if (other.nextNode != null)
				return false;
		}
		else if (!nextNode.equals(other.nextNode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SinglyListNode [data=" + data + ", nextNode=" + nextNode + "]";
	}

}
