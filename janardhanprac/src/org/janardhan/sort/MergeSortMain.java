package org.janardhan.sort;

public class MergeSortMain {

	public static void main(String[] args) {

		// Inititalizing an array
		int arr[] = { 5, 0, 10, 2, 4, 1, 6 };

		// printing array before merge sort is done
		printArray(arr);

		MergeSort mergeSort = new MergeSort();

		// calling mergesort
		mergeSort.sort(arr, 0, arr.length - 1);

		// printing array after mergesort
		printArray(arr);
	}

	private static void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

	}
}

class MergeSort {

	public void sort(int[] arr, int leftIndex, int rightIndex) {

		int midIndex;

		// Check if left index is less than right index
		if (leftIndex < rightIndex) {

			// calculate mid index
			midIndex = (leftIndex + rightIndex) / 2;

			// recursively sort left subarray
			sort(arr, leftIndex, midIndex);

			// recursively sort right subarray
			sort(arr, midIndex + 1, rightIndex);

			// merge both subarrays
			merge(arr, leftIndex, midIndex, rightIndex);

		}

	}

	private void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {

		int sizeLeftSubArray = midIndex - leftIndex + 1;
		int sizeRightSubArray = rightIndex - midIndex;

		/* Create temp arrays */
		int tempLeftSubArray[] = new int[sizeLeftSubArray];
		int tempRightSubArray[] = new int[sizeRightSubArray];

		/* Copy data to temp arrays */
		for (int i = 0; i < sizeLeftSubArray; ++i)
			tempLeftSubArray[i] = arr[leftIndex + i];
		for (int j = 0; j < sizeRightSubArray; ++j)
			tempRightSubArray[j] = arr[midIndex + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = leftIndex;
		while (i < sizeLeftSubArray && j < sizeRightSubArray) {
			if (tempLeftSubArray[i] <= tempRightSubArray[j]) {
				arr[k] = tempLeftSubArray[i];
				i++;
			}
			else {
				arr[k] = tempRightSubArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < sizeLeftSubArray) {
			arr[k] = tempLeftSubArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (j < sizeRightSubArray) {
			arr[k] = tempRightSubArray[j];
			j++;
			k++;
		}
	}

}
