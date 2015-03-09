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
        ArrayList<HashMap<Long, Integer>> record = new ArrayList<HashMap<Long, Integer>>();
        for (int i = 0; i < 26; i++) {
            record.add(new HashMap<Long, Integer>());
        }
        Long sum = (long)0;
        long result = 0;
        int[] points = new int[26];
        for (int i = 0; i < 26; i++) {
            points[i] = scan.nextInt();
        }
        String line = scan.nextLine();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            HashMap<Long, Integer> map = record.get(c - 'a');
            if (map.containsKey(sum)) {
                result += (long)map.get(sum);
            }
            sum += (long)points[c - 'a'];
            if (!map.containsKey(sum)) {
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum) + 1);
        }
        out.println(result);
      	out.close();
	}

	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
	}
}