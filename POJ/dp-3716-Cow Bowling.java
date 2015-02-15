import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] record = new int[2][n + 1];
		Arrays.fill(record[0], Integer.MIN_VALUE);
		Arrays.fill(record[1], Integer.MIN_VALUE);
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= i + 1; j++) {
				int value = scan.nextInt();
				if (i == 0) {
					record[0][j] = value;
				} else {
					record[0][j] = Math.max(record[1][j - 1], record[1][j]) + value;
				}
			}
			int[] tempArray = record[0];
			record[0] = record[1];
			record[1] = tempArray;
		}
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, record[1][i]);
		}
		System.out.println(result);
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}