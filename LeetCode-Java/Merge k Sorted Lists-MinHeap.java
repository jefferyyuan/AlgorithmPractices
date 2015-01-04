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
    List<ListNode> minHeap;
    
    public ListNode pollMin(){
        ListNode result = minHeap.get(0);
        if(result.next == null){
            int lastIndex = minHeap.size() - 1;
            Collections.swap(minHeap, 0, lastIndex);
            minHeap.remove(lastIndex);
            nodeDown(0);
        }
        else{
            minHeap.set(0, result.next);
            nodeDown(0);
        }
        return result;
    }
    
    public void nodeDown(int index){
        while(true){
            int minIndex = index;
            if(2 * index + 1 < minHeap.size() && minHeap.get(2 * index + 1).val < minHeap.get(minIndex).val)
                minIndex = 2 * index + 1;
            if(2 * index + 2 < minHeap.size() && minHeap.get(2 * index + 2).val < minHeap.get(minIndex).val)
                minIndex = 2 * index + 2;
            if(minIndex == index)
                break;
            else{
                Collections.swap(minHeap,index,minIndex);
                index = minIndex;
            }
        }
        return;
    }
    
    public void adjust(){
        int size = minHeap.size();
        for(int i = (size + 1) / 2 - 1;i >= 0 ;i --){
            nodeDown(i);
        }
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        minHeap = new ArrayList<ListNode>();
        for(int i = 0;i < lists.size();i ++){
            if(lists.get(i) != null)
                minHeap.add(lists.get(i));
        }
        adjust();
        ListNode head = null;
        ListNode pre = null;
        while(minHeap.size() > 0){
            ListNode current = pollMin();
            if(head == null)
                head = current;
            if(pre != null)
                pre.next = current;
            pre = current;
        }
        return head;
    }
}