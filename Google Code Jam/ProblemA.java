import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class ProblemA{
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
      	for (int i = 0; i < testCase; i++) {
      		// read input and transform
      		int max = scan.nextInt();
      		String input = scan.next();
      		int[] values = new int[input.length()];
      		for (int j = 0; j < input.length(); j++) {
      			values[j] = input.charAt(j) - '0';
      		}

      		int start = 0, target = 0;
      		int need = 0;
      		while (start < values.length) {
      			while (start <= target && start < values.length) {
      				target += values[start];
      				start++;
      			}
      			if (start >= values.length) {
      				break;
      			} else {
      				need ++;
      				target ++;
      			}
      		}
      		out.println("Case #" + (i + 1) + ": " + need);
      	}
      	out.close();
	}
}