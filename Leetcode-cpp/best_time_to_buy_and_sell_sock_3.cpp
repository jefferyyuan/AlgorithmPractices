class Solution {
public:
    int maxProfit(vector<int>& prices) {
        vector<int> forward = {0};
        vector<int> backward = {0};
        int min_val = prices[0];
        int opt = 0;
        for (int i = 1; i < prices.size(); ++i) {
            opt = max(opt, prices[i] - min_val);
            forward.push_back(opt);
            min_val = min(min_val, prices[i]);
        }
        
        int max_val = prices[prices.size() - 1];
        opt = 0;
        for (int i = prices.size() - 1; i >= 0; --i) {
            opt = max(opt, max_val - prices[i]);
            backward.push_back(opt);
            max_val = max(max_val, prices[i]);
        }
        int result = 0;
        for (int i = 0; i < prices.size() - 1; ++i) {
            result = max(result, forward[i] + backward[prices.size() - 1 - i - 1]);
        }
        return result;
    }
};