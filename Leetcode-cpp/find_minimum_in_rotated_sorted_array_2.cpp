class Solution {
public:
    int findMin(vector<int>& nums) {
        return findMin(nums, 0, nums.size() - 1);
    }
    
    int findMin(vector<int>& nums, int startIndex, int endIndex) {
        if (startIndex == endIndex || nums[startIndex] < nums[endIndex])
            return nums[startIndex];
        int midIndex = (startIndex + endIndex) / 2;
        if (nums[midIndex] > nums[startIndex]) {
            return findMin(nums, midIndex + 1, endIndex);
        } else if (nums[midIndex] < nums[startIndex]) {
            return findMin(nums, startIndex, midIndex);
        } else {
            return min(findMin(nums, startIndex, midIndex), findMin(nums, midIndex + 1, endIndex));
        }
    }
};