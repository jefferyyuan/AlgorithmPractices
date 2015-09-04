class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int currentIndex = 0;
        int searchIndex = 0;
        while (searchIndex < nums.size()) {
            int tempCount = 1;
            while (searchIndex != nums.size() - 1 && nums[searchIndex] == nums[searchIndex + 1]) {
                searchIndex++;
                tempCount++;
            }
            nums[currentIndex++] = nums[searchIndex];
            if (tempCount > 1)
                nums[currentIndex++] = nums[searchIndex];
            searchIndex++;
        }
        return currentIndex;
    }
};