import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public void init(){
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int k1 = scan.nextInt();
		int k2 = scan.nextInt();
		if(n1 > n2)
			System.out.println("First");
		else
			System.out.println("Second");
		scan.close();
	}

	public void solve(){
		
	}
	public static void main(String[] args){	
		new Solution().init();
	}
}