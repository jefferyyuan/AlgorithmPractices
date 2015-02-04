import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int[] candleRecord = new int[305];
	HashSet<Integer> lightRecord = new HashSet<Integer>();
	int t, m, r;

	public Solution(){
		Arrays.fill(candleRecord, 0);
	}

	public void solve(){
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		t = scan.nextInt();
		r = scan.nextInt();
		int candleResult = 0;
		boolean isPossible = true;
		for(int i = 0; i < m; i++){
			if(!isPossible)
				break;
			int time = scan.nextInt();
			int startIndex = time - 1;
			while(candleRecord[time] < r){
				if(startIndex + 1 + t - 1 < time){
					candleResult = -1;
					isPossible = false;
					break;
				} else if(lightRecord.contains(startIndex)){
					startIndex--;
				} else{
					candleResult++;
					lightRecord.add(startIndex);
					for(int j = Math.max(0, startIndex + 1); j <= Math.min(candleRecord.length - 1, startIndex + t); j++){
						candleRecord[j]++;
					}
					startIndex--;
				}
			}
		}
		System.out.println(candleResult);
		scan.close();
		return;
	}
	public static void main(String[] args){
		Solution tool = new Solution();
		tool.solve();
		return;
	}
}