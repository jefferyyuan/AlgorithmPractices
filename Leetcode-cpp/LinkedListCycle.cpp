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
    bool hasCycle(ListNode *head) {
        ListNode *t1 = head;
        ListNode *t2 = head;
        if(head == NULL) return false;
        while(true)
        {
            t1 = t1->next;
            if(t1 == NULL) return false;
            t2 = t2->next;
            if(t2 == NULL) return false;
            t2 = t2->next;
            if(t2 == NULL) return false;
            if(t1 == t2) break;
        }
        return true;
    }
};
