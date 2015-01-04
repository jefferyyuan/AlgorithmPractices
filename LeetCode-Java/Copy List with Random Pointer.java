/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> record = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode start = head;
        RandomListNode newStart = null, pre = null;
        while(start != null)
        {
            RandomListNode tempNode = null;
            if(record.containsKey(start))
                tempNode = record.get(start);
            else
            {
                tempNode = new RandomListNode(start.label);
                record.put(start,tempNode);
            }
            if(pre != null)
                pre.next = tempNode;
            if(newStart == null)
                newStart = tempNode;
                
            RandomListNode randomNode = null;
            if(record.containsKey(start.random))
            {
                randomNode = record.get(start.random);
            }
            else if(start.random != null)
            {
                randomNode = new RandomListNode(start.random.label);
                record.put(start.random, randomNode);
            }
            tempNode.random = randomNode;
            pre = tempNode;
            start = start.next;
        }
        return newStart;
    }
}