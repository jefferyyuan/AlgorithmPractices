import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int n;
	long m;
	public void init(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextLong();
		scan.close();
	}

	public void solve(){
		int[] sequence = new int[n];
		for(int i = 1; i <= n; i++){
			sequence[i - 1] = i;
		}
		getSequence(sequence, 0, n - 1, m, 1);
		for(int i = 0; i < n; i++){
			System.out.print(sequence[i] + " ");
		}
		System.out.println();
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
	public void getSequence(int[] sequence, int startIndex, int endIndex, long k, int value){
		if(startIndex > endIndex)
			return;
		else if(startIndex == endIndex){
			sequence[startIndex] = value;
			return;
		}
		long tempValue = 1;
		long compare = tempValue << (endIndex - startIndex - 1);
		if(k > compare){
			//sequence[endIndex] = value;
			getSequence(sequence, startIndex, endIndex, 2 * compare + 1 - k, value);
			reverse(sequence, startIndex, endIndex);
		}
		else{
			sequence[startIndex] = value;
			getSequence(sequence, startIndex + 1, endIndex, k, value + 1);
		}
		
	}
	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
		tool.solve();
	}
}