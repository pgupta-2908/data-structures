package ds;

import java.util.ArrayList;
import java.util.List;

public class FunctionsAndArrays {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(10);
		list.add(10);
		list.add(20);

		int size = list.size();
		System.out.println( "size = " + size);
		int start = 0;
		while(start < size) {
			for(int i = start + 1 ; i < size; i++) {
					if(list.get(start) == list.get(i)) {
						list.remove(i);
						i--;
						size--;
					}
			}
			start++;
		}
		
		System.out.println(list);
		
//		Scanner scn = new Scanner(System.in);
//
//		/*
//		 * int q = scn.nextInt(); int w = scn.nextInt(); Abg abg = new Abg(); abg.a = q;
//		 * abg.b = w;
//		 * 
//		 * Abg abg1 = (Abg) abg.clone(); System.out.println("abg" + abg.a);
//		 * System.out.println("abg1" + abg1.a);
//		 * 
//		 * abg.a = 10;
//		 * 
//		 * System.out.println("new abg = " + abg.a); System.out.println("new abg1 = " +
//		 * abg1.a);
//		 */
////		int n = scn.nextInt();
////		int d = scn.nextInt();
//
////		int b = scn.nextInt();
////		int n1 = scn.nextInt();
////		int n2 = scn.nextInt();
//
//		int n = scn.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = scn.nextInt();
//		}
//		 int k = scn.nextInt();

		/*
		 * int n1 = scn.nextInt(); int[] arr1 = new int[n1]; for (int i = 0; i < n1;
		 * i++) { arr1[i] = scn.nextInt(); } int n2 = scn.nextInt(); int[] arr2 = new
		 * int[n2]; for (int i = 0; i < n2; i++) { arr2[i] = scn.nextInt(); }
		 */

		// System.out.println(digitFrequency(n, d));
		// System.out.println(decimalToAnyBase(n, b));
		// System.out.println(anyBaseToDecimal(n, b));
		// System.out.println(anyBaseToAnyBase(n, d, b));
		// System.out.println(anyBaseAddition(b, n1, n2));
		// System.out.println(anyBaseSubraction(b, n1, n2));
		// System.out.println(anyBaseMultiplication(b, n1, n2));
		// System.out.println(spanOfArray(arr));
		// System.out.println(findElementInArray(arr, d));
		// sumOfTwoArrays(arr1, arr2);
		// differenceOfTwoArrays(arr1, arr2);
		// reverseArray(arr, 0, arr.length-1);
		// rotateArray(arr, k);
		// barChartOfArray(arr);
		// inverseOfArray(arr);
		// subArrayProblem(arr);
		// subsetsOfArray(arr);
//		 ceilFloor(arr, k);
		// firstIndexLastIndex(arr, d);
//		scn.close();

	}

	public static int digitFrequency(int n, int d) {
		int freq = 0;
		while (n > 0) {
			if (n % 10 == d) {
				freq++;
			}
			n /= 10;
		}
		return freq;
	}

	public static int decimalToAnyBase(int n, int b) {
		int ans = 0;
		int counter = 1;
		while (n > 0) {
			int rem = n % b;
			ans += rem * counter;
			n /= b;
			counter *= 10;
		}
		return ans;
	}

	public static int anyBaseToDecimal(int n, int b) {
		int ans = 0;
		int multiplier = 1;
		while (n > 0) {
			int rem = n % 10;
			ans += rem * multiplier;
			n /= 10;
			multiplier *= b;
		}
		return ans;
	}

	public static int anyBaseToAnyBase(int n, int b1, int b2) {
		int ans = 0;
		ans = anyBaseToDecimal(n, b1);
		ans = decimalToAnyBase(ans, b2);
		return ans;
	}

	public static int anyBaseAddition(int b, int n1, int n2) {
		int ans = 0;
		int carry = 0;
		int multiplier = 1;
		while (n1 > 0 || n2 > 0 || carry > 0) {
			int r1 = n1 % 10;
			int r2 = n2 % 10;
			ans += ((r1 + r2 + carry) % b) * multiplier;
			carry = (r1 + r2 + carry) / b;
			n1 /= 10;
			n2 /= 10;
			multiplier *= 10;
		}
		return ans;
	}

	public static int anyBaseSubraction(int b, int n1, int n2) {
		int ans = 0;
		int borrow = 0;
		int multiplier = 1;
		if (n2 > n1) {
			int temp = n2;
			n2 = n1;
			n1 = temp;
		}
		while (n1 > 0 || n2 > 0 || borrow > 0) {
			int d1 = n1 % 10;
			int d2 = n2 % 10;
			int sum = d1 - d2 - borrow;
			if (sum < 0) {
				sum += b;
				borrow = 1;
			} else {
				borrow = 0;
			}
			ans += (sum) * multiplier;
			multiplier *= 10;
			n1 /= 10;
			n2 /= 10;
		}
		return ans;
	}

	public static int anyBaseMultiplication(int b, int n1, int n2) {
		int ans = 0;
		int multiplier = 1;
		int midAns = 0;
		while (n2 > 0) {
			int r = n2 % 10;
			midAns = multiplyWithOneDigit(b, n1, r) * multiplier;
			ans = anyBaseAddition(b, midAns, ans);
			n2 /= 10;
			multiplier *= 10;
		}
		return ans;
	}

	public static int multiplyWithOneDigit(int b, int n1, int n2) {
		int ans = 0;
		int carry = 0;
		int multiplier = 10;
		while (n1 > 0 || carry > 0) {
			int r = n1 % 10;
			int sum = (r * n2) + carry;
			ans += (sum % b) * multiplier;
			carry = sum / b;
			n1 /= 10;
			multiplier *= 10;
		}
		return ans;
	}

	public static int spanOfArray(int[] arr) {
		int length = arr.length;
		int min = arr[0];
		int max = arr[0];
		for (int i = 0; i < length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int span = max - min;
		return span;
	}

	public static int findElementInArray(int[] arr, int d) {
		int index = -1;
		int size = arr.length;
		for (int j = 0; j < size; j++) {
			if (arr[j] == d) {
				index = j;
			}
		}
		return index;
	}

	public static void sumOfTwoArrays(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int len = 1;
		if (len1 >= len2) {
			len += len1;
		} else {
			len += len2;
		}
		int carry = 0;
		int[] ans = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			int sum = 0;
			if (len1 > 0) {
				sum += arr1[--len1];
			}
			if (len2 > 0) {
				sum += arr2[--len2];
			}
			sum += carry;
			if (sum > 9) {
				carry = 1;
				sum -= 10;
			} else {
				carry = 0;
			}
			ans[i] = sum;
		}
		for (int i = 0; i < len; i++) {
			if (i == 0 && ans[i] == 0) {
			} else {
				System.out.println(ans[i]);
			}
		}
	}

	public static void differenceOfTwoArrays(int[] arr1, int[] arr2) {
		int len1 = arr1.length - 1;
		int len2 = arr2.length - 1;
		int size = len2;
		int[] ans = new int[size + 1];

		int borrow = 0;
		for (int i = size; i >= 0; i--) {
			int sum = 0;
			if (len2 >= 0) {
				sum += arr2[len2];
				len2--;
			}
			if (len1 >= 0) {
				sum -= arr1[len1];
				len1--;
			}
			sum -= borrow;
			if (sum < 0) {
				sum += 10;
				borrow = 1;
			} else {
				borrow = 0;
			}
			ans[i] = sum;
		}

		int i = 0;
		while (ans[i] == 0) {
			i++;
		}
		if (i == size) {
			System.out.println(0);
		}
		while (i <= size) {
			System.out.println(ans[i]);
			i++;
		}

	}

	public static void reverseArray(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		// printArray(arr);
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void rotateArray(int[] arr, int k) {
		k = k % arr.length;
		if (k < 0) {
			k += arr.length;
		}
		reverseArray(arr, 0, arr.length - 1);
		reverseArray(arr, 0, k - 1);
		reverseArray(arr, k, arr.length - 1);

		printArray(arr);
	}

	public static void barChartOfArray(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		for (int i = max; i > 0; i--) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] >= i) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

	public static int[] inverseOfArray(int[] arr) {
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ans[arr[i]] = i;
		}
		printArray(ans);
		return ans;
	}

	public static void subArrayProblem(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int k = i; k < len; k++) {
				for (int j = i; j <= k; j++) {
					System.out.print(arr[j] + "\t");
				}
				System.out.println();
			}
		}
	}

	public static void subsetsOfArray(int[] arr) {
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			count *= 2;
		}
		for (int i = 0; i < count; i++) {
			int num = decimalToAnyBase(i, 2);
			int divisor = (int) Math.pow(10, arr.length - 1);
			for (int j = 0; j <= arr.length - 1; j++) {
				if (num / divisor != 0) {
					System.out.print(arr[j] + "\t");
				} else {
					System.out.print("-\t");
				}
				num %= divisor;
				divisor /= 10;
			}
			System.out.println();
		}
	}

	public static void ceilFloor(int[] arr, int d) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == d) {
				System.out.println(arr[mid]);
				return;
			} else if (arr[mid] < d) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(arr[left]);
		System.out.println(arr[right]);
		return;
	}

	public static void firstIndexLastIndex(int[] arr, int d) {
		int left = 0;
		int right = arr.length - 1;
		int firstIndex = -1;
		int lastIndex = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == d) {
				firstIndex = mid;
				right = mid - 1;
			} else if (arr[mid] < d) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		left = 0;
		right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == d) {
				lastIndex = mid;
				left = mid + 1;
			} else if (arr[mid] < d) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(firstIndex);
		System.out.println(lastIndex);
	}

}
