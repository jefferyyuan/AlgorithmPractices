/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* fakeHead = new ListNode(0);
        ListNode* current = fakeHead;
        while (l1 != nullptr || l2 != nullptr) {
            if (l1 == nullptr || (l2 != nullptr && l1->val > l2->val)) {
                current->next = l2;
                l2 = l2->next;
                current = current->next;
            } else {
                current->next = l1;
                l1 = l1->next;
                current = current->next;
            }
        }
        return fakeHead->next;
    }
};