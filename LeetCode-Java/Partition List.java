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
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null,leftTail = null, rightHead = null, rightTail = null;
        while(head != null)
        {
            if(head.val < x)
            {
                if(leftHead == null)
                {
                    leftHead = head;
                    leftTail = head;
                }
                else
                {
                    leftTail.next = head;
                    leftTail = head;
                }
            }
            else
            {
                if(rightHead == null)
                {
                    rightHead = head;
                    rightTail = head;
                }
                else
                {
                    rightTail.next = head;
                    rightTail = head;
                }
            }
            head = head.next;
        }
        if(rightTail != null)
            rightTail.next = null;
        if(leftHead == null) 
            return rightHead;
        else
        {
            leftTail.next = rightHead;
            return leftHead;
        }
    }
}