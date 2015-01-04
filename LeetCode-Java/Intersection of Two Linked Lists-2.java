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

// straight forward solution
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempNode = headA;
        int count = 0;
        while(tempNode != null)
        {
            count ++;
            tempNode = tempNode.next;
        }
        tempNode = headB;
        while(tempNode != null)
        {
            count --;
            tempNode = tempNode.next;
        }
        if(count > 0)
        {
            while(count > 0)
            {
                headA = headA.next;
                count --;
            }
        }
        else
        {
            while(count < 0)
            {
                headB = headB.next;
                count ++;
            }
        }
        while(headA != null && headB != null && headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        if(headA == headB && headA != null)
        {
            return headA;
        }
        else
        {
            return null;
        }
    }
}