class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int fromStart = 1;
        int fromEnd = 1;
        vector<int> result(nums.size(), 1);
        for (int i = 0; i < nums.size() - 1; ++i) {
            fromStart *= nums[i];
            result[i + 1] *= fromStart;
            fromEnd *= nums[nums.size() - 1 - i];
            result[nums.size() - 1 - i - 1] *= fromEnd;
        }
        return result;
    }
};