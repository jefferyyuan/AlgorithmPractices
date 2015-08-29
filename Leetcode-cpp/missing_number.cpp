class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int currentIndex = 0;
        while (currentIndex < nums.size()) {
            if (nums[currentIndex] != currentIndex && nums[currentIndex] != nums.size()) {
                swap(nums[currentIndex], nums[nums[currentIndex]]);
            } else {
                currentIndex++;
            }
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != i) return i;
        }
        return nums.size();
    }
};