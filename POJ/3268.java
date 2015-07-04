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
        int M = scan.nextInt();
        int X = scan.nextInt() - 1;
        int[][] dis = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE / 10);
            dis[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            int x1 = scan.nextInt() - 1;
            int x2 = scan.nextInt() - 1;
            dis[x1][x2] = scan.nextInt();
        }

        // dijkstra once
        int[] distTo = new int[N];
        Arrays.fill(distTo, Integer.MAX_VALUE / 10);
        distTo[X] = 0;
        boolean[] used = new boolean[N];
        Arrays.fill(used, false);
        used[X] = true;
        dijkstra(dis, distTo, used, N, X);

        // dijkstra twice
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = dis[i][j];
                dis[i][j] = dis[j][i];
                dis[j][i] = temp;
            }
        }
        int[] distFrom = new int[N];
        Arrays.fill(distFrom, Integer.MAX_VALUE / 10);
        distFrom[X] = 0;
        Arrays.fill(used, false);
        used[X] = true;
        dijkstra(dis, distFrom, used, N, X);

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, distFrom[i] + distTo[i]);
        }
        System.out.println(result);
        out.close();
    }

    void dijkstra(int[][] dis, int[] distTo, boolean[] used, int N, int X) {
        int tempMin = X;
        for (int i = 0; i < N - 1; i++) {
            int newMin = -1;
            used[tempMin] = true;
            for (int j = 0; j < N; j++) {
                if (used[j]) {
                    continue;
                }
                distTo[j] = Math.min(distTo[j], distTo[tempMin] + dis[tempMin][j]);
                if (newMin == -1 || distTo[j] < distTo[newMin]) {
                    newMin = j;
                }
            }
            tempMin = newMin;
        }
        return;
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
