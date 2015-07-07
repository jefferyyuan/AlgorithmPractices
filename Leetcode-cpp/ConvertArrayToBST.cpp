/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *sortedArrayToBST(vector<int> &num) {
        return sortedArrayToBSTSingle(num,0, num.size() - 1);
    }
    TreeNode *sortedArrayToBSTSingle(vector<int> &num,int start,int end)
    {
        if(start > end)
        {
            return NULL;
        }
        else if(start == end)
        {
            TreeNode *tempNode = new TreeNode(num[start]);
            return tempNode;
        }
        else
        {
            int mid = (start + end) / 2;
            TreeNode *tempNode = new TreeNode(num[mid]);
            tempNode->left = sortedArrayToBSTSingle(num,start,mid - 1);
            tempNode->right = sortedArrayToBSTSingle(num,mid + 1, end);
            return tempNode;
        }
    }
};
