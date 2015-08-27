class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int preMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            preMax = preMax > 0 ? (preMax + nums[i]) : nums[i];
            globalMax = max(preMax, globalMax);
        }
        return globalMax;
    }
};