import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	int[][][] record = new int[2][1005][35];
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int W = scan.nextInt();
		int[] position = new int[T];
		for (int i = 0; i < T; i++) {
			position[i] = scan.nextInt() - 1;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j <= W; j++) {
				if (position[T - 1] == i) {
					record[i][T - 1][j] = 1;
				}
				else {
					record[i][T - 1][j] = 0;
				}
			}
		}
		for (int i = T - 2; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k <= W; k++) {
					int result = 0;
					if (position[i] == j){
						result++;
					}
					if (k == 0){
						result += record[j][i + 1][k];
					} else {
						result += Math.max(record[j][i + 1][k], record[(j + 1) % 2][i + 1][k - 1]);
					}
					record[j][i][k] = result;
				}
			}
		}
		System.out.println(Math.max(record[0][0][W], record[1][0][W]));
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}