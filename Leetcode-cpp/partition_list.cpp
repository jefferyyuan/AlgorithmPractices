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
    ListNode* partition(ListNode* head, int x) {
        ListNode* fake_less = new ListNode(-1);
        ListNode* index_less = fake_less;
        ListNode* fake_greater = new ListNode(-1);
        ListNode* index_greater = fake_greater;
        while (head != nullptr) {
            if (head->val < x) {
                index_less->next = head;
                index_less = head;
            } else {
                index_greater->next = head;
                index_greater = head;
            }
            head = head->next;
        }
        index_less->next = fake_greater->next;
        index_greater->next = nullptr;
        return fake_less->next;
    }
};