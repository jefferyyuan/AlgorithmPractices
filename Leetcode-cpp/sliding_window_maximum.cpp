class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        list<int> record;
        vector<int> result;
        if (nums.size() == 0 || k <= 0) return result;
        for (int i = 0; i < nums.size(); i++) {
            while (!record.empty() && nums[record.back()] <= nums[i]) record.pop_back();
            record.push_back(i);
            if (record.front() <= i - k) record.pop_front();
            if (i >= k - 1) result.push_back(nums[record.front()]);
        }
        return result;
    }
};