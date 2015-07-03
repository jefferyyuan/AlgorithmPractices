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
        int F = scan.nextInt();
        for (int i = 0; i < F; i++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int W = scan.nextInt();
            int[] dis = new int[N];
            int[][] edges = new int[M + W][3];
            for (int j = 0; j < M; j++) {
                edges[j][0] = scan.nextInt() - 1;
                edges[j][1] = scan.nextInt() - 1;
                edges[j][2] = scan.nextInt();
            }
            for (int j = 0; j < W; j++) {
                edges[j + M][0] = scan.nextInt() - 1;
                edges[j + M][1] = scan.nextInt() - 1;
                edges[j + M][2] = -scan.nextInt();
            }
            Arrays.fill(dis, Integer.MAX_VALUE / 10);
            dis[0] = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M + W; k++) {
                    dis[edges[k][1]] = Math.min(dis[edges[k][1]], dis[edges[k][0]] + edges[k][2]);
                    if (k < M) {
                        dis[edges[k][0]] = Math.min(dis[edges[k][0]], dis[edges[k][1]] + edges[k][2]);
                    }
                }
            }
            boolean result = true;
            for (int k = 0; k < M + W; k++) {
                if (dis[edges[k][1]] > dis[edges[k][0]] + edges[k][2]) {
                    result = false;
                    break;
                } else if (k < M && dis[edges[k][0]] > dis[edges[k][1]] + edges[k][2]) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        out.close();
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
