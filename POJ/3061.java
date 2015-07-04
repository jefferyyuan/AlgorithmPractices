import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
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

    public void solve(){
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
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int S = scan.nextInt();
            int[] input = new int[N];
            for (int j = 0; j < N; j++) {
                input[j] = scan.nextInt();
            }
            int startIndex = 0, endIndex = 0;
            int sum = 0;
            int minLength = Integer.MAX_VALUE;
            while (startIndex < input.length && endIndex < input.length) {
                while (sum < S && endIndex < input.length) {                   
                    sum += input[endIndex];
                    endIndex++;
                }
                while (startIndex < input.length && sum >= S) {
                    sum -= input[startIndex];
                    startIndex++;
                }
                if (startIndex - 1 >= 0 && sum + input[startIndex - 1] >= S) {
                    minLength = Math.min(minLength, endIndex - startIndex + 1);
                }
            }
            if (minLength == Integer.MAX_VALUE) {
                minLength = 0;
            }
            System.out.println(minLength);
        }
        out.close();
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}

