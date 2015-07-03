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
        int[][] relation = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(relation[i], Integer.MAX_VALUE / 5);
            relation[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            int count = scan.nextInt();
            int[] tempList = new int[count];
            for (int j = 0; j < count; j++) {
                tempList[j] = scan.nextInt() - 1;
            }
            for (int j = 0; j < count; j++) {
                for (int k = j + 1; k < count; k++) {
                    relation[tempList[j]][tempList[k]] = 1; 
                    relation[tempList[k]][tempList[j]] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if( j != i && k != i && j != k) {
                       relation[j][k] = Math.min(relation[j][k], relation[j][i] + relation[i][k]);
                       relation[k][j] = relation[j][k];
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += relation[i][j]; 
            }
            result = Math.min(result, (int)(sum));
        }
        out.println(100 * result / (N - 1));
        out.close();
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
