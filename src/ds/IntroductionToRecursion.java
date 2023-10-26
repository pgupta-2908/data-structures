package ds;

import java.util.Scanner;

public class IntroductionToRecursion {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

//		int x = scn.nextInt();
//		int n = scn.nextInt();

//		int t1id = scn.nextInt();
//		int t2id = scn.nextInt();
//		int t3id = scn.nextInt();

//		towerOfHanoi(n, t1id, t2id, t3id);
//		System.out.println(powerLogarithmic(x, n));
	}

	public static void towerOfHanoi(int n, int t1id, int t2id, int t3id) {
		if (n == 0)
			return;

		towerOfHanoi(n - 1, t1id, t3id, t2id);
		System.out.println(n + "[" + t1id + " -> " + t2id + "]");
		towerOfHanoi(n - 1, t3id, t2id, t1id);
		return;
	}

	public static int powerLogarithmic(int x, int n) {
		if (n == 1) {
			return x;
		}
		int nBy2 = powerLogarithmic(x, n / 2);
		int ans = nBy2 * nBy2;
		if (n % 2 != 0) {
			ans *= x;
		}
		return ans;
	}

}
