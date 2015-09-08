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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int extra = 0;
        ListNode* fake_head = new ListNode(-1);
        ListNode* current = fake_head;
        while (l1 != nullptr || l2 != nullptr || extra != 0) {
            if (l1 != nullptr) {
                extra += l1->val;
                l1 = l1->next;
            }
            if (l2 != nullptr) {
                extra += l2->val;
                l2 = l2->next;
            }
            current->next = new ListNode(extra % 10);
            current = current->next;
            extra /= 10;
        }
        return fake_head->next;
    }
};