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
    int MOD_NUMBER = 1000000007;
	public void init(){
        int[][] record = new int[2005][2005];
        int[][] record2 = new int[2005][2005];

        for (int i = 0; i <= 2000; i++) {
            record[i][0] = 1;
        }
        for (int i = 1; i<= 2000; i++) {
            for (int j = 1; j<= i; j++) {
                record[i][j] = record[i][j - 1];
                if (i - 1 >= j) {
                    record[i][j] += record[i - 1][j];
                }
                record[i][j] %= MOD_NUMBER;
            }
        }

        for (int i = 1; i <= 2000; i++) {
            record2[i][0] = 1;
        }
        for (int i = 1; i<= 2000; i++) {
            for (int j = 1; j<= i; j++) {
                record2[i][j] = record2[i][j - 1];
                if (i - 1 > j) {
                    record2[i][j] += record2[i - 1][j];
                }
                record2[i][j] %= MOD_NUMBER;
            }
        }
		MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int count =  Integer.valueOf(scan.nextLine());
        for (int i = 0; i < count; i++){
            String line = scan.nextLine();
            String[] values = line.split("-");
            int x = Integer.valueOf(values[0]);
            int y = Integer.valueOf(values[1]);
            out.println("Case #" + (i + 1) + ": " + record2[x][y] + " " + record[y][y]);
        }
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