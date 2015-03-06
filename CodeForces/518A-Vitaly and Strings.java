import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public void init(){
		Scanner scan = new Scanner(System.in);
		String line1 = scan.nextLine();
		String line2 = scan.nextLine();
		char[] smallArray = line1.toCharArray();
		for (int i = smallArray.length - 1; i>= 0; i--) {
			if (smallArray[i] == 'z') {
				smallArray[i] = 'a';
			} else {
				smallArray[i] = (char)(smallArray[i] + 1);
				break;
			}
		}
		String result = new String(smallArray);
		if (line2.compareTo(result) == 0) {
			System.out.println("No such string");
		} else {
			System.out.println(result);
		}
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