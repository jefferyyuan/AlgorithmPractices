/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return sortedArrayToBST(nums, 0, nums.size() - 1);
    }
    TreeNode* sortedArrayToBST(vector<int>& nums, int beginIndex, int endIndex) {
        if (beginIndex > endIndex)
            return nullptr;
        if (beginIndex == endIndex)
            return new TreeNode(nums[beginIndex]);
        int midIndex = (beginIndex + endIndex) / 2;
        TreeNode* root = new TreeNode(nums[midIndex]);
        root->left = sortedArrayToBST(nums, beginIndex, midIndex - 1);
        root->right = sortedArrayToBST(nums, midIndex + 1, endIndex);
        return root;
    }
};