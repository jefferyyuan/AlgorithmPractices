// reference: http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/

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
    vector<int> inorderTraversal(TreeNode *root) {
        stack<TreeNode *> record;
        vector<int> result;
        if(root == NULL) return result;
        record.push(root);
        root = root->left;
        while(!record.empty())
        {
           while(root != NULL)
           {
               record.push(root);
               root = root->left;
           }
           TreeNode *temp = record.top();
           record.pop();
           result.push_back(temp->val);
           if(temp->right != NULL)
           {
               root = temp->right;
               record.push(root);
               root = root->left;
           }
        }
        return result;
    }
};
