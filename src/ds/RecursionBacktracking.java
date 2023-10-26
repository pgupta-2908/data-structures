package ds;

import java.util.Scanner;

public class RecursionBacktracking {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
//		int m = scn.nextInt();

//		int[][] arr = new int[n][m];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				arr[i][j] = scn.nextInt();
//			}
//		}

		int[][] arr = new int[n][n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = scn.nextInt();
//		}

		int r = scn.nextInt();
		int c = scn.nextInt();

//		int tar = scn.nextInt();
//		boolean[][] visited = new boolean[n][m];

//		floodfill(arr, 0, 0, "", visited);
//		printTargetSumSubsets(arr, 0, "", 0, tar);
//		printNQueens(arr, "", 0);
		printKnightsTour(arr, r, c, 1);

	}

	public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
		if (upcomingMove > chess.length * chess.length || r >= chess.length || c >= chess.length || r < 0 || c < 0
				|| chess[r][c] != 0) {
			return;
		}
		if (upcomingMove == chess.length * chess.length) {
			chess[r][c] = upcomingMove;
			displayBoard(chess);
			chess[r][c] = 0;
			return;
		}
		chess[r][c] = upcomingMove;
		printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
		printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
		printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
		printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
		printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
		printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
		printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
		printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);
		chess[r][c] = 0;
	}

	public static void displayBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printNQueens(int[][] chess, String qsf, int row) {
		if (row == chess.length) {
			System.out.println(qsf + ".");
			return;
		}

		for (int col = 0; col < chess.length; col++) {
			if (isQueenSafe(chess, row, col)) {
				chess[row][col] = 1;
				printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
				chess[row][col] = 0;
			}

		}

	}

	private static boolean isQueenSafe(int[][] chess, int row, int col) {
		// vertical check
		for (int i = row; i >= 0; i--) {
			if (chess[i][col] != 0) {
				return false;
			}
		}
		// horizontal check not needed as queen is placed in new row
		/*
		 * for (int i = col - 1; i >= 0; i--) { if (chess[row][i] != 0) { return false;
		 * } }
		 */
		// diagonal 1 check \
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] != 0) {
				return false;
			}
		}
		// diagonal 2 check /
		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
		if (sos > tar) {
			return;
		}
		if (idx == arr.length) {
			if (sos == tar) {
				System.out.println(set + ".");
			}
			return;
		}
		printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
		printTargetSumSubsets(arr, idx + 1, set, sos, tar);
	}

	public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] visited) {
		if (sr >= maze.length || sc >= maze[0].length || sr < 0 || sc < 0 || maze[sr][sc] == 1
				|| visited[sr][sc] == true) {
			return;
		}
		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			System.out.println(asf);
			return;
		}
		visited[sr][sc] = true;
		floodfill(maze, sr - 1, sc, asf + "t", visited);
		floodfill(maze, sr, sc - 1, asf + "l", visited);
		floodfill(maze, sr + 1, sc, asf + "d", visited);
		floodfill(maze, sr, sc + 1, asf + "r", visited);
		visited[sr][sc] = false;
	}

}
