class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int resultIndex = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] != val)
                swap(nums[resultIndex++], nums[i]);
        }
        return resultIndex;
    }
};