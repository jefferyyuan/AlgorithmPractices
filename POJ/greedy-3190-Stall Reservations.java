import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public class Interval {
		int index;
		int start;
		int end;
		public Interval(int t_index, int t_start, int t_end) {
			index = t_index;
			start = t_start;
			end = t_end;
		}
	}

	public class IntervalComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return ((Interval)o1).start - ((Interval)o2).start;	
		}
	}

	public class Reservation {
		int index;
		int end;
		public Reservation (int t_index, int t_end) {
			index = t_index;
			end = t_end;
		}
	}

	static class PQsort implements Comparator<Reservation> {
		public int compare(Reservation one, Reservation two) {
			return one.end - two.end;
		}
	}

	public void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Interval[] intervals = new Interval[n];
		for (int i = 0; i < n; i++) {
			intervals[i] = new Interval(i, scan.nextInt(), scan.nextInt());
		}
		Arrays.sort(intervals, new IntervalComparator());
		int[] assignment = new int[n];
		PriorityQueue<Reservation> records = new PriorityQueue<Reservation>(1, new PQsort());
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (records.size() == 0 || intervals[i].start <= records.peek().end) {
				count++;
				Reservation temp = new Reservation(count, intervals[i].end);
				records.add(temp);
				assignment[intervals[i].index] = count;
			} else {
				Reservation temp = records.poll();
				temp.end = intervals[i].end;
				records.add(temp);
				assignment[intervals[i].index] = temp.index;
			}
		}
		System.out.println(count);
		for (int i = 0; i < n; i++) {
			System.out.println(assignment[i]);
		}
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}