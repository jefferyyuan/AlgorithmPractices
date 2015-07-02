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

    int MAX = 100005;
    int[] parent = new int[MAX * 2];

    void init(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            parent[i + MAX] = i + MAX;
        }
    }

    int getRoot(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = getRoot(parent[x]);
            return parent[x];
        }
    }

    void sublink(int x, int y) {
        int rx = getRoot(x);
        int ry = getRoot(y);
        if (rx != ry) {
            parent[rx] = ry;
        }
    }
    void link(int x, int y) {
        int x_1 = x, x_2 = x + MAX;
        int y_1 = y, y_2 = y + MAX;
        sublink(x_1, y_2);
        sublink(x_2, y_1);
        return;
    }

    void isUnion(int x, int y) {
        if (getRoot(x) == getRoot(y) || getRoot(x + MAX) == getRoot(y + MAX)) {
            out.println("In the same gang.");
        } else if (getRoot(x + MAX) == getRoot(y) || getRoot(x) == getRoot(y + MAX)) {
            out.println("In different gangs.");
        } else {
            out.println("Not sure yet.");
        }
    }

    public void solve() {
        MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            init(N);
            for (int j = 0; j < M; j++) {
                String command = scan.next();
                int index1 = scan.nextInt() - 1;
                int index2 = scan.nextInt() - 1;
                if (command.compareTo("D") == 0) {
                    link(index1, index2);
                } else {
                    if (N == 2) {
                        System.out.println("In different gangs.");
                    } else {
                        isUnion(index1, index2);
                    }
                }
            }
        }
        out.close();
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
