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

	public void sort(int[] arr, int l, int r) {

		int m;

		// Check if left index is less than right index
		if (l < r) {

			// calculate mid index
			m = (l + r) / 2;

			// recursively sort left subarray
			sort(arr, l, m);

			// recursively sort right subarray
			sort(arr, m + 1, r);

			// merge both subarrays
			merge(arr, l, m, r);

		}

	}

	private void merge(int[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

}
