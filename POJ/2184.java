import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public void solve() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] S = new int[N];
        int[] F = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = scan.nextInt();
            F[i] = scan.nextInt();
        }
        int MAX = 100 * 1000;
        int[] record = new int[2 * MAX + 1];
        Arrays.fill(record, Integer.MIN_VALUE);
        record[MAX] = 0;
        for (int i = 0; i < N; i++) {
            if (S[i] >= 0) {
                for (int j = record.length - 1; j >= 0; j--) {
                    if (record[j] == Integer.MIN_VALUE) {
                        continue;
                    }
                    record[j + S[i]] = Math.max(record[j + S[i]], record[j] + F[i]);
                }
            } else {
                for (int j = 0; j < record.length; j++) {
                    if (record[j] == Integer.MIN_VALUE) {
                        continue;
                    }
                    record[j + S[i]] = Math.max(record[j + S[i]], record[j] + F[i]);
                }
            }
        }
        int result = 0;
        for (int i = MAX; i < record.length; i++) {
            if (record[i] >= 0) {
                result = Math.max(result, record[i] + i - MAX); 
            }
        }
        System.out.println(result);
        scan.close();
    }
    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
