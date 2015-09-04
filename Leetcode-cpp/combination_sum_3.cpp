class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<bool> record(9, false);
        vector<vector<int>> result;
        helper(result, record, 0, k, n);
        return result;
    }
    
    void helper(vector<vector<int>>& result, vector<bool>& record, int currentIndex, int k, int n) {
        if (n < 0 || k < 0) return;
        if (n == 0 && k == 0) {
            vector<int> tempResult;
            for (int i = 0; i < record.size(); ++i) {
                if (record[i]) tempResult.push_back(i + 1);
            }
            result.push_back(tempResult);
        } else if ((currentIndex + 1) > n) {
            return;
        } else if (currentIndex < record.size()) {
            helper(result, record, currentIndex + 1, k, n);
            record[currentIndex] = true;
            helper(result, record, currentIndex + 1, k - 1, n - (currentIndex + 1));
            record[currentIndex] = false;
        }
    }
};