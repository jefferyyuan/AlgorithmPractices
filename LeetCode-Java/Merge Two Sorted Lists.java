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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0);
        ListNode headNode = tempNode;
        while(l1 != null || l2 != null)
        {
            if(l1 == null)
            {
                headNode.next = l2;
                l2 = l2.next;
            }
            else if(l2 == null)
            {
                headNode.next = l1;
                l1 = l1.next;
            }
            else if(l1.val < l2.val)
            {
                headNode.next = l1;
                l1 = l1.next;
            }
            else
            {
                headNode.next = l2;
                l2 = l2.next;
            }
            headNode = headNode.next;
        }
        return tempNode.next;
    }
}