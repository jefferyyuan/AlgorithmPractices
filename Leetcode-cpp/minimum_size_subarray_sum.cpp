class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int result = INT_MAX;
        int current = 0, start = 0, end = -1;
        while (end < (int)nums.size()) {
            while (current < s && end < (int)nums.size()) current += nums[++end];
            if (end >= (int)nums.size()) break;
            while (start <= end && current >= s) current -= nums[start++];
            result = min(result, end - start + 2);
        }
        if (result == INT_MAX) result = 0;
        return result;
    }
};