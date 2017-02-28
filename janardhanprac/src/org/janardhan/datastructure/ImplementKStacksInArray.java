package org.janardhan.datastructure;

public class ImplementKStacksInArray {

	private int[] arr;
	private int[] top;
	private int[] next;
	private static final int K = 3;
	private static final int N = 10;
	private int free;

	public ImplementKStacksInArray() {
		this(K, N);
	}

	public ImplementKStacksInArray(int k, int n) {
		arr = new int[n];
		next = new int[n];
		top = new int[k];
		free = 0;

		for (int i = 0; i < k; i++) {
			top[i] = -1;
		}

		for (int j = 0; j < n - 1; j++) {
			next[j] = j + 1;
		}

		next[n - 1] = -1;
	}

	public void push(int ele, int stack) {
		// Overflow check
		if (isFull()) {
			System.out.println("Stack Overflown \n");
			return;
		}

		int i = free; // Store index of first free slot

		// Update index of free slot to index of next slot in free list
		free = next[i];

		// Update next of top and then top for stack number 'sn'
		next[i] = top[stack];
		top[stack] = i;

		// Put the item in array
		arr[i] = ele;
	}

	private boolean isFull() {

		return (free == -1);
	}

	// To check whether stack number 'sn' is empty or not
	private boolean isEmpty(int stack) {
		return (top[stack] == -1);
	}

	public int pop(int stack) {
		// Underflow check
		if (isEmpty(stack)) {
			System.out.println("Stack Underflown \n");
			return Integer.MAX_VALUE;
		}

		// Find index of top item in stack number 'sn'
		int i = top[stack];

		top[stack] = next[i]; // Change top to store next of previous top

		// Attach the previous top to the beginning of free list
		next[i] = free;
		free = i;

		// Return the previous top item
		return arr[i];
	}

	public static void main(String[] args) {

		ImplementKStacksInArray kStacks = new ImplementKStacksInArray();

		// Let us put some items in stack number 2
		kStacks.push(15, 2);
		kStacks.push(45, 2);

		// Let us put some items in stack number 1
		kStacks.push(17, 1);
		kStacks.push(49, 1);
		kStacks.push(39, 1);

		// Let us put some items in stack number 0
		kStacks.push(11, 0);
		kStacks.push(9, 0);
		kStacks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + kStacks.pop(2));
		System.out.println("Popped element from stack 1 is " + kStacks.pop(1));
		System.out.println("Popped element from stack 0 is " + kStacks.pop(0));
	}
}
