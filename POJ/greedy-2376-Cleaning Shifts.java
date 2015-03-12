import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	private class Interval {
		int start;
		int end;
	}

	public class IntervalComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return ((Interval)o1).start - ((Interval)o2).start;	
		}
	}

	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(), T = scan.nextInt();
		Interval[] records = new Interval[N];
		for (int i = 0; i < N; i++) {
			Interval tempInterval = new Interval();
			tempInterval.start = scan.nextInt();
			tempInterval.end = scan.nextInt();
			records[i] = tempInterval;
		}
		Arrays.sort(records, new IntervalComparator());
		int count = 0;
		int preEnd = 0;
		int index = 0;
		while (index < records.length && preEnd < T) {
			int curEnd = preEnd;
			while (index < records.length && records[index].start <= preEnd + 1) {
				curEnd = Math.max(curEnd, records[index].end);
				index++;
			}
			count++;
			if (curEnd == preEnd) {
				break;
			}
			preEnd = curEnd;
		}
		if (preEnd >= T) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}		
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}