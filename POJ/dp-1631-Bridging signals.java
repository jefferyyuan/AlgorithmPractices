//	dp
//	最长上升子序列问题
// 	挑战程序设计竞赛: p64
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	int max = 40001;
	int[] record = new int[max];
	int[] result = new int[max];
	public int solve(int length){
		int finalResult = Integer.MIN_VALUE;
		Arrays.fill(result, Integer.MAX_VALUE);
		result[0] = record[0];
		for(int i = 1; i < length; i++){
			int index = binarySearch(0, length - 1, record[i]);
			if(result[index] == Integer.MAX_VALUE)
				continue;
			result[index] = record[i];
			finalResult = Math.max(finalResult, index + 1);
		}
		return finalResult;

	}

	public int binarySearch(int start, int end, int value){
		if(start == end)
			return start;
		int mid = (start + end) / 2;
		if(result[mid] == value)
			return mid;
		else if(result[mid] > value)
			return binarySearch(start, mid, value);
		else 
			return binarySearch(mid + 1, end, value);
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Main solution = new Main();
		int caseCount = scan.nextInt();
		for(int i = 0; i < caseCount; i++){
			int nodeCount = scan.nextInt();
			for(int j = 0; j < nodeCount; j ++)
				solution.record[j] = scan.nextInt();
			System.out.println(solution.solve(nodeCount));
		}
		scan.close();
	}
}