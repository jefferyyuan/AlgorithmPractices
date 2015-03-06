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

   public int gcd(int a, int b) {
    if(b == 0)
      return a;
    return gcd(b, a % b);
   }
	public void init(){
		MyScanner scan = new MyScanner();
      	out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean[] boyHappy = new boolean[n];
        Arrays.fill(boyHappy, false);
        boolean[] girlHappy = new boolean[m];
        Arrays.fill(girlHappy, false);
        int boyHappyCount = scan.nextInt();
        for(int i = 0; i < boyHappyCount; i++){
          boyHappy[scan.nextInt()] = true;
        }
        int girlHappyCount = scan.nextInt();
        for (int i = 0; i < girlHappyCount; i++) {
          girlHappy[scan.nextInt()] = true;
        }
        int gcdNumber = gcd(n, m);
        if (gcdNumber == 1) {
          if(girlHappyCount + boyHappyCount > 0)
            out.println("Yes");
          else
            out.println("No");
        } else {
          boolean isValid = true;
          for(int i = 0; i < gcdNumber; i++) {
             boolean hasFound = false;
             for(int j = i; j < n; j += gcdNumber) {
               if(boyHappy[j]) {
                hasFound = true;
                break;
               }
             }
             if(hasFound) continue;
             for(int j = i; j < m; j += gcdNumber) {
               if(girlHappy[j]) {
                hasFound = true;
                break;
               }
             }
             if(!hasFound) {
              isValid = false;
              break;
             }
          }
          if(isValid) {
            out.println("Yes");
          } else {
            out.println("No");
          }
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