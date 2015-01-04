/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> record = new ArrayList<ListNode>();
        while(head != null)
        {
            record.add(head);
            head = head.next;
        }
        if(record.size() <= 1) return;
        int startIndex = 0, endIndex = record.size() - 1;
        int turn = 1;
        ListNode current = null, pre = null;
        while(startIndex <= endIndex)
        {
            int tempIndex = startIndex;
            if(turn == 0)
            {   
                tempIndex = endIndex;
                endIndex --;
            }
            else
                startIndex ++;
            current = record.get(tempIndex);
            if(pre != null) pre.next = current;
            pre = current;
            current.next = null;
            turn = 1 - turn;
        }
        return;
    }
}