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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int length_a = 0;
        ListNode* current = headA;
        while (current != nullptr) {
            current = current->next;
            length_a++;
        }
        current = headB;
        int length_b = 0;
        while (current != nullptr) {
            current = current->next;
            length_b++;
        }
        while (length_a > length_b) {
            headA = headA->next;
            length_a--;
        }
        while (length_b > length_a) {
            headB = headB->next;
            length_b--;
        }
        while (headA != headB) {
            headA = headA->next;
            headB = headB->next;
        }
        return headA;
    }
};