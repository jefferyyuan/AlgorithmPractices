/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
 public:
  void connect(TreeLinkNode* root) {
    TreeLinkNode* nextRoot = new TreeLinkNode(0);
    TreeLinkNode* nextTail = nextRoot;
    while (root != nullptr) {
      while (root != nullptr) {
        if (root->left != nullptr) {
          nextTail->next = root->left;
          nextTail = nextTail->next;
        }
        if (root->right != nullptr) {
          nextTail->next = root->right;
          nextTail = nextTail->next;
        }
        root = root->next;
      }
      root = nextRoot->next;
      nextRoot->next = nullptr;
      nextTail = nextRoot;
    }
  }
};