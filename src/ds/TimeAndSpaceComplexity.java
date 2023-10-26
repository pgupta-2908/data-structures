package ds;

import java.util.Scanner;

public class TimeAndSpaceComplexity {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = scn.nextInt();
//		}
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.next();
		}

		/*
		 * int a = scn.nextInt(); int[] arr1 = new int[a]; for (int i = 0; i < a; i++) {
		 * arr1[i] = scn.nextInt(); }
		 * 
		 * int b = scn.nextInt(); int[] arr2 = new int[b]; for (int i = 0; i < b; i++) {
		 * arr2[i] = scn.nextInt(); }
		 */

//		bubbleSort(arr);
//		selectionSort(arr);		
//		insertionSort(arr);
//		print(mergeTwoSortedArrays(arr1, arr2));
//		int[] sa = mergeSort(arr, 0, arr.length - 1);
//		sort012(arr);
//		int pivot = scn.nextInt();
//		partition(arr, pivot);
//		quickSort(arr, 0, n - 1);
//		print(sa);
//		int k = scn.nextInt();
//		System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));
//	    int max = Integer.MIN_VALUE;
//	    int min = Integer.MAX_VALUE;
//	    for (int i = 0; i < n; i++) {
//	      arr[i] = scn.nextInt();
//	      max = Math.max(max, arr[i]);
//	      min = Math.min(min, arr[i]);
//	    }
//	    countSort(arr,min,max);
//		radixSort(arr);
		sortDates(arr);
		print(arr);

		scn.close();

	}

	public static void sortDates(String[] arr) {
		int div = 1;
		int mod = 10;

		// days call
		div = 1000000;
		while (div != 100000000) {
			countSort(arr, div, mod);
			div *= 10;
		}

		// months call
		div = 10000;
		while (div != 1000000) {
			countSort(arr, div, mod);
			div *= 10;
		}

		// years call
		div = 1;
		while (div != 10000) {
			countSort(arr, div, mod);
			div *= 10;
		}
	}

	public static void countSort(String[] arr, int div, int mod) {
		int[] freq = new int[10];
		for (int i = 0; i < arr.length; i++) {
			int pos = (Integer.parseInt(arr[i]) / div) % mod;
			freq[pos]++;
		}
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}
		String[] ans = new String[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = (Integer.parseInt(arr[i]) / div) % mod;
			ans[freq[pos] - 1] = arr[i];
			freq[pos]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
	}

	public static void radixSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int exp = 1;
		while (max > 0) {
			countSort(arr, exp);
			exp *= 10;
			max /= 10;
		}
	}

	public static void countSort(int[] arr, int exp) {
		int[] freq = new int[10];
		for (int i = 0; i < arr.length; i++) {
			int pos = (arr[i] / exp) % 10;
			freq[pos]++;
		}
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}
		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = (arr[i] / exp) % 10;
			ans[freq[pos] - 1] = arr[i];
			freq[pos]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
	}

	public static void countSort(int[] arr, int min, int max) {
		int[] freq = new int[max - min + 1];
		for (int i = 0; i < arr.length; i++) {
			freq[arr[i] - min]++;
		}
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}
		int[] ans = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = arr[i] - min;
			ans[freq[pos] - 1] = arr[i];
			freq[pos]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
	}

	public static int quickSelect(int[] arr, int lo, int hi, int k) {
		int pivIdx = partition(arr, arr[hi], lo, hi);
		if (k == pivIdx) {
			return arr[pivIdx];
		} else if (pivIdx > k) {
			return quickSelect(arr, lo, pivIdx - 1, k);
		} else {
			return quickSelect(arr, pivIdx + 1, hi, k);
		}
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo > hi) {
			return;
		}

		int pivIdx = partition(arr, arr[hi], lo, hi);
		quickSort(arr, lo, pivIdx - 1);
		quickSort(arr, pivIdx + 1, hi);
	}

	public static int partition(int[] arr, int pivot, int lo, int hi) {
		System.out.println("pivot -> " + pivot);
		int i = lo, j = lo;
		while (i <= hi) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
		System.out.println("pivot index -> " + (j - 1));
		return (j - 1);
	}

	public static void partition(int[] arr, int pivot) {
		int i = 0, j = 0;
		while (i < arr.length) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				j++;
			}
			i++;
		}
	}

	public static void sort012(int[] arr) {
		int i = 0, j = 0, k = arr.length - 1;
		while (i <= k) {
			if (arr[i] == 0) {
				swap(arr, i, j);
				j++;
				i++;
			} else if (arr[i] == 2) {
				swap(arr, i, k);
				k--;
			} else {
				i++;
			}
		}
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (hi == lo) {
			int[] sub = new int[1];
			sub[0] = arr[lo];
			return sub;
		}

		int mid = (hi + lo) / 2;
		int[] arr1 = mergeSort(arr, lo, mid);
		int[] arr2 = mergeSort(arr, mid + 1, hi);

		int[] ans = mergeTwoSortedArrays(arr1, arr2);
		return ans;
	}

	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
		System.out.println("Merging these two arrays ");
		System.out.print("left array -> ");
		print(a);
		System.out.print("right array -> ");
		print(b);
		int i = 0, j = 0, k = 0;
		int[] ans = new int[a.length + b.length];
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				ans[k] = a[i];
				i++;
				k++;
			} else {
				ans[k] = b[j];
				j++;
				k++;
			}
		}

		while (i < a.length) {
			ans[k] = a[i];
			k++;
			i++;
		}

		while (j < b.length) {
			ans[k] = b[j];
			k++;
			j++;
		}

		return ans;
	}

	/*
	 * public static int[] subArr(int[] arr, int start, int end) { int[] sub = new
	 * int[end - start]; for (int i = start; i < end; i++) { sub[i] = arr[i]; }
	 * return sub; }
	 */

	public static void insertionSort(int[] arr) {
		for (int itr = 1; itr < arr.length; itr++) {
			for (int i = itr; i > 0; i--) {
				if (isGreater(arr, i - 1, i)) {
					swap(arr, i - 1, i);
				} else {
					break;
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int itr = 1; itr < arr.length; itr++) {
			for (int i = itr; i > 0; i--) {
				if (isGreater(arr, i - 1, i)) {
					swap(arr, i - 1, i);
				} else {
					break;
				}
			}
		}
	}

	private static void bubbleSort(int[] arr) {
		for (int itr = 1; itr < arr.length; itr++) {
			for (int i = 0; i < arr.length - itr; i++) {
				if (isSmaller(arr, i + 1, i)) {
					swap(arr, i + 1, i);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// return true if ith element is smaller than jth element
	public static boolean isSmaller(int[] arr, int i, int j) {
		System.out.println("Comparing " + arr[i] + " and " + arr[j]);
		if (arr[i] < arr[j]) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isGreater(int[] arr, int j, int i) {
		System.out.println("Comparing " + arr[i] + " and " + arr[j]);
		if (arr[i] < arr[j]) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
