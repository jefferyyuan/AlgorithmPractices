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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        postorderTraversal(root, result);
        reverse(result.begin(), result.end());
        return result;
    }
    
    void postorderTraversal(TreeNode* root, vector<int>& result) {
        if (root != nullptr) {
            result.push_back(root->val);
            postorderTraversal(root->right, result);
            postorderTraversal(root->left, result);
        }
    }
};