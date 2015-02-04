import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int[][] charOrder = new int[26][26];
	boolean isValid = true;
	String output = "Impossible";
	public void init(){
		for(int i = 0; i < 26; i++){
			Arrays.fill(charOrder[i], -1);
		}
		for(int i = 0; i < 26; i++)
			charOrder[i][i] = 1;
		Scanner scan = new Scanner(System.in);
		int t = Integer.valueOf(scan.nextLine());
		String preLine = scan.nextLine();
		for(int i = 1; i < t; i++){
			String line = scan.nextLine();
			if(!isValid)
				continue;
			boolean tempCheck = false;
			for(int j = 0; j < Math.min(preLine.length(), line.length()); j++){
				if(set(preLine.charAt(j), line.charAt(j))){
					tempCheck = true;
					break;
				}
			}
			if(!tempCheck && preLine.length() > line.length())
				isValid = false;
			preLine = line;
		}
		solve();
		System.out.println(output);
		scan.close();
	}
	public boolean set(char c1, char c2){
		if(c1 == c2)
			return false;
		int index1 = (int)(c1 - 'a');
		int index2 = (int)(c2 - 'a');
		set(index1, index2, false);
		return true;

	}
	public void set(int index1, int index2, boolean isSingle){
		if(!isValid)
			return;
		if(charOrder[index1][index2] == 0){
			isValid = false;
		} else {
			charOrder[index1][index2] = 1;
			charOrder[index2][index1] = 0;
			if(isSingle)
				return;
			for(int i = 0; i < 26; i++){
				if(charOrder[i][index1] == 1){
					for(int j = 0; j < 26; j++){
						if(charOrder[index2][j] == 1){
							set(i, j, true);
						}
					}
				}
			}
		}
		return;
	}

	public void solve(){
		if(!isValid)
			return;
		StringBuffer result = new StringBuffer();
		int[] inCount = new int[26];
		Arrays.fill(inCount, 0);
		for(int i = 0; i < 26; i++){
			for(int j = 0; j < 26; j++){
				if(charOrder[j][i] == 1)
					inCount[i]++;
			}
		}
		for(int i = 0; i < 26; i++){
			for(int j = 0; j < 26; j++){
				if(inCount[j] == 1){
					result.append((char)('a' + j));
					inCount[j] --;
					for(int k = 0; k < 26; k++){
						if(charOrder[j][k] == 1)
							inCount[k]--;
					}
					break;
				}
			}
		}
		output = result.toString();
		return;
	}
	public static void main(String[] args){
		Solution tool = new Solution();
		tool.init();
		
	}
}