import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int[] leftRange;
	int[] rightRange;
	int[][] posRecord;
	int n;
	char[] resultCharArray;
	public void solve(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		posRecord = new int[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(posRecord[i], -2);
		}
		resultCharArray = new char[2 * n];
		leftRange = new int[n];
		rightRange = new int[n];
		for(int i = 0; i < n; i++){
			leftRange[i] = scan.nextInt();
			if(leftRange[i] % 2 == 0)
				leftRange[i]++;
			rightRange[i] = scan.nextInt();
			if(rightRange[i] % 2 == 0)
				rightRange[i]--;
		}
		boolean result = dfs(0, n - 1);
		if(!result){
			System.out.println("IMPOSSIBLE");
		} else{
			reverse(0, 0, n - 1);
			System.out.println(String.valueOf(resultCharArray));
		}
	}

	public void reverse(int pos, int startNodeIndex, int endNodeIndex){
		if(startNodeIndex > endNodeIndex)
			return;
		int dis = posRecord[startNodeIndex][endNodeIndex];
		resultCharArray[pos] = '(';
		resultCharArray[pos + dis] = ')';
		reverse(pos + 1, startNodeIndex + 1, startNodeIndex + dis / 2);
		reverse(pos + dis + 1, startNodeIndex + dis / 2 + 1, endNodeIndex);
	}
	public boolean dfs(int startNodeIndex, int endNodeIndex){
		if(startNodeIndex > endNodeIndex)
			return true;
		if(posRecord[startNodeIndex][endNodeIndex] == -1)
			return false;
		if(posRecord[startNodeIndex][endNodeIndex] >= 0)
			return true;

		for(int i = startNodeIndex; i <= endNodeIndex; i++){
			int tempStart1 = startNodeIndex + 1;
			int tempEnd1 = i;
			int tempStart2 = i + 1;
			int tempEnd2 = endNodeIndex;
			int dis = 2 * ( tempEnd1 - tempStart1 + 1) + 1;
			if(dis < leftRange[startNodeIndex])
				continue;
			if(dis > rightRange[startNodeIndex])
				break;
			if(dfs(tempStart1, tempEnd1) && dfs(tempStart2, tempEnd2)){
				posRecord[startNodeIndex][endNodeIndex] = dis;
				return true;
			}
		}
		posRecord[startNodeIndex][endNodeIndex] = -1;
		return false;

	}
	public static void main(String[] args){
		Solution tool = new Solution();
		tool.solve();
		return;
	}
}