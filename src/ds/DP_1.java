package ds;

import java.util.Scanner;

public class DP_1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] dp = new int[n + 1];
//		System.out.println(fibonacci(n, dp));
//		System.out.println(fibonacciTab(n));
//		System.out.println(climbStairs(n, dp));
//		System.out.println(climbStairsTab(n));
	}

	public static int climbStairsVariableJump(int n) {
		
	}
	
	public static int climbStairs(int n, int[] dp) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int n1 = climbStairs(n - 1, dp);
		int n2 = climbStairs(n - 2, dp);
		int n3 = climbStairs(n - 3, dp);
		int ans = n1 + n2 + n3;
		dp[n] = ans;
		return ans;
	}

	public static int climbStairsTab(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1];
			if (i - 2 >= 0) {
				dp[i] += dp[i - 2];
			}
			if (i - 3 >= 0) {
				dp[i] += dp[i - 3];
			}
		}
		return dp[n];
	}

	public static int fibonacci(int n, int[] dp) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		int nm1 = fibonacci(n - 1, dp);
		int nm2 = fibonacci(n - 2, dp);
		int ans = nm1 + nm2;
		dp[n] = ans;
		return ans;
	}

	public static int fibonacciTab(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] dp = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i == 0 || i == 1) {
				dp[i] = i;
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		return dp[n];
	}

}
