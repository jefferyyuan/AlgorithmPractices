class Solution {
public:
    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> result;
        nums.push_back(upper + 1);
        lower--;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] - lower == 2) {
                result.push_back(to_string(lower + 1));
            } else if (nums[i] - lower > 2) {
                result.push_back(to_string(lower + 1) + "->" + to_string(nums[i] - 1));
            }
            lower = max(lower, nums[i]);
        }
        nums.erase(nums.end() - 1);
        return result;
    }
};