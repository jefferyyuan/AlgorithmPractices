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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        ListNode pre = null, current = head, result = null, sessionStart = head;
        ListNode preSessionStart = null;
        int count = k;
        while(true)
        {
            if(current != null)
            {
                sessionStart.next = current.next;
                if(pre != null)
                    current.next = pre;
                pre = current;
                current = sessionStart.next;
                count --;
                if(count == 0)
                {
                    if(preSessionStart != null)
                    {
                        preSessionStart.next = pre;
                    }
                    preSessionStart = sessionStart;
                    count = k;
                    sessionStart = sessionStart.next;
                    if(result == null)
                        result = pre;
                    pre = null;
                    current = sessionStart;
                }
            }
            else
            {
                if(count < k)
                {
                    ListNode reverse = reverseKGroup(pre, k - count);
                    pre = reverse;
                }
                if(preSessionStart != null)
                {
                    preSessionStart.next = pre;
                }
                if(result == null) result = pre;
                break;
            }
        }
        return result;
    }
}