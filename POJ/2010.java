import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public class Calf {
        int csat;
        int aid;
        public Calf (int t_csat, int t_aid) {
            csat = t_csat;
            aid = t_aid;
        }
    }
    public void solve() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int C = scan.nextInt();
        int F = scan.nextInt();
        Calf[] calfList = new Calf[C];
        for (int i = 0; i < C; i++) {
            calfList[i] = new Calf(scan.nextInt(), scan.nextInt());
        }
        PriorityQueue<Calf> q = new PriorityQueue<Calf>((N - 1) / 2,
            new Comparator<Calf>() {
                public int compare(Calf a, Calf b) {
                    return b.aid - a.aid;
                }
            });
        Arrays.sort(calfList, new Comparator<Calf>() {
            @Override
            public int compare(Calf o1, Calf o2) {
                return o1.csat - o2.csat;
            }
        });
        int midIndex = C - 1 - (N - 1) / 2;
        int[] leftValue = new int[C - (N + 1) / 2];
        for (int i = 0; i < leftValue.length; i++) {
            leftValue[i] = calfList[i].aid;
        }
        Arrays.sort(leftValue);
        int leftSum = 0;
        int leftTail = (N - 1) / 2 - 1;
        for (int i = 0; i <= leftTail; i++) {
            leftSum += leftValue[i];
        }
        int rightSum = 0;
        for (int i = C - 1; i > midIndex; i--) {
            q.offer(calfList[i]);
            rightSum += calfList[i].aid;
        }
        while (midIndex >= (N - 1) / 2 && calfList[midIndex].aid + leftSum + rightSum > F ) {
            Calf tempCalf = calfList[midIndex];
            if (tempCalf.aid < q.peek().aid) {
                Calf oldCalf = q.poll();
                q.add(tempCalf);
                rightSum -= oldCalf.aid;
                rightSum += tempCalf.aid;
            }
            if (tempCalf.aid <= leftValue[leftTail]) {
                leftSum -= tempCalf.aid;
                leftTail++;
                leftSum += leftValue[leftTail];
            }
            midIndex--;
        }
        if (midIndex >= (N - 1) / 2) {
            System.out.println(calfList[midIndex].csat);
        } else {
            System.out.println(-1);
        }
        scan.close();
    }
    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
