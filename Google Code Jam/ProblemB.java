import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class ProblemB{
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
	
	public static void main(String[] args){
		MyScanner scan = new MyScanner();
      	out = new PrintWriter(new BufferedOutputStream(System.out));
      
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
      	int testCase = scan.nextInt();
      	for (int i = 1; i <= testCase; i++) {
      		int n = scan.nextInt();
      		int[] values = new int[n];
      		for (int j = 0; j < n; j++) {
      			values[j] = scan.nextInt();
      		}
      		int minResult = 9;
      		for (int j = 9; j >= 1; j--) {
      			int count = j;
      			for (int k = 0; k < n; k++) {
      				count += values[k] / j;
      				if (values[k] % j == 0) {
      					count--;
      				}
      			}
      			minResult = Math.min(minResult, count);
      		}
      		/*
      		Arrays.sort(values);
      		int minResult = values[values.length - 1];
      		for (int j = values.length - 2; j >= 0; j--) {
      			int count = values[j];
      			for (int k = values.length - 1; k > j; k--) {
      				count += values[k] / values[j];
      				if (values[k] % values[j] != 0) {
      					count ++;
      				}
      			}
      			minResult = Math.min(minResult, count);
      		}
      		*/
      		out.println("Case #" + i + ": " + minResult);
      	}
      	out.close();
      
	}
}