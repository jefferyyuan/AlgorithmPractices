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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode result = head;
        head = head.next;
        result.next = null;
        while(head!= null)
        {
            ListNode nextNode = head.next;
            ListNode preNode = null;
            ListNode tempNode = result;
            while(tempNode != null && head.val > tempNode.val)
            {
                preNode = tempNode;
                tempNode = tempNode.next;
            }
            if(preNode == null)
            {
                head.next = result;
                result = head;
            }
            else if(tempNode == null)
            {
                preNode.next = head;
                head.next = null;
            }
            else
            {
                preNode.next = head;
                head.next = tempNode;
            }
            head = nextNode;
        }
        return result;
    }
}