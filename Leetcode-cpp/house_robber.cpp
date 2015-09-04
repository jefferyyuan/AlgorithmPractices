class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int not_max = 0;
        int yes_max = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            int temp_not_max = max(not_max, yes_max);
            int temp_yes_max = nums[i] + not_max;
            not_max = temp_not_max;
            yes_max = temp_yes_max;
        }
        return max(not_max, yes_max);
    }
};