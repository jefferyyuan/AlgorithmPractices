import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public class Interval {
		int start;
		int end;
		int efficiency;
		public Interval (int v1, int v2, int v3) {
			start = v1;
			end = v2;
			efficiency = v3;
		}
	}

	public class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval v1, Interval v2){
			return v1.start - v2.start;
		}
	}

	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int R = scan.nextInt();
		Interval[] input = new Interval[M];
		for (int i = 0; i < M; i++) {
			input[i] = new Interval(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		Arrays.sort(input, new IntervalComparator());
		int[] record = new int[M + 1];
		record[M] = 0;
		for (int i = M - 1; i >= 0; i--) {
			int nextStart = input[i].end + R;
			int nextStartIndex = findIndex(input, nextStart);
			record[i] = Math.max(record[i + 1], input[i].efficiency + record[nextStartIndex]);
		}
		System.out.println(record[0]);
		scan.close();
	}

	public int findIndex(Interval[] input, int value) {
		return findIndex(input, 0, input.length - 1, value);
	}

	public int findIndex(Interval[] input, int start, int end, int value) {
		int mid = (start + end) / 2;
		if (input[mid].start < value && ((mid == input.length - 1) || (input[mid + 1].start >= value))) {
			return mid + 1;
		} else if (input[mid].start < value) {
			return findIndex(input, mid + 1, end, value);
		} else {
			return findIndex(input, start , mid - 1, value);
		}
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}