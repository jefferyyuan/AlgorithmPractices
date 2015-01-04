public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 0) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 1;i < prices.length;i ++)
        {
            if(prices[i] > min)
            {
                int tempProfit = prices[i] - min;
                maxProfit = Math.max(maxProfit, tempProfit);
            }
            else
            {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}