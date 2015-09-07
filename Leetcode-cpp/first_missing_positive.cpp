class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] <= 0 || nums[i] - 1 >= nums.size() || nums[i] - 1 == i) continue;
            int temp = nums[i];
            if (nums[temp - 1] == nums[i]) continue;
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;
            i--;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] - 1 != i) return i + 1;
        }
        return nums.size() + 1;
    }
};