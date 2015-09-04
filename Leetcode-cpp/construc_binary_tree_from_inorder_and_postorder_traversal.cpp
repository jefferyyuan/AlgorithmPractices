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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return buildTree(inorder, 0 , inorder.size()- 1, postorder, 0, postorder.size() - 1);
    }
    
    TreeNode* buildTree(vector<int>& inorder, int i_start, int i_end, vector<int>& postorder, int p_start, int p_end) {
        if (i_start > i_end) return nullptr;
        if (i_start == i_end) return new TreeNode(inorder[i_start]);
        int index = i_end;
        while (index >= i_start && inorder[index] != postorder[p_end]) index--;
        TreeNode* root = new TreeNode(postorder[p_end]);
        root->left = buildTree(inorder, i_start, index - 1, postorder, p_start, p_start + (index - 1 - i_start));
        root->right = buildTree(inorder, index + 1, i_end, postorder,  p_end - 1 - (i_end - index - 1), p_end - 1);
        return root;
    }
};