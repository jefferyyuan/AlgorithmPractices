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

// using code of Linked List Cycle II.java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempNode = headA;
        if(tempNode == null) return null;
        while(tempNode.next != null)
        {
            tempNode = tempNode.next;
        }
        tempNode.next = headB;
        ListNode result = detectCycle(headA);
        tempNode.next = null;
        return result;
    }
    
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