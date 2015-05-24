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
        int charCount = scan.nextInt();
        String word = scan.next();
        boolean[] record = new boolean[26];
        Arrays.fill(record, false);
        for (int i = 0; i < charCount; i++) {
            char c = word.charAt(i);
            if ( c >= 'a' && c <= 'z') {
                record[c - 'a'] = true;
            } else if (c >= 'A' && c <= 'Z') {
                record[c - 'A'] = true;
            }
        }
        boolean result = true;
        for (int i = 0; i < 26; i++) {
            if (!record[i]) {
                result = false;
                break;
            }
        }
        if (result) {
            out.println("YES");
        } else {
            out.println("NO");
        }
      	out.close();
	}

	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
	}
}