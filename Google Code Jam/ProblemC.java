import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class ProblemC{
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
	static int[][] record = {{1, 2, 3, 4}, {2, -1, 4, -3}, {3, -4, -1, 2}, {4, 3, -2 ,-1}};
	public static int multiply(int x1, int x2) {
		int sign = 1;
		if (x1 < 0) {
			x1 = -x1;
			sign *= -1;
		}
		if (x2 < 0) {
			x2 = -x2;
			sign *= -1;
		}
		return sign * (record[x1 - 1][x2 - 1]);
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
      		int L = scan.nextInt();
      		int X = scan.nextInt();
      		String word = scan.next();
      		int[] source = new int[L * X];
      		for (int j = 0; j < X; j++) {
      			for (int k = 0; k < L; k++) {
      				source[j * L + k] = word.charAt(k) - 'i' + 2;
      			}
      		}
      		
      		boolean result = true;
      		int index = 0;
      		int tempResult = 1;
      		while (tempResult != 2 && index < source.length) {
      			tempResult = ProblemC.multiply(tempResult, source[index]);
      			index++;
      		}
      		if (index == source.length) {
      			result = false;
      		} else {
      			tempResult = 1;
      			while (tempResult != 3 && index < source.length) {
          			tempResult = ProblemC.multiply(tempResult, source[index]);
          			index++;
          		}
      			if (index == source.length) {
      				result = false;
      			} else {
      				tempResult = 1;
      				while (index < source.length) {
      					tempResult = ProblemC.multiply(tempResult, source[index]);
      					index++;
      				}
      				if (tempResult != 4) {
      					result = false;
      				}
      			}
      		}
      		if (result) {
      			out.println("Case #" + (i + 1) + ": " + "YES");
      		} else {
      			out.println("Case #" + (i + 1) + ": " + "NO");
      		}
      	}
      	out.close();
	}
}