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
    public ListNode sortList(ListNode head) {
        int length = 1;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        while(true)
        {
            ListNode partPre = fakeHead;
            ListNode partNext = null;
            ListNode temp = fakeHead.next;
            int iterationCount = 0;
            while(temp != null)
            {
                iterationCount ++;
                ListNode head1 = temp;
                ListNode tail1 = temp;
                int tempLength = length - 1;
                while(tempLength > 0 && tail1 != null)
                {
                    tail1 = tail1.next;
                    tempLength --;
                }
                ListNode head2 = null;
                if(tail1 != null) 
                {
                    head2 = tail1.next;
                    tail1.next = null;
                }
                ListNode tail2 = head2;
                tempLength = length - 1;
                while(tempLength > 0 && tail2 != null)
                {
                    tail2 = tail2.next;
                    tempLength --;
                }
                partNext = null;
                if(tail2 != null)
                {
                	partNext = tail2.next;
                	tail2.next = null;
                }
                partPre = mergeTwoLists(head1, head2, partPre, partNext);
                temp = partNext;
            }
            length *= 2;
            if(iterationCount <= 1)
                break;
                
        }
        return fakeHead.next;
    }
    
    ListNode mergeTwoLists(ListNode head1, ListNode head2, ListNode partPre, ListNode partNext)
    {
        ListNode pre = partPre;
        while(head1 != null || head2 != null)
        {
            if(head2 == null)
            {
                if(pre != null) pre.next = head1;
                pre = head1;
                head1 = head1.next;
            }
            else if(head1 == null)
            {
                if(pre != null) pre.next = head2;
                pre = head2;
                head2 = head2.next;
            }
            else
            {
                if(head1.val < head2.val)
                {
                    if(pre != null) pre.next = head1;
                    pre = head1;
                    head1 = head1.next;
                }
                else
                {
                    if(pre != null) pre.next = head2;
                    pre = head2;
                    head2 = head2.next;
                }
            }
        }
        if(pre != null) pre.next = partNext;
        return pre;
    }
}