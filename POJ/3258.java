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
        int L = scan.nextInt();
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] rocks = new int[N + 2];
        rocks[0] = 0;
        rocks[1] = L;
        for (int i = 0; i < N; i++) {
            rocks[i + 2] = scan.nextInt();
        }
        Arrays.sort(rocks);
        int lb = 1, ub = 1000000000;
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (judge(rocks, M, mid)) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }
        System.out.println(ub);
        out.close();
    }

    boolean judge(int[] rocks, int M, int mid) {
        int count = 0;
        int startIndex = 0;
        while (startIndex < rocks.length) {
            int tempIndex = startIndex + 1;
            while (tempIndex < rocks.length && rocks[tempIndex] - rocks[startIndex] < mid) {
                count++;
                tempIndex++;
            }
            startIndex = tempIndex;
        }
        return count <= M;
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
