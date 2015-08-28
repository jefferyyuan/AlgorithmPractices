class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) return 0;
        int preMin = prices[0];
        int globalMax = 0;
        for (int i = 1; i < prices.size(); ++i) {
            globalMax = max(globalMax, prices[i] - preMin);
            preMin = min(preMin, prices[i]);
        }
        return globalMax;
    }
};