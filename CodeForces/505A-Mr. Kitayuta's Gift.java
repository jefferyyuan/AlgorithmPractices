import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public int solve(String input, int start, int end, int record){
		if(start >= end)
			return record; 
		if(input.charAt(start) == input.charAt(end))
			return solve(input, start + 1, end - 1, record);
		else if(record < 0){
			int tempResult = solve(input, start + 1, end, start);
			if(tempResult < 0)
				tempResult = solve(input, start, end - 1, end);
			return tempResult;
		} else
			return -1;
	}
	public boolean isPalindrome(String input){
		int start = 0, end = input.length() - 1;
		while(start < end){
			if(input.charAt(start) != input.charAt(end))
				return false;
			start ++;
			end --;
		}
		return true;
	}

	public String getResult(String input){
		char[] result = new char[input.length() + 1];
		if(input.length() % 2 == 1){
			for(int i = 0;i < result.length / 2; i++){
				result[i] = input.charAt(i);
				result[result.length - 1 - i] = input.charAt(i);
			}
		}
		else{
			for(int i = 0;i < input.length() / 2; i++){
				result[i] = input.charAt(i);
				result[result.length - 1 - i] = input.charAt(i);
			}
			result[result.length / 2] = 'a';
		}
		return new String(result);
	}

	public String getResult(String input, int record){
		char[] result = new char[input.length() + 1];
		int oldStart = 0, oldEnd = input.length() - 1, newStart = 0, newEnd = result.length - 1;
		while(newStart <= newEnd){
			if(oldStart == record){
				result[newStart++] = input.charAt(oldStart);
				result[newEnd--] = input.charAt(oldStart);
				oldStart ++;
			} else if(oldEnd == record){
				result[newStart++] = input.charAt(oldEnd);
				result[newEnd--] = input.charAt(oldEnd);
				oldEnd --;
			} else{
				result[newStart++] = input.charAt(oldStart++);
				result[newEnd--] = input.charAt(oldEnd --);
			}
		}
		return new String(result);
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		Solution solution = new Solution();
		if(solution.isPalindrome(input))
			System.out.println(solution.getResult(input));
		else{
			int result = solution.solve(input, 0 , input.length() - 1, -1);
			if(result < 0)
				System.out.println("NA");
			else
				System.out.println(solution.getResult(input, result));
		}
		scan.close();
		
	}
}