class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); ++i) {
            int start = i + 1, end = nums.size() - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (abs(sum - target) < abs(result - target)) result = sum;
                if (sum < target) {
                    ++start;
                } else if (sum > target) {
                    --end;
                } else {
                    return sum;
                }
            }
        }
        return result;
    }
};