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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if (root == nullptr) return result;
        queue<TreeNode*> record;
        record.push(root);
        int count = 1;
        while (count > 0) {
            int newCount = 0;
            result.push_back(record.front()->val);
            while (count > 0) {
                TreeNode* current = record.front();
                record.pop();
                if (current->right != nullptr) {
                    record.push(current->right);
                    newCount++;
                }
                if (current->left != nullptr) {
                    record.push(current->left);
                    newCount++;
                }
                count--;
            }
            count = newCount;
        }
        return result;
    }
};