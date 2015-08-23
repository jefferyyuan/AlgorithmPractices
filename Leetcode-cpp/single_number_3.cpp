class Solution {
 public:
  vector<int> singleNumber(vector<int>& nums) {
    int result = 0;
    for (auto num : nums) {
      result ^= num;
    }
    result ^= 0;
    int bitCount = 0;
    for (; bitCount < 32; ++bitCount) {
      if ((result & (1 << bitCount)) != 0) break;
    }
    result = 1 << bitCount;
    vector<int> resultList;
    resultList.push_back(0);
    resultList.push_back(0);
    for (auto num : nums) {
      if ((num & result) == 0) {
        resultList[0] ^= num;
      } else {
        resultList[1] ^= num;
      }
    }
    resultList[0] ^= 0;
    resultList[1] ^= 0;
    return resultList;
  }
};