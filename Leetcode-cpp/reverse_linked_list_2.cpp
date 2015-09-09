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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode* fakeHead = new ListNode(-1);
        fakeHead->next = head;
        int pre_index = m - 1;
        ListNode* pre = fakeHead;
        while (pre_index > 0) {
            pre = pre->next;
            pre_index--;
        }
        ListNode* partHead = nullptr;
        int reverse_count = n - m + 1;
        ListNode* current = pre->next;
        while (reverse_count > 0) {
            reverse_count--;
            ListNode* temp = current->next;
            current->next = partHead;
            partHead = current;
            current  = temp;
        }
        pre->next->next = current;
        pre->next = partHead;
        return fakeHead->next;
        
    }
};