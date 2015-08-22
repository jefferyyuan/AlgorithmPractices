class Solution {
 public:
  vector<int> twoSum(vector<int>& numbers, int target) {
    int startIndex{0};
    int endIndex{numbers.size() - 1};
    vector<int> resultVector(2);
    while (startIndex < endIndex) {
      int tempResult = numbers[startIndex] + numbers[endIndex];
      if (tempResult == target) {
        resultVector[0] = startIndex + 1;
        resultVector[1] = endIndex + 1;
        break;
      }
      if (tempResult < target)
        ++startIndex;
      else
        --endIndex;
    }
    return resultVector;
  }
};