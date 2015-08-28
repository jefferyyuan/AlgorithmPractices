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
    ListNode* swapPairs(ListNode* head) {
        ListNode* pre = new ListNode(0);
        ListNode* current = head;
        ListNode* result = pre;
        while (current != nullptr) {
            if (current->next == nullptr) {
                pre->next = current;
                break;
            } else {
                ListNode* next = current->next->next;
                pre->next = current->next;
                pre->next->next = current;
                current->next = nullptr;
                pre = current;
                current = next;
            }
        }
        return result->next;
    }
};