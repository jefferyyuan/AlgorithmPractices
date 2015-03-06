import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int[] record = new int[10000005];
	public void init() {
		Arrays.fill(record, 0);
		for (int i = 2; i <= 10000000; i++) {
			if (record[i] > 0) {
				continue;
			}
			for(int j = i; j <= 10000000; j += i){
				record[j]++;
			}
		}
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		for (int i = 0; i < count; i++) {
			int startIndex = scan.nextInt();
			int endIndex = scan.nextInt();
			int k = scan.nextInt();
			int result = 0;
			for (int j = startIndex; j <= endIndex; j++) {
				if (record[j] == k) {
					result++;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + result);
		}
		scan.close();
	}

	public void solve(){
		
	}
	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
	}
}