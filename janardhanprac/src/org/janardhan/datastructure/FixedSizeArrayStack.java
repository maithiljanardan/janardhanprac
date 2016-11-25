package org.janardhan.datastructure;

public class FixedSizeArrayStack {

	private int[] stack;
	private int top = -1;
	private static int capacity = 10;

	public FixedSizeArrayStack() {
		this(capacity);
	}

	public FixedSizeArrayStack(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
	}

	public int size() {
		return top + 1;

	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int data) throws Exception {

		if (size() == capacity) {
			throw new Exception("Stack Overflown");
		}

		stack[++top] = data;

	}

	public int pop() throws Exception {

		int data;

		if (isEmpty()) {
			throw new Exception("Stack Underflown");
		}

		data = stack[top];
		stack[top--] = Integer.MIN_VALUE;

		return data;
	}

	public int top() {
		return stack[top];
	}

	@Override
	public String toString() {

		String s = "";

		if (size() > 0)
			s += stack[0];
		if (size() > 1) {
			for (int i = 1; i <= size() - 1; i++) {
				s += " > " + stack[i];
			}
		}

		return s;
	}
}
