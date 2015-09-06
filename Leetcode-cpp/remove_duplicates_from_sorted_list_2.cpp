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
        ListNode* fake_head = new ListNode(-1);
        fake_head->next = head;
        ListNode* pre = fake_head;
        while (head != nullptr) {
            if (head->next != nullptr && head->val == head->next->val) {
                int test_val = head->val;
                while (head!= nullptr && head->val == test_val) head = head->next;
                pre->next = head;
            } else {
                pre = head;
                head = head->next;
            }
        }
        return fake_head->next;
    }
};