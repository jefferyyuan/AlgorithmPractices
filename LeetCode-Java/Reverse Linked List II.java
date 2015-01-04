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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int length = n - m + 1;
        if(head == null || m == n)
            return head;
        ListNode left = null, start = head, end = null, right = null;
        if(m > 1)
        {
            left = head;
            while(m  > 2)
            {
                left = left.next;
                m --;
            }
            start = left.next;
        }
        end = start;
        right = end.next;
        while(length > 1)
        {
            if(right != null)
            {
                ListNode tempNode = right.next;
                right.next = end;
                end = right;
                right = tempNode;
            }
            length --;
        }
        if(left != null )
        {
            start.next = right;
            left.next = end;
            return head;
        }
        else
        {
            start.next = right;
            return end;
        }
    }
}