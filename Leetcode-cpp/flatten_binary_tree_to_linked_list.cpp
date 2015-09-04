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
    void flatten(TreeNode* root) {
        flattenHelper(root);
    }
    
    TreeNode* flattenHelper(TreeNode* root) {
        if (root == nullptr || (root->left == nullptr && root->right == nullptr)) return root;
        TreeNode* rChild = root->right;
        if (root->left != nullptr) {
            root->right = root->left;
            root->left = nullptr;
            TreeNode* lResult = flattenHelper(root->right);
            if (rChild == nullptr) return lResult;
            lResult->right = rChild;
        } 
        return flattenHelper(rChild);
    }
};