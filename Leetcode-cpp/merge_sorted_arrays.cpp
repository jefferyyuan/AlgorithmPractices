class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        m--;
        n--;
        for (int i = m + n + 1; i >= 0; --i) {
            if (m < 0 || (n >= 0 && nums1[m] < nums2[n])) {
                nums1[i] = nums2[n--];
            } else {
                nums1[i] = nums1[m--];
            }
        }
    }
};