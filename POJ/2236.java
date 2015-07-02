import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public class Computer {
        int x, y;
        public Computer(int t_x, int t_y) {
            x = t_x;
            y = t_y;
        }
    }
    int[] parent;

    int getRoot(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            parent[x] = getRoot(parent[x]);
            return parent[x];
        }
    }

    void link(int x, int y) {
        parent[getRoot(x)] = getRoot(y);
        return;
    }

    boolean isUnion(int x, int y) {
        return getRoot(x) == getRoot(y);
    }

    boolean isConnected(Computer o1, Computer o2, int D) {
        int result = (o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
        return result <= D * D;
    }

    public void solve() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int D = scan.nextInt();
        Computer[] list = new Computer[N];
        for (int i = 0; i < N; i++) {
            list[i] = new Computer(scan.nextInt(), scan.nextInt());
        }
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        ArrayList<Integer> activeList = new ArrayList<Integer>();
        while (scan.hasNext()) {
            String command = scan.next();
            if (command.compareTo("O") == 0) {
                int index = scan.nextInt() - 1;
                for (int i = 0; i < activeList.size(); i++) {
                    int oldIndex = activeList.get(i);
                    if (isConnected(list[index], list[oldIndex], D)) {
                        link(index, oldIndex);
                    }
                }
                activeList.add(index);
            } else {
                int index1 = scan.nextInt() - 1;
                int index2 = scan.nextInt() - 1;
                if (isUnion(index1, index2)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAIL");
                }
            }
        }
        scan.close();
    }
    public static void main(String[] args) {
        Main tool = new Main();
        tool.solve();
    }
}
