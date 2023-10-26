package ds;

import java.util.Scanner;

public class ClassTest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		diagonalAndWaveTraversal(arr);
		scn.close();
	}

	public static void diagonalAndWaveTraversal(int[][] arr) {
		int count = arr.length * arr.length;
		int row = arr.length - 1;
		int col = 0;
		int current = 0;
		while (current < count) {
			if (arr.length % 2 == 0) {
				if (row == arr.length & col == arr.length) {
					col--;
				}
				if (row == 0 & col == 0) {
					col++;
				}
			} else {

			}

			if (row == arr.length & col == arr.length) {
				if (arr.length % 2 == 0)
					col--;
			}
			if (row == 0 & col == 0) {
				if (arr.length % 2 != 0)
					col++;
			}
			// going down
			while (current < count && row < arr.length && col < arr.length) {
				System.out.print(arr[row][col] + "\t");
				row++;
				col++;
				current++;
			}
			if (row >= arr.length)
				row--;
			if (col >= arr.length)
				col--;
			// going up
			while (current < count && row >= 0 && col >= 0) {
				System.out.print(arr[row][col] + "\t");
				row--;
				col--;
				current++;
			}
			if (row < 0)
				row++;
			if (col < 0)
				col++;
		}
	}

}

public class Navel {
	private int size = 7;
	private static int length = 3;

	public static void main(String[] args) {
		new Navel().go();
	}

	void go() {
		int size = 5;
		System.out.println("hello");
//		System.out.println(new Gazer().adder());
	}

//	class Gazer {
//		int adder() {
//			return size * length;
//		}
//	}
}
