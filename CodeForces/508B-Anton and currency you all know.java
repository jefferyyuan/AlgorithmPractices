import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public void solve(String number){
		char[] numbers = number.toCharArray();
		int lastValue = (int)(numbers[numbers.length - 1] - '0');
		int changeIndex = -1;
		for(int i = 0; i < numbers.length - 1; i++){
			int value = (int)(numbers[i] - '0');
			if(value % 2 > 0)
				continue;
			if(lastValue > value){
				changeIndex = i;
				break;
			} else{
				changeIndex = i;
			}
		}
		if(changeIndex == -1){
			System.out.println(-1);
		} else{
			char tempChar = numbers[changeIndex];
			numbers[changeIndex] = numbers[numbers.length - 1];
			numbers[numbers.length - 1] = tempChar;
			System.out.println(String.valueOf(numbers));
		}
		return;
	}
	public static void main(String[] args){
		Solution tool = new Solution();
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		tool.solve(number);
		scan.close();
		return;
	}
}