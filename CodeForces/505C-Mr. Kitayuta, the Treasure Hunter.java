import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//	change the stack size from default to 64M(same as CodeForces)
//	or there will stackoverflow error
public class Solution{
	int islandsCount = 30001;
	int minD, maxD;
	int d;
	int[][] record;
	int[] gems = new int[islandsCount];
	int maxGem = -1;

	public void solve(){
		Arrays.fill(gems, 0);
		Scanner scan = new Scanner(System.in);
		int gemCount = scan.nextInt();
		d = scan.nextInt();
		for(int i = 0; i < gemCount; i++){
			int index = scan.nextInt();
			gems[index] ++;
			maxGem = Math.max(maxGem, index);
		}
		this.calcDistance();
		record = new int[islandsCount][maxD - minD + 1];
		for(int i = 0; i < islandsCount; i ++)
			Arrays.fill(record[i], -1);

		int result = gems[0];
		result += dp(d, d);
		System.out.println(result);
		scan.close();
		return;
	}

	public int dp(int pos, int d){
		if(pos > maxGem)
			return 0;
		if(record[pos][d - minD] >= 0)
			return record[pos][d - minD];
		int result = 0;
		for(int newD = Math.max(1, d - 1); newD <= d + 1; newD ++){
			result = Math.max(result, dp(pos + newD, newD));
		}
		result += gems[pos];
		record[pos][d - minD] = result;
		return result;
	}
	public void calcDistance(){
		int pos = d;
		minD = d;
		while(pos < islandsCount){
			minD = Math.max(minD - 1, 1);
			pos += minD;
		}
		pos = d;
		maxD = d;
		while(pos < islandsCount){
			maxD ++;
			pos += maxD;
		}
	}
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
		return;
	}
}