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
        int count = scan.nextInt();
        int[][] record = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                record[i][j] = scan.nextInt();
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            boolean isValid = true;
            for (int j = 0; j < count; j++) {
                if (j == i) {
                    continue;
                }
                if (record[i][j] % 2 != 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result.add(i + 1);
            }
        }
        out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            out.print(result.get(i));
            if (i != result.size() - 1) {
                out.print(" ");
            } else {
                out.println();
            }
        }
        out.close();
    }

    public static void main(String[] args){ 
        Solution tool = new Solution();
        tool.init();
    }
}