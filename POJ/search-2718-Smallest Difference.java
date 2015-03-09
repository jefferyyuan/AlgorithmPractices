import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// search practices
// http://poj.org/problem?id=2718

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int testCount = Integer.valueOf(scan.nextLine());
		for (int i = 0; i < testCount; i++) {
			String line = scan.nextLine();
			String[] valueStrings = line.split(" ");
			int[] digits = new int[valueStrings.length];
			for (int j = 0; j < digits.length; j++) {
				digits[j] = Integer.valueOf(valueStrings[j]);
			}
			if (digits.length % 2 == 0) {
				if (digits.length == 2) {
					System.out.println(digits[1] - digits[0]);
				} else {
					int minDiff = Integer.MAX_VALUE;
					for (int start = 0; start < digits.length - 1; start++) {
						if (digits[start] == 0) {
							continue;
						}
						int small = digits[start] ,big = digits[start + 1];
						int count = 0, index = 0;
						while (count < digits.length / 2 - 1) {
							if (index == start || index == start + 1) {
								index++;
							} else {
								count++;
								big = big * 10 + digits[index];
								index++;
							}
						}
						count = 0;
						index = digits.length - 1;
						while (count < digits.length / 2 - 1) {
							if (index == start || index == start + 1) {
								index--;
							} else {
								count++;
								small = small * 10 + digits[index];
								index--;
							}
						}
						minDiff = Math.min(minDiff, big - small);
					}
					System.out.println(minDiff);
				}
			} else {
				int big = 0;
				if(digits[0] == 0) {
					digits[0] = digits[1];
					digits[1] = 0;
				}
				for (int j = 0; j <= digits.length / 2; j++) {
					big = big * 10 + digits[j];
				}

				int small = 0;
				for (int j = digits.length - 1; j > digits.length / 2; j--) {
					small = small * 10 + digits[j];
				}
				System.out.println(big - small);
			}
		}
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}