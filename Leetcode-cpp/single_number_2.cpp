class Solution {
 public:
  int singleNumber(vector<int>& nums) {
    int oldx1 = 0, x1 = 0, oldx2 = 0, x2 = 0;
    for (auto y : nums) {
      x1 = (oldx1 & (~y)) | ((~oldx1) & (~oldx2) & y);
      x2 = (oldx1 & y & (~oldx2)) | ((~oldx1) & (~y) & (oldx2));
      oldx1 = x1;
      oldx2 = x2;
    }
    return x1;
  }
};