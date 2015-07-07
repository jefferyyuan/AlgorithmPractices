// notice the difference of queue in C98 and C11
/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
 #include <queue>
class Solution {
public:
    void connect(TreeLinkNode *root) {
        queue<TreeLinkNode *> record;
        int tail = 1;
        if(root == NULL) return;
        record.push(root);
        while(!record.empty())
        {
            for(int i = 0;i < tail;i ++)
            {
                TreeLinkNode *temp = record.front();
                record.pop();
                if(i != tail - 1)
                {
                    temp->next = record.front();
                }
                if(temp->left != NULL) 
                {
                    record.push(temp->left);
                    record.push(temp->right);
                }
            }
            tail = record.size();
        }
        return;
    }
};
