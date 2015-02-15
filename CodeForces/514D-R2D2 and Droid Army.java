import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int n, m, k;
	int[][] record;
	public void init(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		record = new int[n][m];
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