import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public class Wood {
        int l, w;
        public Wood(int t_l, int t_w) {
            l = t_l;
            w = t_w;
        }
    }

    public void solve() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scan.nextInt();
            Wood[] woods = new Wood[n];
            for (int j = 0; j < n; j++) {
                int t_l = scan.nextInt();
                int t_w = scan.nextInt();
                woods[j] = new Wood(t_l, t_w);
            }
            //sort
            Arrays.sort(woods, new Comparator<Wood>() {
                @Override
                public int compare(Wood o1, Wood o2) {
                    if (o1.l != o2.l) {
                        return o1.l - o2.l;
                    } else {
                        return o1.w - o2.w;
                    }
                }
            });
            //count
            int result = 0;
            boolean[] used = new boolean[n];
            Arrays.fill(used, false);
            int usedCount = 0;
            while (usedCount < n) {
                result++;
                int lastWeight = -1, lastLength = -1;
                for (int j = 0; j < n; j++) {
                    if (used[j]) {
                        continue;
                    }
                    if (lastLength < 0) {
                        lastLength = woods[j].l;
                        lastWeight = woods[j].w;
                        used[j] = true;
                        usedCount++;
                    } else {
                        if (lastLength <= woods[j].l && lastWeight <= woods[j].w) {
                            used[j] = true;
                            lastLength = woods[j].l;
                            lastWeight = woods[j].w;
                            usedCount++;
                        } 
                    }
                }
            }
            System.out.println(result);
        }
        scan.close();
    }
    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
