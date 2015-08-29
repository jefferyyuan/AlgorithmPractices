class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        return findPeakElement(nums, 0, nums.size() - 1);
    }
    int findPeakElement(vector<int>& nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) return startIndex;
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] < nums[startIndex])
            return findPeakElement(nums, startIndex, midIndex);
        if (nums[midIndex] < nums[endIndex] || nums[midIndex + 1] > nums[midIndex])
            return findPeakElement(nums, midIndex + 1, endIndex);
        return findPeakElement(nums, startIndex, midIndex);
    }
};