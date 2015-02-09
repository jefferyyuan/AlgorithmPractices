import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int n;
	int[] left;
	int[] right;
	
	public int getLessOrEqual(int index, int value){
		if(value < left[index])
			return 0;
		if(value > right[index])
			return right[index] - left[index] + 1;
		else
			return value - left[index] + 1;
	}
	
	public int getLargeOrEqual(int index, int value){
		if(value > right[index])
			return 0;
		else if(value < left[index])
			return right[index] - left[index] + 1;
		else
			return right[index] - value + 1;
	}
	public void init(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		left = new int[n];
		right = new int[n];
		int minimum = Integer.MAX_VALUE;
		int maximum = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){
			left[i] = scan.nextInt();
			minimum = Math.min(minimum, left[i]);
			right[i] = scan.nextInt();
			maximum = Math.max(maximum, right[i]);
		}
		double[] record = new double[10005];
		Arrays.fill(record, 0.0);
		
		for(int i = minimum; i <= maximum; i++){
			// first case
			for(int j = 0; j < n; j++){
				double tempResult = getLargeOrEqual(j, i + 1);
				double tempResult2 = 1;
				double tempResult3 = 1;
				for(int k = 0; k < n; k++){
					if(k == j) continue;
					tempResult2 *= getLessOrEqual(k, i);
					tempResult3 *= getLessOrEqual(k, i - 1);
				}
				tempResult *= (tempResult2 - tempResult3);
				record[i] += tempResult;
			}
			
			// second case
			double tempResult = 1;
			for(int k = 0; k < n; k++){
				tempResult *= getLessOrEqual(k, i);
			}
			double tempResult1 = 1;
			for(int k = 0; k < n; k++){
				tempResult1 *= getLessOrEqual(k, i - 1);
			}
			double tempResult2 = 0;
			for(int j = 0; j < n; j++){
				double tempResult3 = getLessOrEqual(j, i) - getLessOrEqual(j, i - 1);
				for(int k = 0; k < n; k++){
					if(k == j) continue;
					tempResult3 *= getLessOrEqual(k, i - 1);
				}
				tempResult2 += tempResult3;
			}
			tempResult -= (tempResult1 + tempResult2);
			record[i] += tempResult;
		}
		double combinationCount = 1;
		for(int i = 0; i < n; i++){
			combinationCount *= (right[i] - left[i] + 1);
		}
		double expectation = 0;
		for(int i = minimum; i <= maximum; i++){
			expectation += i * record[i];
		}
		System.out.println((expectation) / (combinationCount + 0.0));
		scan.close();
	}
	public static void main(String[] args){	
		new Solution().init();
	}
}