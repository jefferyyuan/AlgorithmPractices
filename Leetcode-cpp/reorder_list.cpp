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
    void reorderList(ListNode* head) {
        if (head == nullptr) return;
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast->next != nullptr && fast->next->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        ListNode* right = reverseList(slow->next);
        slow->next = nullptr;
        ListNode* left = head;
        ListNode* fake_head = new ListNode(-1);
        ListNode* current = fake_head;
        while (left != nullptr) {
            current->next = left;
            current = current->next;
            left = left->next;;
            if (right != nullptr) {
                current->next = right;
                current = current->next;
                right = right->next;
            }
        }
        
    }
    ListNode* reverseList(ListNode* head) {
        ListNode* pre = nullptr;
        ListNode* current = head;
        while (current != nullptr) {
            ListNode* next = current->next;
            current->next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
};