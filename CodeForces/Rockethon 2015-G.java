
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int n,k;
	int[] target;
	int resultCount = 0;
	int totalCount = 0;
	public void init(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		target = new int[n];
		for(int i = 0; i < n; i++){
			target[i] = scan.nextInt();
		}
		scan.close();
	}

	public void solve(){
		search(target, 0);
		System.out.println(resultCount / (totalCount + 0.0));
	}

	public void search(int[] current, int iteration){
		if(iteration == k){
			resultCount += reversionCount(current);
			totalCount ++;
			return;
		}
		for(int i = 0; i < current.length; i++){
			for(int j = i; j < current.length; j++){
				int startIndex = Math.min(i, j);
				int endIndex = Math.max(i, j);
				reverse(current, startIndex, endIndex);
				search(current, iteration + 1);
				reverse(current, startIndex, endIndex);
			}
		}
	}

	public void reverse(int[] sequence, int startIndex, int endIndex){
		while(startIndex < endIndex){
			int temp = sequence[startIndex];
			sequence[startIndex] = sequence[endIndex];
			sequence[endIndex] = temp;
			startIndex ++;
			endIndex --;
		}
		return;
	}

	public int reversionCount(int[] current){
		int tempResult = 0;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				if(current[i] > current[j])
					tempResult++;
			}
		}
		return tempResult;
	}
	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
		tool.solve();
	}
}