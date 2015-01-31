// dfs solution : time limit exceeded
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int[] record;
	int[] leftRange;
	int[] rightRange;
	int[] startIndex;
	int n;

	public void solve(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		record = new int[2 * n];
		Arrays.fill(record, -1);
		startIndex = new int[n];
		for(int i = 0; i < startIndex.length; i++){
			startIndex[i] = i;
		}
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
		boolean result = dfs(0, n - 1, 0, 2 * n - 1);
		if(!result){
			System.out.println("IMPOSSIBLE");
		} else{
			StringBuffer resultBuffer = new StringBuffer();
			for(int i = 0; i < record.length; i++){
				if(record[i] == 0) 
					resultBuffer.append('(');
				else
					resultBuffer.append(')');
			}
			System.out.println(resultBuffer.toString());
		}
	}

	public boolean dfs(int nodeStartIndex, int nodeEndIndex, int posStartIndex, int posEndIndex){
		if(nodeStartIndex > nodeEndIndex)
			return true;
		//if(record[posStartIndex] != -1)
		//	return false;
		record[posStartIndex] = 0;
		for(int i = posStartIndex + leftRange[nodeStartIndex]; i <= posStartIndex + rightRange[nodeStartIndex]; i++){
			if(i > posEndIndex)
				break;
			record[i] = 1;
			if(dfs(nodeStartIndex + 1, nodeStartIndex + (i - posStartIndex) / 2, posStartIndex + 1, i - 1)
				&& dfs(nodeStartIndex + (i - posStartIndex) / 2 + 1, nodeEndIndex, i + 1, posEndIndex)){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		Solution tool = new Solution();
		tool.solve();
		return;
	}
}