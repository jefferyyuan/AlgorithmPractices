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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }
    
    TreeNode* buildTree(vector<int>& preorder, int p_start, int p_end, vector<int>& inorder, int i_start, int i_end) {
        if (p_start > p_end) return nullptr;
        if (p_start == p_end) return new TreeNode(preorder[p_start]);
        int i_index = i_start, p_index = p_start + 1;
        while (i_index <= i_end && inorder[i_index] != preorder[p_start]) {
            i_index++;
            p_index++;
        }
        TreeNode* root = new TreeNode(preorder[p_start]);
        root->left = buildTree(preorder, p_start + 1, p_index - 1, inorder, i_start, i_index - 1);
        root->right = buildTree(preorder, p_index, p_end, inorder, i_index + 1, i_end);
        return root;
    }
};