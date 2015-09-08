class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        for (int i = 0; i < nums.size(); ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int startIndex = i + 1, endIndex = nums.size() - 1;
            while (startIndex < endIndex) {
                int sum = nums[i] + nums[startIndex] + nums[endIndex];
                if (sum < 0) {
                    startIndex++;
                } else if (sum > 0) {
                    endIndex--;
                } else {
                    vector<int> temp_result = {nums[i], nums[startIndex], nums[endIndex]};
                    result.push_back(temp_result);
                    startIndex++;
                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex - 1]) startIndex++;
                }
            }
        }
        return result;
    }
};