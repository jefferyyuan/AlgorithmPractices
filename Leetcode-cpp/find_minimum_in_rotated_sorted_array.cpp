class Solution {
public:
    int findMin(vector<int>& nums) {
        return findMin(nums, 0, nums.size() - 1);
    }
    
    int findMin(vector<int>& nums, int startIndex, int endIndex) {
        if (nums[startIndex] <= nums[endIndex]) return nums[startIndex];
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] >= nums[startIndex])
            return findMin(nums, midIndex + 1, endIndex);
        else
            return findMin(nums, startIndex, midIndex);
    }
};