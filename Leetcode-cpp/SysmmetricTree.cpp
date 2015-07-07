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
    bool isSymmetric(TreeNode *root) {
        if(root == NULL) return true;
        else return isSymmetricSingle(root->left,root->right);
    }
    bool isSymmetricSingle(TreeNode *tleft,TreeNode *tright)
    {
        if(tleft == NULL || tright == NULL) return tleft == NULL && tright == NULL;
        else
        {
            return tleft->val == tright->val && isSymmetricSingle(tleft->left,tright->right) && isSymmetricSingle(tleft->right,tright->left);
        }
    }
};
