import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int S = scan.nextInt();
		int minCost = Integer.MAX_VALUE - S - 100;
		long result = 0;
		for (int i = 0; i < N; i++) {
			int tempCost = scan.nextInt();
			minCost = Math.min(tempCost, minCost + S);
			int tempNeed = scan.nextInt();
			result += (long)(tempNeed * minCost);
		}
		System.out.println(result);
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}