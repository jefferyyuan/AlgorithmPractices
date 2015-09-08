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
    bool isPalindrome(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return true;
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast->next != nullptr && fast->next->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        ListNode* right = reverseList(slow->next);
        slow->next = nullptr;
        bool result = compare(head, right);
        slow->next = reverseList(right);
        return result;
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
    
    bool compare(ListNode* left, ListNode* right) {
        while (left != nullptr && right != nullptr) {
            if (left->val != right->val) return false;
            left = left->next;
            right = right->next;
        }
        return true;
    }
};