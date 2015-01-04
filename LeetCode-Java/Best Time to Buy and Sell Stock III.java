public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;
        int[] fromLeft = new int[prices.length];
        int[] fromRight = new int[prices.length];
        
        int maxProfit = 0, minLeft = prices[0];
        fromLeft[0] = 0;
        for(int i = 1;i < prices.length;i ++)
        {
            if(prices[i] > minLeft)
                fromLeft[i] = Math.max(fromLeft[i - 1], prices[i] - minLeft);
            else
            {
                minLeft = prices[i];
                fromLeft[i] = fromLeft[i - 1];
            }
        }
        
        int maxRight = prices[prices.length - 1];
        fromRight[prices.length - 1] = 0;
        for(int i = prices.length - 2;i >= 0;i --)
        {
            if(prices[i] < maxRight)
                fromRight[i] = Math.max(fromRight[i + 1], maxRight - prices[i]);
            else
            {
                maxRight = prices[i];
                fromRight[i] = fromRight[i + 1];
            }
        }
        
        int result = fromRight[0];
        for(int i = 0;i < prices.length - 1;i ++)
        {
            result = Math.max(result, fromLeft[i] + fromRight[i + 1]);
        }
        return result;
    }
}