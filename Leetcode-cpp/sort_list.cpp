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
    ListNode* sortList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast->next != nullptr && fast->next->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        ListNode* right = sortList(slow->next);
        slow->next = nullptr;
        ListNode* left = sortList(head);
        return merge(left, right);
    }
    
    ListNode* merge(ListNode* left, ListNode* right) {
        ListNode* fake_head = new ListNode(-1);
        ListNode* current = fake_head;
        while (left != nullptr || right != nullptr) {
            if (left == nullptr || (right != nullptr && right->val < left->val)) {
                current->next = right;
                current = current->next;
                right = right->next;
            } else {
                current->next = left;
                current = current->next;
                left = left->next;
            }
        }
        return fake_head->next;
    }
};