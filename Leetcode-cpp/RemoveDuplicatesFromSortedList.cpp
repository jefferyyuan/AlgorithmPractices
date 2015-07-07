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
    ListNode *deleteDuplicates(ListNode *head) {
        ListNode *search = head;
        while(head)
        {
            ListNode *temp = head->next;
            while(temp != NULL && temp->val == head->val) temp = temp->next;
            head->next = temp;
            head = temp;
        }
        return search;
    }
};
