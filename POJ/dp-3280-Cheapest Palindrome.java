import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		String inputString = scan.next();
		char[] inputChars = inputString.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int[][] record = new int[M][M];
		for (int i = 0; i < N; i++) {
			char c = scan.next().charAt(0);
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			map.put(c, Math.min(v1, v2));
		}
		for (int length = 0; length < M; length++) {
			for (int i = 0; i + length < M; i++) {
				if (length == 0) {
					record[i][i + length] = 0;
				} else if (length == 1) {
					if (inputChars[i] == inputChars[i + length]) {
						record[i][i + length] = 0;
					} else {
						record[i][i + length] = Math.min(map.get(inputChars[i]), map.get(inputChars[i + length]));
					}
				} else {
					if (inputChars[i] == inputChars[i + length]) {
						record[i][i + length] = record[i + 1][i + length - 1];
					} else {
						record[i][i + length] = Math.min(record[i + 1][i + length] + map.get(inputChars[i]), record[i][i + length - 1] + map.get(inputChars[i + length]));
					}
				}
			}
		}
		System.out.println(record[0][M - 1]);
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}