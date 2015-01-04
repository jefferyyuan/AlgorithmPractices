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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = null, current = head, result = null;
        while(current != null && current.next != null)
        {
            
            if(current.val == current.next.val)
            {
                int currentVal = current.val;
                while(current != null && current.val == currentVal)
                    current = current.next;
                if(pre != null) pre.next = current;
            }
            else
            {
                if(pre != null) pre.next = current;
                pre = current;
                if(result == null) result = current;
                current = current.next;
            }
        }
        if(result == null) result = current;
        return result;
        
    }
}