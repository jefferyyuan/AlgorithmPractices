import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	static class MySort implements Comparator<DataNode> {
 
		public int compare(DataNode one, DataNode two) {
			return one.time * two.damage - one.damage * two.time;
		}
	}
	public class DataNode {
		int time;
		int damage;
		public DataNode(int t_time, int t_damage) {
			damage = t_damage;
			time = t_time;
		}
	}
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		DataNode[] cows = new DataNode[n];
		for (int i = 0; i < n; i++) {
			int t = scan.nextInt();
			int d = scan.nextInt();
			cows[i] = new DataNode(t, d);
		}
		Arrays.sort(cows, new MySort());
		long result = 0;
		int time = 0;
		for (int i = 0; i < n; i++) {
			result += (long)(time * cows[i].damage);
			time += 2 * cows[i].time;
		}
		System.out.println(result);
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}