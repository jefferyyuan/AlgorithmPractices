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
        int count = 0;
        if (root == p || root == q) ++count;
        TreeNode* leftResult = lowestCommonAncestor(root->left, p, q);
        if (judgeCount(leftResult, p, q) == 2) return leftResult;
        count += judgeCount(leftResult, p, q);
        TreeNode* rightResult = lowestCommonAncestor(root->right, p, q);
        if (judgeCount(rightResult, p, q) == 2) return rightResult;
        count += judgeCount(rightResult, p, q);
        if (count == 2) return root;
        if (count == 0) return nullptr;
        if (root == p || leftResult == p || rightResult == p) return p;
        return q;
        
    }
    
    int judgeCount(TreeNode* result, TreeNode* p, TreeNode* q) {
        if (result == p || result == q) return 1;
        if (result == nullptr) return 0;
        return 2;
    }
    
};