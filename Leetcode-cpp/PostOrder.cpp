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
    vector<int> postorderTraversal(TreeNode *root) 
    {
        vector<int> result;
        stack<TreeNode *> treeStack;
        treeStack.push(root);
        while(!treeStack.empty())
        {
            TreeNode *temp = treeStack.top();
            treeStack.pop();
            if(temp == NULL) continue;
            result.push_back(temp ->val);
            if(temp->left != NULL) treeStack.push(temp->left);
            if(temp->right != NULL) treeStack.push(temp->right);
        }
        reverse(result.begin(),result.end());
        return result;
    }
};
