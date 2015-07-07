/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 #include <stack>
class Solution {
public:
    vector<int> preorderTraversal(TreeNode *root) {
        stack<TreeNode *> record;
        vector<int> result;
        record.push(root);
        while(!record.empty())
        {
            TreeNode *temp = record.top();
            record.pop();
            if(temp == NULL) continue;
            result.push_back(temp->val);
            record.push(temp->right);
            record.push(temp->left);
        }
        return result;
    }
};
