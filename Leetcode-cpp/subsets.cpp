class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        vector<bool> record(nums.size(), false);
        search(result, record, nums, 0);
        return result;
    }
    
    void search(vector<vector<int>>& result, vector<bool>& record, vector<int>& nums, int index) {
        if (index == nums.size()) {
            vector<int> tempResult;
            for (int i = 0; i < record.size(); ++i) {
                if (record[i]) tempResult.push_back(nums[i]);
            }
            result.push_back(tempResult);
        } else {
            search(result, record, nums, index + 1);
            record[index] = true;
            search(result, record, nums, index + 1);
            record[index] = false;
        }
    }
};