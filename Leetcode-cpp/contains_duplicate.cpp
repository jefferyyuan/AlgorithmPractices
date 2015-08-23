class Solution {
 public:
  bool containsDuplicate(vector<int>& nums) {
    unordered_set<int> record;
    for (auto num : nums) {
      if (record.find(num) != record.end()) return true;
      record.insert(num);
    }
    return false;
  }
};