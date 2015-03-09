import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum = scan.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = i + 1;
		}
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			count[i] = combinationNumber(n - 1, i);
		}
		int result = getResult(input, count);
		while (result != sum) {
			if(!nextPermuation(input)) {
				break;
			}
			result = getResult(input, count);
		}
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			if (i != input.length - 1) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
		scan.close();
	}

	public int getResult(int[] input, int[] count) {
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			result += input[i] * count[i];
		}
		return result;
	}
	public int combinationNumber(int total, int count) {
		if (count == 0 || count == total) {
			return 1;
		} else {
			int result = 1;
			count = Math.min(count, total - count);
			for (int i = 1; i <= count; i++) {
				result *= (total - i + 1);
			}
			for (int i = 1; i <= count; i++) {
				result /= i;
			}
			return result;
		}
	}
	public boolean nextPermuation(int[] input) {
		int index = input.length - 2;
		while (index >= 0 && input[index] > input[index + 1]) {
			index--;
		}
		if (index < 0) {
			return false;
		}
		int swapIndex = input.length - 1;
		while (input[swapIndex] < input[index]) {
			swapIndex--;
		}
		swap(input, index, swapIndex);
		int startIndex = index + 1, endIndex = input.length - 1;
		while (startIndex < endIndex) {
			swap(input, startIndex, endIndex);
			startIndex++;
			endIndex--;
		}
		return true;
	}

	public void swap(int[] input, int index, int swapIndex) {
		int temp = input[swapIndex];
		input[swapIndex] = input[index];
		input[index] = temp;
		return;
	}
	public static void main(String[] args) {
		Main tool = new Main();
		tool.solve();
	}
}