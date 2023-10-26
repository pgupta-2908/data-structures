package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionOnTheWayUp {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int m = Integer.parseInt(br.readLine());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

//		printSS(str, "");
//		printKPC(str, "");
//		printStairPaths(n, "");
//		printMazePaths(0, 0, n - 1, m - 1, "");
//		printMazePathsWithJump(0, 0, n - 1, m - 1, "");
//		printEncodings(str, "");
		printPermutations(str, "");

	}

	public static void printPermutations(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1, str.length());
			printPermutations(ros, asf + ch);
		}
	}

	public static void printEncodings(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}
		if (str.charAt(0) == '0') {
			return;
		}

		int x = str.charAt(0) - '0';
		char ch1 = (char) ('a' - 1 + x);
		String ros1 = str.substring(1);
		printEncodings(ros1, asf + ch1);

		if (str.length() >= 2) {

			int y = Integer.parseInt(str.substring(0, 2));
			if (y <= 26) {
				char ch2 = (char) ('a' - 1 + y);
				String ros2 = str.substring(2);
				printEncodings(ros2, asf + ch2);
			}
		}
	}

	public static void printMazePathsWithJump(int sr, int sc, int dr, int dc, String psf) {
		if (sr > dr || sc > dc) {
			return;
		}
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}

		for (int jump = 1; jump <= dc - sc; jump++) {
			printMazePathsWithJump(sr, sc + jump, dr, dc, psf + "h" + jump);
		}
		for (int jump = 1; jump <= dr - sr; jump++) {
			printMazePathsWithJump(sr + jump, sc, dr, dc, psf + "v" + jump);
		}
		for (int jump = 1; jump <= dr - sr && jump <= dc - sc; jump++) {
			printMazePathsWithJump(sr + jump, sc + jump, dr, dc, psf + "d" + jump);
		}
	}

	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		if (sc == dc && sr == dr) {
			System.out.println(psf);
			return;
		}
		if (sc < dc) {
			printMazePaths(sr, sc + 1, dr, dc, psf + "h");
		}
		if (sr < dr) {
			printMazePaths(sr + 1, sc, dr, dc, psf + "v");
		}

	}

	public static void printStairPaths(int n, String path) {
		if (n == 0) {
			System.out.println(path);
			return;
		}
		if (n >= 1) {
			printStairPaths(n - 1, path + '1');
		}
		if (n >= 2) {
			printStairPaths(n - 2, path + '2');
		}
		if (n >= 3) {
			printStairPaths(n - 3, path + '3');
		}
	}

	static String[] arr = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static void printKPC(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}
		int ch = str.charAt(0) - '0';
		String val = arr[ch];
		String ros = str.substring(1);
		for (char c : val.toCharArray()) {
			printKPC(ros, asf + c);
		}
	}

	public static void printSS(String str, String asf) {
		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		printSS(ros, asf + ch);
		printSS(ros, asf);
	}

}
