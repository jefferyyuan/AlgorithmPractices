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
    int countNodes(TreeNode* root) {
        int level = 0;
        TreeNode* current = root;
        while (current != nullptr) {
            current = current->left;
            level++;
        }
        if (level <= 1) return level;
        int start = 1;
        int end = 1 << (level - 1);
        while (start < end) {
            current = root;
            int mid = (start + end + 1) / 2;
            if (is_valid(root, mid, level)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return (1 << (level - 1)) - 1 + start;
    }
    
    bool get_bit(int v, int index) {
        return (v & (1 << (index - 1))) != 0;
    }
    
    bool is_valid(TreeNode* root, int index, int level) {
        level--;
        while (level > 0) {
            if (get_bit(index - 1, level)) {
                root = root->right;
            } else {
                root = root->left;
            }
            level--;
        }
        return root != nullptr;
    }
};