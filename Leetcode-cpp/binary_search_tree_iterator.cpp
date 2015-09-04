/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
private:
    stack<TreeNode*> record;
public:
    BSTIterator(TreeNode *root) {
        while (root != nullptr) {
            record.push(root);
            root = root->left;
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !record.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode* current = record.top();
        record.pop();
        int result = current->val;
        current = current->right;
        while (current != nullptr) {
            record.push(current);
            current = current->left;
        }
        return result;
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */