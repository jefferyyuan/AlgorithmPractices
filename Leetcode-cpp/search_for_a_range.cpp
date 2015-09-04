class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int lower_index = lower_bound(nums.begin(), nums.end(), target) - nums.begin();
        int upper_index = upper_bound(nums.begin(), nums.end(), target) - nums.begin();
        if (lower_index == upper_index) {
            lower_index = -1;
            upper_index = 0;
        }
        vector<int> result = {lower_index, upper_index - 1};
        return result;
    }
};