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
    
    static class ListNodeSort implements Comparator<ListNode> {
 
		public int compare(ListNode one, ListNode two) {
			return one.val - two.val;
		}
	}
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() <= 0) return null;
        PriorityQueue<ListNode> record = new PriorityQueue<ListNode>(lists.size(),new ListNodeSort());
        ListNode result = null, current = null;
        int nullCount = 0;
        for(int i = 0;i < lists.size();i ++)
        {
            if(lists.get(i) == null)
                nullCount ++;
            else
            {
                ListNode tempNode = lists.get(i);
                record.offer(tempNode);
                lists.set(i, tempNode.next);
            }
        }
        while(nullCount < lists.size())
        {
            ListNode headNode = record.poll();
            if(result == null) result = headNode;
            if(current != null) current.next = headNode;
            current = headNode;
            if(headNode.next == null)
                nullCount ++;
            else
            {
                record.offer(headNode.next);
            }
            headNode.next = null;
        }
        return result;
    }
}