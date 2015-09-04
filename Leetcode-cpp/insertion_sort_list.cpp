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
    ListNode* insertionSortList(ListNode* head) {
        ListNode* fakeHead = new ListNode(-1);
        while (head != nullptr) {
            ListNode* current = fakeHead;
            while (current->next != nullptr && current->next->val <= head->val) current = current->next;
            ListNode* pre_next = current->next;
            current->next = head;
            head = head->next;
            current->next->next = pre_next;
        }
        return fakeHead->next;
    }
};