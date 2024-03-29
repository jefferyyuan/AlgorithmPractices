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
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;
        if (root->left == nullptr && root->right == nullptr) return 1;
        int result = INT_MAX;
        if (root->left != nullptr) {
            result = min(result, minDepth(root->left) + 1);
        }
        if (root->right != nullptr) {
            result = min(result, minDepth(root->right) + 1);
        }
        return result;
    }
};


