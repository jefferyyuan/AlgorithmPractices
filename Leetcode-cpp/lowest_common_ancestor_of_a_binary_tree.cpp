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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr) return nullptr;
        bool has_p = false;
        bool has_q = false;
        if (root == p) has_p = true;
        if (root == q) has_q = true;
        TreeNode* l_result = lowestCommonAncestor(root->left, p, q);
        if (l_result != nullptr && l_result != p && l_result != q) return l_result;
        if (l_result == p) has_p = true;
        if (l_result == q) has_q = true;
        TreeNode* r_result = lowestCommonAncestor(root->right, p, q);
        if (r_result != nullptr && r_result != p && r_result != q) return r_result;
        if (r_result == p) has_p = true;
        if (r_result == q) has_q = true;
        if (has_p && has_q) return root;
        if (has_p) return p;
        if (has_q) return q;
        return nullptr;
    }
};