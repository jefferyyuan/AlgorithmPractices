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
        Scanner scan = new Scanner(System.in);
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
        int[][] dist = new int[100][100];
        while (scan.hasNext()) {
            int N = scan.nextInt();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = scan.nextInt();
                }
            }
            System.out.println(prim(dist, N));
        }
        out.close();
    }

    int prim(int[][] dist, int N) {
        boolean[] used = new boolean[N];
        Arrays.fill(used, false);
        used[0] = true;
        int[] record = new int[N];
        for (int i = 0; i < N; i++) {
            record[i] = dist[0][i];
        }
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            int tempMin = Integer.MAX_VALUE;
            int tempMinIndex = -1;
            for (int j = 0; j < N; j++) {
                if (used[j]) {
                    continue;
                }
                if (record[j] < tempMin) {
                    tempMin = record[j];
                    tempMinIndex = j;
                }
            }
            sum += tempMin;
            used[tempMinIndex] = true;
            for (int j = 0; j < N; j++) {
                if (!used[j]) {
                    record[j] = Math.min(record[j], dist[tempMinIndex][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}

