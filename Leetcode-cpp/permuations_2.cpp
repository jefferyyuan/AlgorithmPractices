class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        do {
            vector<int> temp_result(nums.begin(), nums.end());
            result.push_back(temp_result);
        } while (next_permutation(nums.begin(), nums.end()));
        return result;
    }
};