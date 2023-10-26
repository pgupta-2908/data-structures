package ds;

import java.util.Scanner;

public class TwoDArrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		/*
		 * int n = scn.nextInt(); int m = scn.nextInt(); int[][] arr = new int[n][m];
		 * for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) { arr[i][j] =
		 * scn.nextInt(); } }
		 */

		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
//		/int d = scn.nextInt();

		/*
		 * int n1 = scn.nextInt(); int m1 = scn.nextInt(); int[][] arr1 = new
		 * int[n1][m1]; for (int i = 0; i < n1; i++) { for (int j = 0; j < m1; j++) {
		 * arr1[i][j] = scn.nextInt(); } }
		 * 
		 * int n2 = scn.nextInt(); int m2 = scn.nextInt(); int[][] arr2 = new
		 * int[n2][m2]; for (int i = 0; i < n2; i++) { for (int j = 0; j < m2; j++) {
		 * arr2[i][j] = scn.nextInt(); } }
		 */

		scn.close();

		// twoDArrayDemo(arr);
		// matrixMultiplication(arr1, arr2);
		// wakanda1(arr);
		// spiralDisplay(arr);
		// ringRotate(arr, s, r);
		exitPointOfMatrix(arr);
		// rotateBy90Degree(arr);
		// wakanda2(arr);
		// saddlePrice(arr);
		// searchInASorted2DArray(arr, d);

	}

	public static void twoDArrayDemo(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void matrixMultiplication(int arr1[][], int arr2[][]) {
		int n1 = arr1.length;
		int m1 = arr1[0].length;
		int n2 = arr2.length;
		int m2 = arr2[0].length;
		if (m1 != n2) {
			System.out.println("Invalid input");
		} else {
			int arr[][] = new int[n1][m2];
			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < m2; j++) {
					int sum = 0;
					for (int k = 0; k < m1; k++) {
						sum += arr1[i][k] * arr2[k][j];
					}
					arr[i][j] = sum;
				}
			}

			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < m2; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void wakanda1(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		for (int i = 0; i < m; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < n; j++) {
					System.out.println(arr[j][i]);
				}
			} else {
				for (int j = n - 1; j >= 0; j--) {
					System.out.println(arr[j][i]);
				}
			}
		}
	}

	public static void spiralDisplay(int[][] arr) {
		int firstrow = 0;
		int lastrow = arr.length - 1;
		int firstcol = 0;
		int lastcol = arr[0].length - 1;

		int total = arr.length * arr[0].length;
		int count = 1;
		while (count <= total) {
			for (int i = firstrow; i <= lastrow && count <= total; i++) {
				System.out.println(arr[i][firstcol]);
				count++;
			}
			firstcol++;
			for (int j = firstcol; j <= lastcol && count <= total; j++) {
				System.out.println(arr[lastrow][j]);
				count++;
			}
			lastrow--;
			for (int i = lastrow; i >= firstrow && count <= total; i--) {
				System.out.println(arr[i][lastcol]);
				count++;
			}
			lastcol--;
			for (int j = lastcol; j >= firstcol && count <= total; j--) {
				System.out.println(arr[firstrow][j]);
				count++;
			}
			firstrow++;
		}
	}

	public static void ringRotate(int[][] arr, int s, int r) {

		int sub[] = fill1DArrayFrom2DArray(arr, s, r);
		rotateArray(sub, r);
		fill2DArrayFrom1DArray(arr, sub, s);
		twoDArrayDemo(arr);

	}

	public static int[] fill1DArrayFrom2DArray(int[][] arr, int s, int r) {
		int rmin = s - 1;
		int cmin = s - 1;
		int rmax = arr.length - s;
		int cmax = arr[0].length - s;

		int sub[] = new int[2 * (rmax - rmin + cmax - cmin)];
		int size = sub.length;
		int count = 0;
		while (count < size) {
			for (int i = rmin; i <= rmax && count < size; i++) {
				sub[count] = arr[i][cmin];
				count++;
			}
			cmin++;
			for (int j = cmin; j <= cmax && count < size; j++) {
				sub[count] = arr[rmax][j];
				count++;
			}
			rmax--;
			for (int i = rmax; i >= rmin && count < size; i--) {
				sub[count] = arr[i][cmax];
				count++;
			}
			cmax--;
			for (int j = cmax; j >= cmin && count < size; j--) {
				sub[count] = arr[rmin][j];
				count++;
			}
			rmin++;
		}
		return sub;
	}

	public static void rotateArray(int[] arr, int r) {
		r %= arr.length;
		if (r < 0) {
			r += arr.length;
		}
		reverseArray(arr, 0, arr.length - 1);
		reverseArray(arr, 0, r - 1);
		reverseArray(arr, r, arr.length - 1);
	}

	public static void reverseArray(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	public static void fill2DArrayFrom1DArray(int[][] arr, int[] sub, int s) {
		int rmin = s - 1;
		int cmin = s - 1;
		int rmax = arr.length - s;
		int cmax = arr[0].length - s;

		int size = sub.length;
		int count = 0;

		while (count < size) {
			for (int i = rmin; i <= rmax && count < size; i++) {
				arr[i][cmin] = sub[count];
				count++;
			}
			cmin++;
			for (int j = cmin; j <= cmax && count < size; j++) {
				arr[rmax][j] = sub[count];
				count++;
			}
			rmax--;
			for (int i = rmax; i >= rmin && count < size; i--) {
				arr[i][cmax] = sub[count];
				count++;
			}
			cmax--;
			for (int j = cmax; j >= cmin && count < size; j--) {
				arr[rmin][j] = sub[count];
				count++;
			}
			rmin++;
		}
	}

	public static void exitPointOfMatrix(int[][] arr) {
		int row = 0;
		int col = 0;

		int rowmin = 0;
		int rowmax = arr.length - 1;
		int colmin = 0;
		int colmax = arr[0].length - 1;

		int rotate = 0;

		while (row >= rowmin && row <= rowmax && col >= colmin && col <= colmax) {
			rotate %= 4;
			if (rotate == 0) {
				col++;

				while (col <= colmax && arr[row][col] == 0) {
					col++;
				}
				if (col > colmax) {
					System.out.println(row + " " + (col - 1));
					return;
				}
			} else if (rotate == 1) {
				row++;
				while (row <= rowmax && arr[row][col] == 0) {
					row++;
				}
				if (row > rowmax) {
					System.out.println(row - 1 + " " + col);
					return;
				}
			} else if (rotate == 2) {
				col--;
				while (col >= colmin && arr[row][col] == 0) {
					col--;
				}
				if (col < colmin) {
					System.out.println(row + " " + (col + 1));
					return;
				}
			} else if (rotate == 3) {
				row--;
				while (row <= rowmin && arr[row][col] == 0) {
					row--;
				}
				if (row < rowmin) {
					System.out.println(row + 1 + " " + col);
					return;
				}
			}
			if (arr[row][col] == 1)
				rotate++;
		}

	}

	public static void rotateBy90Degree(int[][] arr) {
		transposeArray(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length - j - 1];
				arr[i][arr[0].length - j - 1] = temp;
			}
		}
		twoDArrayDemo(arr);
	}

	public static void transposeArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

	public static void wakanda2(int[][] arr) {
		int rmax = arr.length - 1;
		int cmax = arr[0].length - 1;

		for (int diagonals = rmax; diagonals > 0; diagonals--) {
			int col = 0;
			int row = diagonals;
			while (row <= rmax && col <= cmax) {
				System.out.print(arr[row][col] + ", ");
				row++;
				col++;
			}
		}

		for (int diagonals = 0; diagonals <= rmax; diagonals++) {
			int row = 0;
			int col = diagonals;
			while (row <= rmax && col <= cmax) {
				System.out.print(arr[row][col] + ", ");
				row++;
				col++;
			}
		}
	}

	public static void saddlePrice(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;

		for (int i = 0; i < n; i++) {
			int min = arr[i][0];
			int col = 0;

			// find minimum in the row
			for (int j = 0; j < n; j++) {
				if (arr[i][j] < min) {
					min = arr[i][j];
					col = j;
				}
			}

			// check if that minimum is maximum in the column
			boolean ans = true;
			for (int k = 0; k < n; k++) {
				if (arr[k][col] > min) {
					ans = false;
					break;
				}
			}
			if (ans == true) {
				System.out.println(min);
				return;
			}
		}
		System.out.println("Invalid input");
	}

	public static void searchInASorted2DArray(int[][] arr, int d) {
		int n = arr.length;
		int m = arr[0].length;
		int row = n - 1;
		int col = 0;
		while (row >= 0 && col < m) {
			if (arr[row][col] < d) {
				col++;
			} else if (arr[row][col] > d) {
				row--;
			} else {
				System.out.println(row);
				System.out.println(col);
				return;
			}
		}
		System.out.println("Not Found");
	}

}
