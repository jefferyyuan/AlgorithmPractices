//	greedy practices
//  挑战程序设计竞赛 p44
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = Integer.valueOf(scan.nextLine());
		char[] input = new char[n];
		char[] result = new char[n];
		for (int i = 0; i < n; i++){
			input[i] = scan.nextLine().charAt(0);
		}
		int startIndex = 0, endIndex = n - 1;
		int index = 0;
		while(startIndex <= endIndex){
			if(input[startIndex] < input[endIndex] || startIndex == endIndex)
				result[index ++] = input[startIndex ++];
			else if(input[startIndex] > input[endIndex])
				result[index ++] = input[endIndex --];
			else{
				int tempStart = startIndex;
				int tempEnd = endIndex;
				while(tempStart < tempEnd && input[tempStart] == input[tempEnd]){
					tempStart ++;
					tempEnd --;
				}
				if(tempStart >= tempEnd || input[tempStart] < input[tempEnd])
					result[index ++] = input[startIndex ++];
				else
					result[index ++] = input[endIndex --];
			}
		}
		for(int i = 0; i < n; i++){
			System.out.print(result[i]);
			if( (i + 1) % 80 == 0)
				System.out.println();
		}
		scan.close();

	}
}