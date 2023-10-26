package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class RecursionWithArrayList {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		String str = br.readLine();
//		int n = Integer.parseInt(br.readLine());
//		int m = Integer.parseInt(br.readLine());

//		System.out.println(getSubsequences(str));
//		System.out.println(getKPC(str));
//		System.out.println(getStairPaths(n));
//		System.out.println(getMazePaths(0, 0, n - 1, m - 1));
//		System.out.println(getMazePathsWithJumps(0, 0, n - 1, m - 1));
	}

	public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		ArrayList<String> ans = new ArrayList<String>();

		for (int jump = 1; jump <= dc - sc || jump <= dr - sr; jump++) {
			if (jump <= dc - sc) {
				ArrayList<String> set1 = getMazePathsWithJumps(sr, sc + jump, dr, dc);
				for (String s : set1) {
					ans.add("h" + jump + s);
				}
			}
			if (jump <= dr - sr) {
				ArrayList<String> set2 = getMazePathsWithJumps(sr + jump, sc, dr, dc);
				for (String s : set2) {
					ans.add("v" + jump + s);
				}
			}
			if (jump <= dc - sc && jump <= dr - sr) {
				ArrayList<String> set3 = getMazePathsWithJumps(sr + jump, sc + 1, dr, dc);
				for (String s : set3) {
					ans.add("d" + jump + s);
				}
			}
		}
		return ans;
	}

	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		ArrayList<String> ans = new ArrayList<String>();

		if (sc < dc) {
			ArrayList<String> set2 = getMazePaths(sr, sc + 1, dr, dc);
			for (String s : set2) {
				ans.add("h" + s);
			}
		}
		if (sr < sc) {
			ArrayList<String> set1 = getMazePaths(sr + 1, sc, dr, dc);
			for (String s : set1) {
				ans.add("v" + s);
			}
		}
		return ans;
	}

	public static ArrayList<String> getStairPaths(int n) {
		if (n <= 0) {
			ArrayList<String> list = new ArrayList<String>();
			if (n == 0) {
				list.add("");
			}
			return list;
		}
		ArrayList<String> ans = new ArrayList<String>();

		ArrayList<String> set1 = getStairPaths(n - 1);
		for (String s : set1) {
			ans.add("1" + s);
		}
		ArrayList<String> set2 = getStairPaths(n - 2);
		for (String s : set2) {
			ans.add("2" + s);
		}
		ArrayList<String> set3 = getStairPaths(n - 3);
		for (String s : set3) {
			ans.add("3" + s);
		}
		return ans;
	}

	static String[] arr = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static ArrayList<String> getKPC(String str) {
		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> sub = getKPC(ros);
		ArrayList<String> ans = new ArrayList<>();

		String code = arr[ch - '0'];
		char[] charArr = code.toCharArray();
		for (char c : charArr) {
			for (String s : sub) {
				ans.add(c + s);
			}
		}

		return ans;
	}

	public static ArrayList<String> getSubsequences(String str) {
		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> sub = getSubsequences(ros);
		ArrayList<String> ans = new ArrayList<>();

		for (String string : sub) {
			ans.add(string);
		}
		for (String string : sub) {
			ans.add(ch + string);
		}
		return ans;
	}
}
