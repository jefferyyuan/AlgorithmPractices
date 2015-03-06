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

  public void addRecord(int value, HashMap<Integer, Integer> record, int positive){
    if(value <= 1) return;
    if(value == 2) {
      record.put(2, record.get(2) + positive * 1);
    } else if(value == 3) {
      record.put(3, record.get(3) + positive * 1);
    } else if(value == 4) {
      record.put(2, record.get(2) + positive * 2);
    } else if(value == 5) {
      record.put(5, record.get(5) + positive * 1);
    } else if(value == 6) {
      record.put(2, record.get(2) + positive * 1);
      record.put(3, record.get(3) + positive * 1);
    } else if(value == 7) {
      record.put(7, record.get(7) + positive * 1);
    } else if(value == 8) {
      record.put(2, record.get(2) + positive * 3);
    } else if(value == 9) {
      record.put(3, record.get(3) + positive * 2);
    }
    addRecord(value - 1, record, positived);
    return;
  }


	public void init(){
		MyScanner scan = new MyScanner();
      	out = new PrintWriter(new BufferedOutputStream(System.out));
      int n = Integer.valueOf(scan.nextLine());
      String line = scan.nextLine();
      HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
      record.put(2, 0);
      record.put(3, 0);
      record.put(5, 0);
      record.put(7, 0);
      for(int i = 0; i < line.length(); i++) {
        int value = line.charAt(i) - '0';
        addRecord(value, record, 1);
      }
      int count = record.get(7);
      while(count > 0) {
        out.print(7);
        addRecord(7, record, -1);
        count--;
      }
      count = record.get(5);
      while(count > 0) {
        out.print(5);
        addRecord(5, record, -1);
        count--;
      }
      count = record.get(3);
      while(count > 0) {
        out.print(3);
        addRecord(3, record, -1);
        count--;
      }
       count = record.get(2);
      while(count > 0) {
        out.print(2);
        addRecord(2, record, -1);
        count--;
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