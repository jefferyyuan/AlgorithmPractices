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
    int maxPathSum(TreeNode* root) {
        return search(root).first;
    }
    
    pair<int, int> search(TreeNode* root) {
        if (root == nullptr) return make_pair(INT_MIN, 0);
        auto left = search(root->left);
        auto right = search(root->right);
        int opt_path = root->val + max(0, max(left.second, right.second));
        int opt_sum = root->val + max(0, left.second) + max(0, right.second);
        opt_sum = max(opt_sum, left.first);
        opt_sum = max(opt_sum, right.first);
        return make_pair(opt_sum, opt_path);
    }
    
};