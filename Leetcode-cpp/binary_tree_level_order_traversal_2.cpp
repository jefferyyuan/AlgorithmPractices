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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> result;
        queue<TreeNode*> record;
        record.push(root);
        int count = 1;
        while (count > 0) {
            int newCount = 0;
            vector<int> tempResult;
            while (count > 0) {
                TreeNode* tempNode = record.front();
                record.pop();
                --count;
                if (tempNode != nullptr) {
                    tempResult.push_back(tempNode->val);
                    record.push(tempNode->left);
                    record.push(tempNode->right);
                    newCount += 2;
                }
            }
            if (tempResult.size() != 0) {
                result.push_back(tempResult);
            }
            count = newCount;
        }
        reverse(result.begin(), result.end());
        return result;
    }
};