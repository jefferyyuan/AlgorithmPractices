class Solution {
public:
    bool canJump(vector<int>& nums) {
        int global_max = 0, start = 0;
        while (start <= global_max && global_max < nums.size() - 1) {
            global_max = max(global_max, start + nums[start]);
            start++;
        }
        return global_max >= nums.size() - 1;
    }
};