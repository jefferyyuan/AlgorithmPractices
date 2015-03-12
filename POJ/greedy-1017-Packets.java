import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int[] record = new int[6];
		while(true) {
			boolean isValid = false;
			for (int i = 0; i < record.length; i++) {
				record[i] = scan.nextInt();
				if (record[i] != 0) {
					isValid = true;
				}
			}
			if (!isValid) {
				break;
			}
			int result = 0;
			result += record[5];

			result += record[4];
			int useOne = Math.min(11 * record[4], record[0]);
			record[0] -= useOne;

			result += record[3];
			int useTwo = Math.min(5 * record[3], record[1]);
			record[1] -= useTwo;
			useOne = (5 * record[3] - useTwo) * 4;
			useOne = Math.min(useOne, record[0]);
			record[0] -= useOne;

			result += (record[2] + 3) / 4;
			if (record[2] % 4 == 1) {
				useTwo = 5;
			} else if (record[2] % 4 == 2) {
				useTwo = 3;
			} else if (record[2] % 4 == 3) {
				useTwo = 1;
			} else {
				useTwo = 0;
			}
			useTwo = Math.min(useTwo, record[1]);
			record[1] -= useTwo;
			useOne = ((record[2] + 3) / 4) * 36  - record[2] * 9 - useTwo * 4;
			useOne = Math.min(useOne, record[0]);
			record[0] -= useOne;

			result += (record[1] + 8) / 9;
			record[0] -= Math.min(record[0],((record[1] + 8) / 9) * 36 - record[1] * 4);

			result += (record[0] + 35) / 36;
			System.out.println(result);
		}
		scan.close();
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}