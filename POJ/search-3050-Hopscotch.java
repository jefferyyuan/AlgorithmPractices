import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int[][] input = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				input[i][j] = scan.nextInt();
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				search(i, j, input, 6, 0);
			}
		}
		System.out.println(record.size());
		scan.close();
	}

	HashSet<Integer> record = new HashSet<Integer>();

	public void search(int x, int y, int[][] input, int count, int value) {
		if (x < 0 || x >= 5 || y < 0 || y >= 5) {
			return;
		}
		value = value * 10 + input[x][y];
		count--;
		if (count == 0) {
			record.add(value);
		} else {
			search(x - 1, y, input, count, value);
			search(x + 1, y, input, count, value);
			search(x, y - 1, input, count, value);
			search(x, y + 1, input, count, value);
		}
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}