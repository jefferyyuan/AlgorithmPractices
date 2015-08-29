class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> clone_nums(nums);
        sort(clone_nums.begin(), clone_nums.end());
        vector<vector<int>> result;
        result.push_back(vector<int>(clone_nums));
        while (true) {
            int changeIndex = clone_nums.size() - 1;
            while (changeIndex > 0 && clone_nums[changeIndex - 1] >= clone_nums[changeIndex]) --changeIndex;
            if (changeIndex == 0) break;
            int swapIndex = changeIndex;
            while (swapIndex < clone_nums.size() && clone_nums[swapIndex] > clone_nums[changeIndex - 1]) ++swapIndex;
            swap(clone_nums[changeIndex - 1], clone_nums[swapIndex - 1]);
            sort(clone_nums.begin() + changeIndex, clone_nums.end());
            result.push_back(vector<int>(clone_nums));
        }
        return result;
    }
};