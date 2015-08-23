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
  vector<int> inorderTraversal(TreeNode* root) {
    vector<int> result;
    stack<TreeNode*> nodeStack;
    while (root != nullptr) {
      nodeStack.push(root);
      root = root->left;
    }
    while (!nodeStack.empty()) {
      TreeNode* tempNode = nodeStack.top();
      nodeStack.pop();
      result.push_back(tempNode->val);
      tempNode = tempNode->right;
      while (tempNode != nullptr) {
        nodeStack.push(tempNode);
        tempNode = tempNode->left;
      }
    }
    return result;
  }
};