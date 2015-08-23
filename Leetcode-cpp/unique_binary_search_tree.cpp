class Solution {
 public:
  int numTrees(int n) {
    int record[n + 1] = {};
    record[0] = 1;
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        record[i] += record[j - 1] * record[i - j];
      }
    }
    return record[n];
  }
};