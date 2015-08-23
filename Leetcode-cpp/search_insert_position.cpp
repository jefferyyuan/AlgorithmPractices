class Solution {
 public:
  int searchInsert(vector<int>& nums, int target) {
    int startIndex = 0, endIndex = nums.size();
    while (startIndex < endIndex) {
      int midIndex = (startIndex + endIndex) / 2;
      if (nums[midIndex] == target) {
        return midIndex;
      } else if (nums[midIndex] > target) {
        endIndex = midIndex;
      } else {
        startIndex = midIndex + 1;
      }
    }
    return startIndex;
  }
};