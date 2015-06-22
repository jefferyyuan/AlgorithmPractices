import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public class Block {
        int h, c, a;
        public Block (int t_h, int t_a, int t_c) {
            h = t_h;
            c = t_c;
            a = t_a;
        }
    }

    public void solve() {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        Block[] input = new Block[K];
        for (int i = 0; i < K; i++) {
            input[i] = new Block(scan.nextInt(), scan.nextInt(), scan.nextInt()); 
        }
        Arrays.sort(input, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                return o1.a - o2.a;
            }
        });
        int[] record = new int[input[K - 1].a + 1];
        Arrays.fill(record, -1);
        for (int i = 0; i < K; i++) {
            record[0] = input[i].c;
            for (int j = 1; j <= input[i].a; j++) {
                if (record[j] >= 0) {
                    record[j] = input[i].c;
                }
                else if (j - input[i].h >= 0 && record[j - input[i].h] > 0) {
                    record[j] = record[j - input[i].h] - 1;
                } else {
                    continue;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= input[K - 1].a; i++) {
            if ( record[i] >= 0) {
               result = i;
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
