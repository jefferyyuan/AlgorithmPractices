class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
       int currentIndex = 0;
       int searchIndex = 0;
       while (searchIndex < nums.size()) {
           while (searchIndex != nums.size() - 1 && nums[searchIndex] == nums[searchIndex + 1]) searchIndex++;
           nums[currentIndex++] = nums[searchIndex++];
       }
       return currentIndex;
    }
};