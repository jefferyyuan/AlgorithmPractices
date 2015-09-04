class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        map<int, int> record;
        vector<vector<int>> result;
        vector<int> tempResult;
        search(result, candidates, tempResult, 0, target);
        return result;
    }
    void search(vector<vector<int>>& result, vector<int>& candidates, vector<int>& tempResult, int index, int target) {
        if (target == 0) {
            vector<int> currentResult(tempResult.begin(), tempResult.end());
            result.push_back(currentResult);
        } else if (target > 0 && index < candidates.size()) {
            int val = candidates[index];
            int pre_size = tempResult.size();
            while (target >= 0) {
                search(result, candidates, tempResult, index + 1, target);
                tempResult.push_back(val);
                target -= val;
            }
            int after_size = tempResult.size();
            tempResult.erase(tempResult.begin() + pre_size, tempResult.begin() + after_size);
        }
    }
};