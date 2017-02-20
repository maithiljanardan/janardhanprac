package org.janardhan.sort;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 51, 26, 93, 17, 77, 31, 44, 55, 20 };

		System.out.println("Before QuickSort \n");

		for (int i : arr) {
			System.err.print(i + "\t");
		}
		quickSort(arr);

		System.out.println("\nAfter QuickSort \n");

		for (int i : arr) {
			System.err.print(i + "\t");
		}

	}

	private static void quickSort(int[] arr) {
		quickSortHelper(arr, 0, arr.length - 1);

	}

	private static void quickSortHelper(int[] arr, int first, int last) {

		if (first < last) {

			int splitPoint = partition(arr, first, last);
			quickSortHelper(arr, first, splitPoint - 1);
			quickSortHelper(arr, splitPoint + 1, last);
		}

	}

	private static int partition(int[] arr, int first, int last) {

		int pivotValue = arr[first];
		int leftMark = first + 1;
		int rightMark = last;
		int temp;

		boolean flag = false;

		while (!flag) {
			while (leftMark <= rightMark && arr[leftMark] <= pivotValue)
				leftMark += 1;
			while (rightMark >= leftMark && arr[rightMark] >= pivotValue)
				rightMark -= 1;
			if (leftMark > rightMark)
				flag = true;
			else {
				temp = arr[leftMark];
				arr[leftMark] = arr[rightMark];
				arr[rightMark] = temp;
			}
		}

		temp = arr[first];
		arr[first] = arr[rightMark];
		arr[rightMark] = temp;

		return rightMark;

	}
}
