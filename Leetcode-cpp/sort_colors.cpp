class Solution {
public:
    void sortColors(vector<int>& nums) {
        int redPos = 0, currentPos = -1, bluePos = nums.size() - 1;
        while (++currentPos <= bluePos) {
            if (nums[currentPos] == 0) {
                swap(nums[redPos++], nums[currentPos]);
            } else if (nums[currentPos] == 2) {
                swap(nums[bluePos--], nums[currentPos--]);
            }
        }
    }
};