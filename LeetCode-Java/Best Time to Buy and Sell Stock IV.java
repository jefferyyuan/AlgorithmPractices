public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        List<Integer> start = new ArrayList<Integer>();
        List<Integer> end = new ArrayList<Integer>();
        int index = 0;
        while (index < prices.length) {
            while(index + 1 < prices.length && prices[index + 1] <= prices[index]) {
                index++;
            }
            int newIndex = index + 1;
            while (newIndex < prices.length && prices[newIndex] >= prices[newIndex - 1]) {
                newIndex++;
            }
            if( newIndex - 1 > index && prices[newIndex - 1] > prices[index]) {
                start.add(prices[index]);
                end.add(prices[newIndex - 1]);
            }
            index = newIndex;
        }
        if(k >= start.size()) {
			int result = 0;
			for (int i = 0; i < start.size(); i++) {
				result += end.get(i) - start.get(i);
			}
			return result;
		}
        int[][][] record = new int[2][k + 1][start.size()];
        for (int i = 0; i <= k; i++) {
            record[0][i][start.size() - 1] = 0;
            record[1][i][start.size() - 1] = end.get(end.size() - 1) - start.get(start.size() - 1);
        }
        record[1][0][start.size() - 1] = 0;
        
        for (int i = start.size() - 2; i>= 0; i--) {
            record[0][0][i] = 0;
            record[1][0][i] = 0;
            for (int j = 1; j <= k; j++) {
                record[0][j][i] = Math.max(record[0][j][i + 1], record[1][j][i + 1]);
                record[1][j][i] = record[0][j - 1][i] + end.get(i) - start.get(i);
                record[1][j][i] = Math.max(record[1][j][i], start.get(i + 1) - start.get(i) + record[1][j][i + 1]);
            }
        }
        return Math.max(record[0][k][0], record[1][k][0]);
    }
}