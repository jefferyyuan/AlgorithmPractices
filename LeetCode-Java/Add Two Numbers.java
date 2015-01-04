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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isUp = false;
        ListNode result = null, current = null;
        while(l1 != null || l2 != null)
        {
            int tempVal = 0;
            if(l2 != null)
            {
                tempVal += l2.val;
                l2 = l2.next;
            }
            if(l1 != null)
            {
                tempVal += l1.val;
                l1 = l1.next;
            }
            if(isUp)
                tempVal ++;
            isUp = (tempVal >= 10);
            tempVal = tempVal % 10;
            ListNode tempNode = new ListNode(tempVal);
            if(result == null) result = tempNode;
            if(current != null)
                current.next = tempNode;
            current = tempNode;         
        }
        if(isUp)
        {
            ListNode tempNode = new ListNode(1);
            current.next = tempNode;
        }
        return result;
    }
}