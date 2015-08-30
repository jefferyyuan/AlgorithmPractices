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
    ListNode *detectCycle(ListNode *head) {
        if (head == nullptr) return nullptr;
        if (head->next == nullptr || head->next->next == nullptr) return nullptr;
        ListNode* slow = head->next;
        ListNode*fast = head->next->next;
        while (slow != fast) {
            slow = slow->next;
            if (fast->next == nullptr || fast->next->next == nullptr) return nullptr;
            fast = fast->next->next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow->next;
            fast = fast->next;
        }
        return slow;
    }
};