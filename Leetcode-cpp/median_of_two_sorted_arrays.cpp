class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		int n = nums1.size(), m = nums2.size();
		if ((n + m) % 2 == 1) {
			return (double)search(nums1, 0, n - 1, nums2, 0, m - 1, (n + m + 1) / 2);
		}
		else {
			double v1 = (double)search(nums1, 0, n - 1, nums2, 0, m - 1, (n + m) / 2);
			double v2 = (double)search(nums1, 0, n - 1, nums2, 0, m - 1, (n + m) / 2 + 1);
			return (v1 + v2) / 2;
		}
	}

	int search(vector<int>& nums1, int start1, int end1, vector<int>& nums2, int start2, int end2, int k) {
    	if (k == 0) {
			if (start1 == 0) return nums2[start2 - 1];
			if (start2 == 0) return nums1[start1 - 1];
			return max(nums1[start1 - 1], nums2[start2 - 1]);
		}
		if (start1 > end1) return nums2[start2 + k - 1];
		if (start2 > end2) return nums1[start1 + k - 1];
		int mid1 = min(end1, start1 + k / 2 - 1);
		mid1 = max(mid1, start1);
		int mid2 = min(end2, start2 + k / 2 - 1);
		mid2 = max(mid2, start2);
		if (nums1[mid1] > nums2[mid2]) {
			return search(nums1, start1, end1, nums2, mid2 + 1, end2, k - (mid2 + 1 - start2));
		}
		else {
			return search(nums1, mid1 + 1, end1, nums2, start2, end2, k - (mid1 + 1 - start1));
		}

	}
};