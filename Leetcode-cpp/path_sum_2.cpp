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
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> result;
        vector<int> record;
        search(root, result, record, sum);
        return result;
    }
    
    void search(TreeNode* root, vector<vector<int>>& result, vector<int>& record, int sum) {
        if (root != nullptr && root->left == nullptr && root->right == nullptr && sum == root->val) {
            record.push_back(root->val);
            vector<int> temp_result(record.begin(), record.end());
            result.push_back(temp_result);
            record.erase(record.end() - 1);
        } else if (root != nullptr) {
            sum -= root->val;
            record.push_back(root->val);
            if (root->left != nullptr) search(root->left, result, record, sum);
            if (root->right != nullptr) search(root->right, result, record, sum);
            record.erase(record.end() - 1);
        }
    }
};