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
    bool isValidBST(TreeNode* root) {
        auto range = make_pair(root, root);
        return is_valid(root, range);
    }
    
    bool is_valid(TreeNode* root, pair<TreeNode*, TreeNode*>& range) {
        if (root == nullptr) {
            range.first = nullptr;
            range.second = nullptr;
            return true;
        }
        if (!is_valid(root->left, range)) return false;
        if (range.second != nullptr && root->val <= range.second->val) return false;
        TreeNode* head = range.first;
        if (head == nullptr) head = root;
        if (!is_valid(root->right, range)) return false;
        if (range.first != nullptr && root->val >= range.first->val) return false;
        TreeNode* tail = range.second;
        if (tail == nullptr) tail = root;
        range.first = head;
        range.second = tail;
        return true;
    }
};