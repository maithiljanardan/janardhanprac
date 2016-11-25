package org.janardhan.datastructure;

public class FixedSizeArrayStackMain {

	public static void main(String[] args) {

		FixedSizeArrayStack fixedSizeArrayStack = new FixedSizeArrayStack(10);

		try {

			fixedSizeArrayStack.push(4);
			System.out.println(fixedSizeArrayStack.isEmpty());
			System.out.println(fixedSizeArrayStack);
			fixedSizeArrayStack.push(2);
			System.out.println(fixedSizeArrayStack);
			fixedSizeArrayStack.push(5);
			System.out.println(fixedSizeArrayStack);
			fixedSizeArrayStack.pop();
			System.out.println(fixedSizeArrayStack);
			fixedSizeArrayStack.pop();
			System.out.println(fixedSizeArrayStack);
			fixedSizeArrayStack.pop();
			System.out.println(fixedSizeArrayStack);
			fixedSizeArrayStack.pop();
			System.out.println(fixedSizeArrayStack);
			fixedSizeArrayStack.pop();
			System.out.println(fixedSizeArrayStack);
//			System.out.println(fixedSizeArrayStack);
//			fixedSizeArrayStack.push(1);
//			System.out.println(fixedSizeArrayStack);
//			fixedSizeArrayStack.push(4);
//			System.out.println(fixedSizeArrayStack);
//			fixedSizeArrayStack.pop();
//			System.out.println(fixedSizeArrayStack);

		} catch (Throwable throwable) {

			System.out.println(throwable.getMessage());

		}

	}
}
