package ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringStringBuilderAndArrayList {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

//		String str = scn.nextLine();
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(scn.nextInt());
		}

//		removePrimesOfficial(al);
//		printAllPPermutationsOfString(str);
//		printAllPalindromicSubstrings(str);
//		cpss(str);
//		System.out.println(compression2(str));

		scn.close();

	}

	public static void removePrimesOfficial(ArrayList<Integer> al) {
		// write your code here
		for (int i = 0; i < al.size();) {
			if (checkPrime(al.get(i)))
				al.remove(i);
			else
				i++;
		}
		System.out.println(al);
	}

	public static boolean checkPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void printAllPPermutationsOfString(String str) {
		int len = str.length();
		int total = 1;
		for (int i = 2; i <= len; i++) {
			total *= i;
		}

		for (int i = 0; i < total; i++) {
			int dividend = i;
			int divisor = str.length();
			StringBuilder sb = new StringBuilder(str);
			while (divisor > 0) {
				int quo = dividend / divisor;
				int rem = dividend % divisor;
				System.out.print(sb.charAt(rem));
				sb.deleteCharAt(rem);
				dividend = quo;
				divisor--;
			}
			System.out.println();
		}

	}

	public static void printAllPalindromicSubstrings(String str) {
		int len = str.length();
		for (int si = 0; si < len; si++) {
			for (int ei = si; ei < len; ei++) {
				if (checkPallindrome(str, si, ei) == true) {
					System.out.println(str.substring(si, ei + 1));
				}
			}
		}
	}

	public static boolean checkPallindrome(String str, int si, int ei) {
		while (si < ei) {
			if (str.charAt(si) != str.charAt(ei)) {
				return false;
			} else {
				si++;
				ei--;
			}
		}
		return true;
	}

	public static int cpss(String str) {
		int len = str.length();
		int count = len;
		for (int index = 0; index < len; index++) {
			int left = index;
			int right = index + 1;
			while (left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
				count++;
				left--;
				right++;
			}

			left = index - 1;
			right = index + 1;
			while (left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
				count++;
				left--;
				right++;
			}
		}
		return count;
	}

	public static String compression1(String str) {
		// write your code here
		int len = str.length();
		String ans = "";
		ans += str.charAt(0);
		for (int idx = 0; idx < len - 1; idx++) {
			if (ans.charAt(ans.length() - 1) != str.charAt(idx + 1)) {
				ans += str.charAt(idx + 1);
			}
		}
		return ans;
	}

	public static String compression2(String str) {
		// write your code here
		int len = str.length();
		String ans = "";
		for (int idx = 0; idx < len; idx++) {
			ans += str.charAt(idx);
			int count = 1;
			while (idx < len - 1 && str.charAt(idx) == str.charAt(idx + 1)) {
				count++;
				idx++;
			}
			if (count > 1) {
				ans += count;
			}
		}
		return ans;
	}

}
