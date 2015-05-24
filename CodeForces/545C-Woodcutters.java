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
        int n = scan.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        int maxX = 0;
        for (int i = 0; i < n; i++) {
            x[i] = scan.nextInt();
            h[i] = scan.nextInt();
            maxX = max(maxX, x[i] + h[i]);
        }
        HashMap<Long, Integer> record = new HashMap<Long, Integer>();
        out.println(dp(x, h, record, n - 1, maxX));
        out.close();
    }
    public int dp(int[] x, int[] h, HashMap<Long, Integer> record, int pos, int limit) {
        if (pos < 0) {
            return 0;
        }
        long key = pos;
        key = key << 10;
        key += limit;
        if (record.containsKey(key)) {
            return record.get(key);
        }
        int result = 0;
        if (limit >= x[pos] + h[pos]) {
            result = max(result, dp(x, h , record, pos - 1, x[pos] - 1) + 1);
        }  else {   
            result = max(result, dp(x, h, record, pos - 1, x[pos] - 1));
        }
        if (!(pos > 0 && x[pos] - h[pos] - 1 < x[pos - 1])) {
            result = max(result, dp(x, h, record, pos - 1, x[pos] - h[pos] - 1) + 1);
        }
        record.put(key, result);
        return result;
    }

    public int max(int v1, int v2) {
        return v1 > v2 ? v1 : v2;
    }
    public static void main(String[] args){ 
        Solution tool = new Solution();
        tool.init();
    }
}