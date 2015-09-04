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
    vector<TreeNode*> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    vector<TreeNode*> generateTrees(int startIndex, int endIndex) {
        vector<TreeNode*> result;
        if (startIndex > endIndex) result.push_back(nullptr);
        else {
            for (int i = startIndex; i <= endIndex; ++i) {
                vector<TreeNode*> lResult = generateTrees(startIndex, i - 1);
                for (int j = 0; j < lResult.size(); ++j) {
                    vector<TreeNode*> rResult = generateTrees(i + 1, endIndex);
                    for (int k = 0; k < rResult.size(); ++k) {
                        TreeNode* root = new TreeNode(i);
                        root->left = lResult[j];
                        root->right= rResult[k];
                        result.push_back(root);
                    }
                }
            }
        }
        return result;
    }
};