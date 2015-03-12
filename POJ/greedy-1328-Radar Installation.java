import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

	public class Main {
		private class Interval {
			double start;
			double end;
			public Interval(double x, double y, double r) {
				start = x - Math.sqrt(r * r - y * y);
				end = x + Math.sqrt(r * r - y * y);
			}
		}

		public class IntervalComparator implements Comparator {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				if (((Interval)o1).end < ((Interval)o2).end) {
					return -1;
				} else if (((Interval)o1).end == ((Interval)o2).end) {
					return 0;
				} else {
					return 1;
				}
			}
		}

		@SuppressWarnings("unchecked")
		public void solve() {
			Scanner scan = new Scanner(System.in);
			int N = scan.nextInt(), r = scan.nextInt();
			int caseCount = 1;
			while(N != 0 || r != 0) {
				Interval[] records = new Interval[N];
				boolean isValid = true;
				if (r <= 0) {
					isValid = false;
				}
				for (int i = 0; i < N; i++) {

					double x = (double)scan.nextInt();
					double y = (double)scan.nextInt();
					if (y > r) {
						isValid = false;
					}
					if (isValid) {
						records[i] = new Interval(x, y, (double)r);
					}
				}
				if (isValid) {
					Arrays.sort(records, new IntervalComparator());
					int count = 0;
					double preEnd = Integer.MIN_VALUE;
					for (int i = 0; i < N; i++) {
						if (records[i].start <= preEnd) {
							continue;
						} else {
							count++;
							preEnd = records[i].end;
						}
					}
					System.out.println("Case " + caseCount + ": " + count);
				} else {
					System.out.println("Case " + caseCount + ": " + (-1));
				}
				N = scan.nextInt();
				r = scan.nextInt();
				caseCount++;
			}


			scan.close();
		}
		public static void main(String[] args) {
			Main tool = new Main();
			tool.solve();
		}
	}