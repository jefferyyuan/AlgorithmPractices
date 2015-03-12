import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	static class PQsort implements Comparator<Double> {
 
		public int compare(Double one, Double two) {
			if (two > one) {
				return 1;
			} else if (two == one) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	public void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		PriorityQueue<Double> heap = new PriorityQueue<Double>(n, new PQsort());
		for (int i = 0; i < n; i++) {
			heap.add(scan.nextDouble());
		}
		while (heap.size() > 1) {
			double v1 = heap.poll();
			double v2 = heap.poll();
			heap.add(2 * Math.sqrt(v1 * v2));
		}
		DecimalFormat myFormat = new DecimalFormat("#0.000");
		System.out.println(myFormat.format(heap.poll()));
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}