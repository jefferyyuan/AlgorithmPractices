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
        Edge[] elist = new Edge[N];
        Arrays.fill(elist, null);
        for (int i = 0; i < M; i++) {
            int x1 = scan.nextInt() - 1;
            int x2 = scan.nextInt() - 1;
            int cost = scan.nextInt();
            add(elist, new Edge(x1, x2, cost));
            add(elist, new Edge(x2, x1, cost));
        }
        System.out.println(prim(elist, N));
        out.close();
    }

    void add(Edge[] elist, Edge e) {
        int index = e.start;
        e.next = elist[index];
        elist[index] = e;
    }

    int prim(Edge[] elist, int N) {
        int[] dist = new int[N];
        int sum = 0;
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[0] = 0;
        boolean[] used = new boolean[N];
        Arrays.fill(used, false);
        for (int i = 0; i < N; i++) {
            int tempMax = Integer.MIN_VALUE;
            int tempIndex = -1;
            for (int j = 0; j < N; j++) {
                if (used[j]) {
                    continue;
                }
                if (dist[j] > tempMax) {
                    tempMax = dist[j];
                    tempIndex = j;
                }
            }
            if(tempMax == Integer.MIN_VALUE) {
                return -1;
            }
            used[tempIndex] = true;
            sum += tempMax;
            Edge tempEdge = elist[tempIndex];
            while (tempEdge != null) {
                if (!used[tempEdge.end]) {
                    dist[tempEdge.end] = Math.max(dist[tempEdge.end], tempEdge.cost);
                }
                tempEdge = tempEdge.next;
            }
        }
        return sum;
    }

    public class Edge {
        int start, end, cost;
        Edge next = null;
        public Edge (int t_start, int t_end, int t_cost) {
            start = t_start;
            end = t_end;
            cost = t_cost;
        }
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
