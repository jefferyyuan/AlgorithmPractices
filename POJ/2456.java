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
        int C = scan.nextInt();
        int[] stalls = new int[N];
        for (int i = 0; i < N; i++) {
            stalls[i] = scan.nextInt();
        }
        Arrays.sort(stalls);
        int lb = 1, ub = stalls[stalls.length - 1];
        while (ub - lb > 1) {
            int mid = (lb + ub) / 2;
            if (judge(stalls, C, mid)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        System.out.println(lb);
        out.close();
    }

    boolean judge(int[] stalls, int C, int k) {
        int index = 0;
        int count = 0;
        while (index < stalls.length) {
            count++;
            int oldLoc = stalls[index];
            while(index < stalls.length && stalls[index] - oldLoc < k) {
                index++;
            }
        }
        return count >= C;
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
