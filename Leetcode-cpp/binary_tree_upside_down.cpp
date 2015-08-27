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
    TreeNode* upsideDownBinaryTree(TreeNode* root) {
        stack<TreeNode*> record;
        while (root != nullptr) {
            record.push(root);
            root = root->left;
        }
        TreeNode* result = nullptr;
        TreeNode* preRoot = nullptr;
        while (!record.empty()) {
            TreeNode* current = record.top();
            record.pop();
            if (result == nullptr) {
                result = current;
            }
            if (preRoot != nullptr) {
                preRoot->left = current->right;
                preRoot->right = current;
            }
            preRoot = current;
            preRoot ->left = nullptr;
            preRoot ->right = nullptr;
        }
        
        return result;
        
    }
};