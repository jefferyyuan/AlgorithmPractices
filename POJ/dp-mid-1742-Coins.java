import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int[] values = new int[1005];
		int[] counts = new int[1005];
		int[] record = new int[100005];
		int n = scan.nextInt();
		int m = scan.nextInt();
		while(n != 0 || m != 0){
			for (int i = 0; i < n; i++) {
				values[i] = scan.nextInt();
			}
			for (int i = 0; i < n; i++) {
				counts[i] = scan.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= m; j++){
					if (i == 0) {
						if (j % values[i] == 0 && j / values[i] <= counts[i]) {
							record[j] = counts[i] - j / values[i];
						} else {
							record[j] = -1;
						}
					} else {
						if (record[j] >= 0) {
							record[j] = counts[i];
						} else if (j < values[i] || record[j - values[i]] < 0) {
							record[j] = -1;
						} else {
							record[j] = record[j - values[i]] - 1;
						}
					}
				}
			}
			int result = 0;
			for (int i = 1; i <= m; i++) {
				if (record[i] >= 0) {
					result++;
				}
			}
			System.out.println(result);
			n = scan.nextInt();
			m = scan.nextInt();
		}
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}