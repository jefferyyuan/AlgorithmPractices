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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        list<TreeNode*> record;
        if (root == nullptr) return result;
        int count = 1;
        record.push_back(root);
        bool is_forward = false;
        while (!record.empty()) {
            is_forward = !is_forward;
            vector<int> temp_result;
            int new_count = 0;
            while (count > 0) {
                if (is_forward) {
                    TreeNode* current = record.front();
                    record.pop_front();
                    count--;
                    temp_result.push_back(current->val);
                    if (current->left != nullptr) {
                        record.push_back(current->left);
                        new_count++;
                    }
                    if (current->right != nullptr) {
                        record.push_back(current->right);
                        new_count++;
                    }
                } else {
                    TreeNode* current = record.back();
                    record.pop_back();
                    count--;
                    temp_result.push_back(current->val);
                    if (current->right != nullptr) {
                        record.push_front(current->right);
                        new_count++;
                    }
                    if (current->left != nullptr) {
                        record.push_front(current->left);
                        new_count++;
                    }
                }
            }
            result.push_back(temp_result);
            count = new_count;
        }
        return result;
    }
};