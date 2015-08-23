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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* sentinel {new ListNode(0)};
        ListNode* pre = sentinel;
        while (head != nullptr) {
            ListNode* nextElement = head->next;
            while (nextElement != nullptr && nextElement->val == head->val) {
                nextElement = nextElement->next;
            }
            pre->next = head;
            pre = head;
            head->next = nextElement;
            head = nextElement;
        }
        return sentinel->next;
    }
};