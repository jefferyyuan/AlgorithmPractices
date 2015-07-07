/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isBalanced(TreeNode *root) {
        if(root == NULL) return true;
        else
        {
            int leftDepth = Depth(root->left);
            int rightDepth = Depth(root->right);
            return abs(leftDepth - rightDepth) <= 1 && isBalanced(root->left) && isBalanced(root->right);
        }
    }
    int Depth(TreeNode *root)
    {
        if(root == NULL) return 0;
        int leftDepth = Depth(root->left);
        int rightDepth = Depth(root->right);
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }
};
