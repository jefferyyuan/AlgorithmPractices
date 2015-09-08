class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int value1 = 0, value2 = 1;
        int count1 = 0, count2 = 0;
        for (int val : nums) {
            if (count1 == 0 && val != value2) value1 = val;
            if (count2 == 0 && val != value1) value2 = val;
            if (val == value1) count1++;
            if (val == value2) count2++;
            if (val != value1 && val != value2) {
                count1--;
                count2--;
            }
        }
        vector<int> result;
        if (count(nums.begin(), nums.end(), value1) > nums.size() / 3) result.push_back(value1);
        if (count(nums.begin(), nums.end(), value2) > nums.size() / 3) result.push_back(value2);
        return result;
    }
};