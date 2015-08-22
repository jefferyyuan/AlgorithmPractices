class Solution {
 public:
  int singleNumber(vector<int>& nums) {
    int result = 1;
    for (auto num : nums) {
      result ^= num;
    }
    return result ^ 1;
  }
};