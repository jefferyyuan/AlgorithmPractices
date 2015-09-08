class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int ,int> record;
        for (int i = 0; i < nums.size(); ++i) {
            if (record.find(target - nums[i]) != record.end()) {
                return vector<int> {record[target - nums[i]], i + 1}; 
            }
            record[nums[i]] = i + 1;
        }
    }
};