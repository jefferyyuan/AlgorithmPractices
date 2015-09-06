class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        //next_permutation(nums.begin(), nums.end());
        my_next_permutation(nums);
    }
    
    bool my_next_permutation(vector<int>& nums) {
        int current_index = nums.size() - 1;
        while (current_index > 0 && nums[current_index - 1] >= nums[current_index])
            current_index--;
        if (current_index == 0) {
            sort(nums.begin(), nums.end());
            return false;
        }
        int swap_index = nums.size() - 1;
        while (swap_index >= current_index && nums[swap_index] <= nums[current_index - 1])
            swap_index--;
        int temp = nums[swap_index];
        nums[swap_index] = nums[current_index - 1];
        nums[current_index - 1] = temp;
        sort(nums.begin() + current_index, nums.end());
        return true;
    }
};