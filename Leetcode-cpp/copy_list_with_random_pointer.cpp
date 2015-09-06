/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode* current = head;
        while (current != nullptr) {
            RandomListNode* replica = new RandomListNode(current->label);
            replica->next = current->next;
            current->next = replica;
            current = current->next->next;
        }
        current = head;
        while (current != nullptr) {
            if (current->random != nullptr) current->next->random = current->random->next;
            current = current->next->next;
        }
        current = head;
        RandomListNode* result = new RandomListNode(-1);
        RandomListNode* replica_current = result;
        while (current != nullptr) {
            replica_current->next = current->next;
            replica_current = replica_current->next;
            current->next = current->next->next;
            current = current->next;
        }
        return result->next;
    }
};