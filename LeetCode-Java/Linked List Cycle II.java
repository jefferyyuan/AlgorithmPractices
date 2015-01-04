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
    public ListNode detectCycle(ListNode head) {
        ListNode result = null;
        if(head == null) return result;
        ListNode step1 = head,step2 = head;
        while(step2.next != null && step2.next.next != null)
        {
            step1 = step1.next;
            step2 = step2.next.next;
            if(step1 == step2)
            {
                step2 = head;
                while(step1 != step2)
                {
                    step1 = step1.next;
                    step2 = step2.next;
                }
                result = step1;
                break;
            }
        }
        return result;
    }
}