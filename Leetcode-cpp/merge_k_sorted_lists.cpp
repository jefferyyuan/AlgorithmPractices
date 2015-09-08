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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        auto my_compare = [](ListNode* v1, ListNode*v2) { return v1 == nullptr || (v2 != nullptr && v1->val > v2->val); };
        priority_queue<ListNode*, vector<ListNode*>, decltype(my_compare)> pq(my_compare);
        ListNode* fake_head = new ListNode(-1);
        ListNode* current = fake_head;
        for (auto val : lists) {
            pq.push(val);
        }
        while (!pq.empty() && pq.top() != nullptr) {
            current->next = pq.top();
            current = current->next;
            ListNode* temp = pq.top()->next;
            pq.pop();
            pq.push(temp);
        }
        return fake_head->next;
    }
};