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
    int kthSmallest(TreeNode* root, int k) {
        bool hasFound = false;
        return kthSmallest(root, k, hasFound);
    }
    
    int kthSmallest(TreeNode* root, int k, bool &hasFound) {
        if (root == nullptr) return 0;
        int lVal = kthSmallest(root->left, k, hasFound);
        if (hasFound) return lVal;
        if (lVal == k - 1) {
            hasFound = true;
            return root->val;
        }
        int rVal = kthSmallest(root->right, k - 1 - lVal, hasFound);
        if (hasFound) return rVal;
        return rVal + 1 + lVal;
    }
};