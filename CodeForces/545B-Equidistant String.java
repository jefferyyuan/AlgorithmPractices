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
        String[] input = new String[2];
        input[0] = scan.nextLine();
        input[1] = scan.nextLine();
        int turn = 0;
        char[] result = new char[input[0].length()];
        for (int i = 0; i < input[0].length(); i++) {
            if (input[0].charAt(i) == input[1].charAt(i)) {
                result[i] = input[0].charAt(i);
            } else {
                result[i] = input[turn].charAt(i);
                turn = 1 - turn;
            }
        }
        if (turn == 1) {
            out.println("impossible");
        } else {
            for (int i = 0; i < result.length; i++) {
                out.print(result[i]);
            }
            out.println();
        }
        out.close();
    }

    public static void main(String[] args){ 
        Solution tool = new Solution();
        tool.init();
    }
}