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
        int N = scan.nextInt();
        int K = scan.nextInt();
        double[] input = new double[N];
        for (int i = 0; i < N; i++) {
            input[i] = scan.nextDouble();
        }
        double lb = 0, ub = 100001;
        for (int i = 0; i < 100; i++) {
            double mid = (lb + ub) / 2;
            int count = 0;
            for (int j = 0; j < N; j++) {
                count += input[j] / mid;
            }
            if (count < K) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        double result = ((int)(ub * 100)) / 100.0;
        System.out.format("%.2f%n", result);
        out.close();
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
