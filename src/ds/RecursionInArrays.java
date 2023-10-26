package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursionInArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int x = Integer.parseInt(br.readLine());

		display(allIndices(arr, x, 0, 0));

	}

	public static int[] allIndices(int[] arr, int x, int index, int fsf) {
		if (index == arr.length) {
			int[] myans = new int[fsf];
			return myans;
		}

		if (arr[index] == x) {
			fsf++;
		}
		int[] ans = allIndices(arr, x, index + 1, fsf);

		if (arr[index] == x) {
			ans[fsf - 1] = index;
		}
		return ans;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
