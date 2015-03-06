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
        int bound = 15;
        int[] record = new int[200005];
        int[][] gift = new int[200005][bound];
        MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int testCaseCount = scan.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            int N = scan.nextInt();
            for (int j = 0; j < N; j++) {
                record[j] = scan.nextInt();
            }
            for (int j = 0; j < N; j++) {
                Arrays.fill(gift[j], 0);
            }
            int[] tempMinRecord = new int[bound];
            for (int j = N - 1; j >= 0; j--) {
                Arrays.fill(tempMinRecord, Integer.MAX_VALUE);
                int managerIndex = record[j] - 1;
                for (int k = 0; k < bound; k++) {
                    gift[j][k] += (k + 1);
                    if(managerIndex < 0) 
                        continue;
                    for (int t = 0; t < bound; t++) {
                        if (t == k) {
                            continue;
                        } else {
                            tempMinRecord[t] = Math.min(tempMinRecord[t], gift[j][k]);
                        }
                    } 
                }
                if(managerIndex < 0) 
                    continue;
                for(int k = 0; k < bound; k++) {
                    gift[managerIndex][k] += tempMinRecord[k];
                }
            }
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < bound; j++) {
                minValue = Math.min(minValue, gift[0][j]);
            }
            out.println("Case #" + (i + 1) + ": " + minValue);
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