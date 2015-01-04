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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        int length = 1;
        ListNode current = head;
        while(current.next != null)
        {
            length ++;
            current = current.next;
        }
        n = n % length;
        if(n == 0) return head;
        ListNode test = head;
        for(int i = 0;i < length - n - 1;i ++)
        {
            test = test.next;
        }
        ListNode result = test.next;
        test.next = null;
        current.next=  head;
        return result;
    }
}