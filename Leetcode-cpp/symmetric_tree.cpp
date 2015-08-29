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
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr) return true;
        return isSymmetric(root->left, root->right);
    }
    
    bool isSymmetric(TreeNode* leftRoot, TreeNode* rightRoot) {
        if (leftRoot == nullptr || rightRoot == nullptr)
            return leftRoot == nullptr && rightRoot == nullptr;
        return leftRoot->val == rightRoot->val &&
            isSymmetric(leftRoot->right, rightRoot->left) &&
            isSymmetric(leftRoot->left, rightRoot->right);
        
    }
};