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
    int sumNumbers(TreeNode* root) {
        return sumNumbersHelper(root, 0);
    }
    int sumNumbersHelper(TreeNode* root, int pre) {
        if (root == nullptr) return 0;
        pre = 10 * pre + root->val;
        if (root->left == nullptr && root->right == nullptr) return pre;
        int result = 0;
        if (root->left != nullptr) result += sumNumbersHelper(root->left, pre);
        if (root->right != nullptr) result += sumNumbersHelper(root->right, pre);
        return result;
    }
};