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
        auto result = lcaHelper(root, p, q);
        return result.first;
    }
    
    pair<TreeNode*, int> lcaHelper(TreeNode *root, TreeNode* p, TreeNode *q) {
        if (root == nullptr) 
            return make_pair(nullptr, 0);
        int count = 0;
        if (root == p || root == q) ++count;
        auto leftResult = lcaHelper(root->left, p, q);
        if (leftResult.first != nullptr)
            return leftResult;
        auto rightResult = lcaHelper(root->right, p, q);
        if (rightResult.first != nullptr)
            return rightResult;
        count += leftResult.second + rightResult.second;
        if (count == 2)
            return make_pair(root, count);
        else
            return make_pair(nullptr, count);
        
    }
};