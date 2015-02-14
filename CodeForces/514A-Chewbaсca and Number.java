import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public void init(){
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		char[] digits = input.toCharArray();
		for(int i = 0; i < digits.length; i++){
			if(digits[i] >= '5'){
				digits[i] = (char)('0' + (9 - (digits[i] - '0')));
			}
		}
		System.out.println(new String(digits));
		scan.close();
	}

	public void solve(){
		
	}
	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
		tool.solve();
	}
}