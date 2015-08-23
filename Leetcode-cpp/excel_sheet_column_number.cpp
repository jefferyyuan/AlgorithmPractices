class Solution {
 public:
  int titleToNumber(string s) {
    int result_raw = 0;
    int result_offset = 0;
    int offset = 1;
    for (int i = 0; i < s.length(); ++i) {
      result_raw = 26 * result_raw + s[i] - 'A';
      result_offset += offset;
      offset *= 26;
    }
    return result_raw + result_offset;
  }
};