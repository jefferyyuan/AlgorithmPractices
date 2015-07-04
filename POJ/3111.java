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
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] v = new int[n]; 
        int[] w = new int[n]; 
        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        double lb = 0, ub = 1000005;
        for (int i = 0; i < 50; i++) {
            double mid = (lb + ub) / 2;
            if (judge(v, w, k, mid)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        output(v, w, k, lb);
        out.close();
    }

    public class Record {
        double value;
        int index;
        public Record(double t_value, int t_index) {
            value = t_value;
            index = t_index;
        }
    }

    void output(int[] v, int[] w, int k, double mid) {
        Record[] rlist = new Record[v.length];
        for (int i = 0; i < rlist.length; i++) {
            rlist[i] = new Record(v[i] - w[i] * mid, i);
        }
        Arrays.sort(rlist, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                if (o2.value > o1.value) {
                    return 1;
                } else if (o2.value == o1.value) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            System.out.print(rlist[i].index + 1);
            if (i == k - 1) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        return;
    }

    boolean judge(int[] v, int[] w, int k, double mid) {
        double[] record = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            record[i] = v[i] - w[i] * mid;
        }
        Arrays.sort(record);
        int startIndex = 0, endIndex = record.length - 1;
        while (startIndex < endIndex) {
            double temp = record[endIndex];
            record[endIndex] = record[startIndex];
            record[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += record[i];
        }
        return sum >= 0;
    }

    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
