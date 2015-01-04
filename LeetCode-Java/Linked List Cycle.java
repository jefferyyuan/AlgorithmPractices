/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode start1 = head;
        ListNode start2 = head;
        while(start1 != null && start2 != null && start2.next != null)
        {
            start1 = start1.next;
            start2 = start2.next.next;
            if(start1 == start2)
            {
                return true;
            }
        }
        return false;
    }
}