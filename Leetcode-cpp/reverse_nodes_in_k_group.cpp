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
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* result = head;
        ListNode* fake_head = new ListNode(-1);
        fake_head->next = head;
        ListNode* pre = fake_head;
        while (head != nullptr) {
            ListNode* current = head;
            int count = k - 1;
            while (current != nullptr && count > 0) {
                current = current->next;
                count--;
            }
            if (current == nullptr) break;
            ListNode* new_tail = current->next;
            current->next = nullptr;
            pair<ListNode*, ListNode*> r_result = reverse(pre->next);
            pre->next = r_result.first;
            r_result.second->next = new_tail;
            pre = r_result.second;
            head = new_tail;
        }
        return fake_head->next;
    }
    
    pair<ListNode*, ListNode*> reverse(ListNode* head) {
        ListNode* tail = head;
        ListNode* pre = nullptr;
        ListNode* current = head;
        while (current != nullptr) {
            ListNode* temp = current->next;
            current->next = pre;
            pre = current;
            current = temp;
        }
        return make_pair(pre, tail);
    }
};