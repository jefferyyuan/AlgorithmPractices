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
		int index = 0;
		if(digits[index] == '9') index++;
		for(; index < digits.length; index++) {
			if(digits[index] >= '5')
				digits[index] = (char)('0' + ('9' - digits[index]));
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