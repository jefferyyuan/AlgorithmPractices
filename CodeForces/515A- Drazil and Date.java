import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	//-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
	  
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
	  BufferedReader br;
	  StringTokenizer st;
 
	  public MyScanner() {
		 br = new BufferedReader(new InputStreamReader(System.in));
	  }
 
	  String next() {
		  while (st == null || !st.hasMoreElements()) {
			  try {
				  st = new StringTokenizer(br.readLine());
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		  }
		  return st.nextToken();
	  }
 
	  int nextInt() {
		  return Integer.parseInt(next());
	  }
 
	  long nextLong() {
		  return Long.parseLong(next());
	  }
 
	  double nextDouble() {
		  return Double.parseDouble(next());
	  }
 
	  String nextLine(){
		  String str = "";
	  try {
		 str = br.readLine();
	  } catch (IOException e) {
		 e.printStackTrace();
	  }
	  return str;
	  }

   }

	public void init(){
		MyScanner scan = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		long x = Math.abs(scan.nextLong());
		long y = Math.abs(scan.nextLong());
		long s = Math.abs(scan.nextLong());
		if(s >= (x + y) && (s - x - y) % 2 == 0)
		  out.println("Yes");
		else
			out.println("No");
		  
		// Start writing your solution here. -------------------------------------
   
		 /*
		int n      = sc.nextInt();        // read input as integer
		long k     = sc.nextLong();       // read input as long
		double d   = sc.nextDouble();     // read input as double
		String str = sc.next();           // read input as String
		String s   = sc.nextLine();       // read whole line as String

		int result = 3*n;
		out.println(result);                    // print via PrintWriter
		*/

		// Stop writing your solution here. -------------------------------------
		out.close();
	}

	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
	}
}