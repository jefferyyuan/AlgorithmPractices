class Solution {
public:
    int search(vector<int>& nums, int target) {
        return search(nums, 0, nums.size() - 1, target);
    }
    int search(vector<int>& nums, int start, int end, int target) {
        if (start > end) return -1;
        if (start == end) return nums[start] == target ? start : -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= nums[start]) {
            if (target < nums[mid] && target >= nums[start]) {
                return search(nums, start, mid - 1, target);
            } else {
                return search(nums, mid + 1, end, target);
            }
        } else {
            if (target > nums[mid] && target < nums[start]) {
                return search(nums, mid + 1, end, target);
            } else {
                return search(nums, start, mid - 1, target);
            }
        }
    }
};