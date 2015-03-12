import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

	public class Coin {
		int value;
		int count;
		public Coin (int t_value, int t_count) {
			value = t_value;
			count = t_count;
		}
	}

	public class CoinComparator implements Comparator<Coin> {
		@Override
		public int compare(Coin o1, Coin o2) {
			// TODO Auto-generated method stub
			return o2.value - o1.value;
		}
	}
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int C = scan.nextInt();
		Coin[] coins = new Coin[N];
		int totalValue = 0;
		for (int i = 0; i < N; i++) {
			coins[i] = new Coin(scan.nextInt(), scan.nextInt());
			totalValue += coins[i].value * coins[i].count;
		}
		Arrays.sort(coins, new CoinComparator());
		int result = 0;
		int startIndex = 0;
		while (startIndex < N && coins[startIndex].value >= C) {
			result += coins[startIndex].count;
			startIndex++;
		}
		int[] need = new int[N];
		
		while (true) {
			Arrays.fill(need, 0);
			int currentValue = C;
			int currentIndex = startIndex;
			while (currentIndex < N && currentValue > 0) {
				int tempCount = Math.min(coins[currentIndex].count, currentValue / coins[currentIndex].value);
				need[currentIndex] = tempCount;
				currentValue -= tempCount * coins[currentIndex].value;
				currentIndex++;
			}
			if (currentValue > 0) {
				currentIndex = N - 1;
				while (currentValue > 0 && currentIndex >= startIndex) {
					int tempCount = Math.min(coins[currentIndex].count - need[currentIndex], 
											currentValue / coins[currentIndex].value + 1);
					need[currentIndex] += tempCount;
					currentValue -= tempCount * coins[currentIndex].value;
					currentIndex--;
				}
			}
			if (currentValue > 0) {
				break;
			}
			int multiTimes = Integer.MAX_VALUE;
			for (int i = startIndex; i < N; i++) {
				if (need[i] == 0) continue;
				multiTimes = Math.min(multiTimes, coins[i].count / need[i]);
			}
			result += multiTimes;
			for (int i = startIndex; i < N; i++) {
				coins[i].count -= multiTimes * need[i];
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