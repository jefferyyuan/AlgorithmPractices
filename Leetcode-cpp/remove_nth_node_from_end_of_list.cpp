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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* fake_head = new ListNode(-1);
        fake_head->next = head;
        head = fake_head;
        ListNode* fast = fake_head;
        n++;
        while (n > 0) {
            fast = fast->next;
            n--;
        }
        while (fast != nullptr) {
            head = head->next;
            fast = fast->next;
        }
        head->next = head->next->next;
        return fake_head->next;
    }
};