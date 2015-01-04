/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = null, node2 = head, node3 = head;
        while(n > 0)
        {
            node3 = node3.next;
            n --;
        }
        while(node3 != null)
        {
            node1 = node2;
            node2 = node2.next;
            node3 = node3.next;
        }
        if(node1 == null)
        {
            return head.next;
        }
        else
        {
            node1.next = node2.next;
            return head;
        }
        
        
    }
}