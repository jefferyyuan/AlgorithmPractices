
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int n,m;
	HashSet<String> record = new HashSet<String>();
	public void init(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		for(int i = 0; i < n; i++){
			String input = scan.next();
			record.add(input);
		}

		for(int i = 0; i < m; i++){
			String input = scan.next();
			char[] charArray = input.toCharArray();
			boolean isValid = false;
			for(int j = 0; j < charArray.length; j++){
				char c = charArray[j];
				for(char d = 'a'; d <= 'c'; d = (char)(d + 1)){
					if(d == c)
						continue;
					charArray[j] = d;
					if(record.contains(new String(charArray))){
						isValid = true;
						break;
					}
				}
				charArray[j] = c;
				if(isValid)
					break;
			}
			if(isValid)
				System.out.println("YES");
			else
				System.out.println("NO");
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