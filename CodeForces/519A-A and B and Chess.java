import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public void init(){
		Scanner scan = new Scanner(System.in);
		HashMap<Character, Integer> record = new HashMap<Character, Integer>();
		record.put('Q', 9);
		record.put('R', 5);
		record.put('B', 3);
		record.put('N', 3);
		record.put('P', 1);
		record.put('q', -9);
		record.put('r', -5);
		record.put('b', -3);
		record.put('n', -3);
		record.put('p', -1);
		int result = 0;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			for (int i = 0; i < line.length(); i++) {
				if(record.containsKey(line.charAt(i))) {
					result += record.get(line.charAt(i));
				}
			}
		}
		if (result > 0) {
			System.out.println("White");
		} else if (result == 0) {
			System.out.println("Draw");
		} else {
			System.out.println("Black");
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