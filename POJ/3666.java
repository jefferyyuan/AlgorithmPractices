import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public void solve() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = scan.nextInt();
        }
        int[] sorted = input.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            index.put(sorted[i], i);
        }
        int[][] record = new int[N][N];
        for (int i = 0; i < N; i++) {
            record[0][i] = Math.abs(sorted[i] - input[0]);
        }
        int[][] mi = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                record[i][j] = Math.abs(input[i] - sorted[j]);
                if (i > 0) {
                    record[i][j] += mi[i - 1][j];
                }
                mi[i][j] = record[i][j];
                if (j > 0) {
                    mi[i][j] = Math.min(mi[i][j], mi[i][j - 1]);
                }
            }
        }
        System.out.println(mi[N - 1][N - 1]);
        scan.close();
    }
    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
