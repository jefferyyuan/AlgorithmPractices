import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public class Cow {
        int min;
        int max;
        public Cow(int t_min, int t_max) {
            min = t_min;
            max = t_max;
        }
    }

    public class SunScreen {
        int spf;
        int cover;
        public SunScreen (int t_spf, int t_cover) {
            spf = t_spf;
            cover = t_cover;
        }
    }
    public void solve() {
        Scanner scan = new Scanner(System.in);
        int C = scan.nextInt();
        int L = scan.nextInt();
        Cow[] cowList = new Cow[C];
        SunScreen[] screenList = new SunScreen[L];
        for (int i = 0; i < C; i++) {
            cowList[i] = new Cow(scan.nextInt(), scan.nextInt());
        }
        for (int i = 0; i < L; i++) {
            screenList[i] = new SunScreen(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(cowList, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                return o1.min - o2.min; 
            }
        });
        Arrays.sort(screenList, new Comparator<SunScreen>() {
            @Override
            public int compare(SunScreen o1, SunScreen o2) {
                return o1.spf - o2.spf;
            }
        });
        PriorityQueue<Cow> q = new PriorityQueue<Cow>(C,
            new Comparator<Cow>() {
                public int compare(Cow a, Cow b) {
                    return a.max - b.max;
                }
            });
        int cowIndex = 0;
        int result = 0;
        for (int i = 0; i < screenList.length; i++) {
            while (cowIndex < C && cowList[cowIndex].min <= screenList[i].spf) {
                q.offer(cowList[cowIndex]);
                cowIndex++;
            }
            while (q.size() != 0 && screenList[i].cover > 0) {
                Cow tempCow = q.poll();
                if (tempCow.max < screenList[i].spf) {
                    continue;
                }
                result++;
                screenList[i].cover--;
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
