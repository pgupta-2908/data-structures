package ds;

import java.util.Scanner;

public class Patterns {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		p1(n);
		p2(n);
		p3(n);
		p4(n);
		p5(n);
		p6(n);
		p7(n);
		p8(n);
		p9(n);
		p10(n);
//		pHomework1(n);
//		pHomework2(n);
		p11(n);
		p12(n);
		p13(n);
		p14(n);
		p15(n);
		p16(n);
		p17(n);
		p18(n);
		p19(n);
		p20(n);

		scn.close();
	}

	public static void p1(int n) {
		System.out.println("Pattern 1");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	/*
	 * public static void p2(int n) { for (int i = n; i > 0; i--) { for (int j = i;
	 * j > 0; j--) { System.out.print("* "); } System.out.println(); } }
	 */

	public static void p2(int n) {
		System.out.println("Pattern 2");
		int stars = n;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= stars; j++) {
				System.out.print("* ");
			}
			System.out.println();
			stars--;
		}
	}

	public static void p3(int n) {
		System.out.println("Pattern 3");
		int stars = 1;
		int spaces = n - 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("* ");
			}
			System.out.println();
			stars++;
			spaces--;
		}
	}

	public static void p4(int n) {
		System.out.println("Pattern 4");
		int stars = n;
		int spaces = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("* ");
			}
			System.out.println();
			stars--;
			spaces++;
		}
	}

	public static void p5(int n) {
		System.out.println("Pattern 5");
		int stars = 1;
		int spaces = n / 2;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("* ");
			}
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			System.out.println();
			if (i <= n / 2) {
				stars += 2;
				spaces -= 1;
			} else {
				stars -= 2;
				spaces += 1;
			}
		}
	}

	public static void p6(int n) {
		System.out.println("Pattern 6");
		int stars = (n / 2) + 1;
		int spaces = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= stars; j++) {
				System.out.print("* ");
			}
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print("* ");
			}
			System.out.println();
			if (i <= n / 2) {
				stars -= 1;
				spaces += 2;
			} else {
				stars += 1;
				spaces -= 2;
			}
		}
	}

	public static void p7(int n) {
		System.out.println("Pattern 7");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static void p8(int n) {
		System.out.println("Pattern 8");
		int x = n + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i + j == x) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static void p9(int n) {
		System.out.println("Pattern 9");
		int x = n + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || i + j == x) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static void p10(int n) {
		System.out.println("Pattern 10");
		int spaces = n / 2;
		int stars = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= stars; j++) {
				if (j == 1 || j == stars)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			System.out.println();
			if (i <= n / 2) {
				stars += 2;
				spaces -= 1;
			} else {
				stars -= 2;
				spaces += 1;
			}
		}
	}

//	public static void pHomework1(int n) {
//		System.out.println("Pattern Homework 1");
//		int spaces = n / 2;
//		int stars = 1;
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= spaces; j++) {
//				System.out.print("  ");
//			}
//			for (int j = 1; j <= stars; j++) {
//				if (j == 1 || j == stars || j == stars / 2 + 1 || i == n / 2 + 1)
//					System.out.print("* ");
//				else
//					System.out.print("  ");
//			}
//			for (int j = 1; j <= spaces; j++) {
//				System.out.print("  ");
//			}
//			System.out.println();
//			if (i <= n / 2) {
//				stars += 2;
//				spaces -= 1;
//			} else {
//				stars -= 2;
//				spaces += 1;
//			}
//		}
//	}
	
	public static void pHomework1(int n) {
		System.out.println("Pattern Homework 1");
		for(int i=1; i<=n; i++) {
			
		}
	}

	public static void pHomework2(int n) {
		System.out.println("Pattern Homework 2");
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(n * count + j + "\t");
			}
			System.out.println();
			if (i <= n / 2) {
				if (n % 2 == 0 && i == n / 2) {
					count++;
				} else {
					count += 2;
				}
			} else {
				if (n % 2 == 1 && i == n / 2 + 1) {
					count--;
				} else {
					count -= 2;
				}
			}
		}
	}

	public static void p11(int n) {
		System.out.println("Pattern 11");
		int counter = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(counter++ + "\t");
			}
			System.out.println();
		}
	}

	public static void p12(int n) {
		System.out.println("Pattern 12");
		int first = 0;
		int second = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (i == 1) {
					System.out.print(first + "\t");
				} else if (i == 2 && j == 1) {
					System.out.print(second + "\t");
				} else {
					int third = first + second;
					first = second;
					second = third;
					System.out.print(third + "\t");
				}
			}
			System.out.println();
		}
	}

	public static void p13(int n) {
		System.out.println("Pattern 13");
		for (int i = 0; i < n; i++) {
			int val = 1;
			for (int j = 0; j <= i; j++) {
				System.out.print(val + "\t");
				val = (val * (i - j)) / (j + 1);
			}
			System.out.println();
		}
	}

	public static void p14(int n) {
		System.out.println("Pattern 14");
		for (int i = 1; i <= 10; i++) {
			int val = n * i;
			System.out.println(n + " * " + i + " = " + val);
		}
	}

	public static void p15(int n) {
		System.out.println("Pattern 15");
		int spaces = n / 2;
		int nums = 1;
		for (int i = 1; i <= n; i++) {
			int val = i;
			if (i > n / 2 + 1) {
				val = n - i + 1;
			}
			for (int j = 0; j < spaces; j++) {
				System.out.print("\t");
			}
			for (int j = 0; j < nums; j++) {
				System.out.print(val + "\t");
				if (j < nums / 2) {
					val++;
				} else {
					val--;
				}
			}
			for (int j = 0; j < spaces; j++) {
				System.out.print("\t");
			}
			System.out.println();
			if (i <= n / 2) {
				nums += 2;
				spaces -= 1;
			} else {
				nums -= 2;
				spaces += 1;
			}
		}
	}

	/*
	 * public static void p16(int n) { int nums = 1; int spaces = (2 * (n - 1)) - 1;
	 * // 2n - 2 - 1 for (int i = 1; i <= n; i++) { int firstVal = 1; int val =
	 * firstVal; for (int j = 1; j <= nums; j++) { System.out.print(val + "\t"); if
	 * (j < nums) { val++; } } for (int j = 1; j <= spaces; j++) {
	 * System.out.print(" \t"); } for (int j = 1; j <= nums; j++) { if (val != n)
	 * System.out.print(val + "\t"); if (j < nums) { val--; } }
	 * System.out.println(); firstVal++; nums += 1; spaces -= 2; }
	 * 
	 * }
	 */

	public static void p16(int n) {
		System.out.println("Pattern 16");
		int nums = 1;
		int spaces = 2 * (n - 1) - 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nums; j++) {
				System.out.print(j + "\t");
			}
			for (int j = 1; j <= spaces; j++) {
				System.out.print(" " + "\t");
			}
			if (i == n) {
				nums--;
			}
			for (int j = nums; j >= 1; j--) {
				System.out.print(j + "\t");
			}
			System.out.println();
			spaces -= 2;
			nums += 1;
		}
	}

	public static void p17(int n) {
		System.out.println("Pattern 17");
		int stars = 1;
		int spaces = n / 2;
		for (int i = 1; i <= n; i++) {
			if (i <= n / 2 || i > n / 2 + 1) {
				for (int j = 1; j <= n / 2; j++) {
					System.out.print(" \t");
				}
				for (int j = 1; j <= stars; j++) {
					System.out.print("*\t");
				}
				for (int j = 1; j <= spaces; j++) {
					System.out.print(" \t");
				}
			} else {
				for (int j = 1; j <= n; j++) {
					System.out.print("*\t");
				}
			}
			System.out.println();
			if (i <= n / 2) {
				stars++;
				spaces--;
			} else {
				stars--;
				spaces++;
			}
		}
	}

	public static void p18(int n) {
		System.out.println("Pattern 18");
		int stars = n;
		int spaces = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= stars; j++) {
				if (i > 1 && i <= n / 2 && j != 1 && j != stars) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			for (int j = 1; j <= spaces; j++) {
				System.out.print("  ");
			}
			System.out.println();
			if (i <= n / 2) {
				stars -= 2;
				spaces += 1;
			} else {
				stars += 2;
				spaces -= 1;
			}
		}
	}

	public static void p19(int n) {
		System.out.println("Pattern 19");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1) {
					if (j <= n / 2 + 1 || j == n) {
						System.out.print("*\t");
					} else {
						System.out.print(" \t");
					}
				} else if (i <= n / 2) {
					if (j == n / 2 + 1 || j == n) {
						System.out.print("*\t");
					} else {
						System.out.print(" \t");
					}
				} else if (i == n / 2 + 1) {
					System.out.print("*\t");
				} else if (i < n) {
					if (j == 1 || j == n / 2 + 1) {
						System.out.print("*\t");
					} else {
						System.out.print(" \t");
					}
				} else {
					if (j == 1 || j >= n / 2 + 1) {
						System.out.print("*\t");
					} else {
						System.out.print(" \t");
					}
				}
			}
			System.out.println();
		}
	}

	public static void p20(int n) {
		System.out.println("Pattern 20");
		int stars = 1;
		int spaces = n - 2;
		int inSpaces = 1;
		for (int i = 1; i <= n; i++) {
			System.out.print("*\t");

			if (i <= n / 2) {

			}

			System.out.print("*\t");
		}
	}

}
