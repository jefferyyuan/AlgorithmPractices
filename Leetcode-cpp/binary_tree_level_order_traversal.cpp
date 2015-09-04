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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (root == nullptr) return result;
        queue<TreeNode*> record;
        record.push(root);
        int count = 1;
        while (!record.empty()) {
            vector<int> temp_result;
            int new_count = 0;
            while (count > 0) {
                TreeNode* temp_node = record.front();
                count--;
                record.pop();
                temp_result.push_back(temp_node->val);
                if (temp_node->left != nullptr) {
                    new_count++;
                    record.push(temp_node->left);
                }
                if (temp_node->right != nullptr) {
                    new_count++;
                    record.push(temp_node->right);
                }
            }
            result.push_back(temp_result);
            count = new_count;
        }
        return result;
    }
};