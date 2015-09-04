class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        if (nums.size() == 1) return nums[0];
        if (nums.size() == 2) return max(nums[0], nums[1]);
        vector<int> nums_1(nums.begin() + 1, nums.end());
        int val_1 = rob_1(nums_1);
        vector<int> nums_2(nums.begin() + 2, nums.end() - 1);
        int val_2 = rob_1(nums_2) + nums[0];
        return max(val_1, val_2);
    }
    
    int rob_1(vector<int>& nums) {
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