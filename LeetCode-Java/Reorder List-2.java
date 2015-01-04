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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        // find mid point(slow)
        ListNode slow = head, fast = head;
        while(true)
        {
            if(slow != null) slow = slow.next;
            if(fast.next == null || fast.next.next == null)
                break;
            else
                fast = fast.next.next;
        }
        // reverse the second half in place
        ListNode pre = null;
        while(slow.next != null)
        {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        slow.next = pre;
        // merge two lists
        // length(first half) = length(second half) 
        //|| length(first half) = length(second half) + 1
        ListNode first = head, second = slow;
        while(second != null)
        {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;
            first = nextFirst;
            second = nextSecond;
        }
        if(first != null) first.next = null;
        return;
        
        
    }
}