/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

//  ref:http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
//  O(1) space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // copy after original node
        RandomListNode traverse = head;
        while(traverse != null){
            RandomListNode copyNode = new RandomListNode(traverse.label);
            copyNode.next = traverse.next;
            traverse.next = copyNode;
            traverse = copyNode.next;
        }
        // copy random pointer
        traverse = head;
        while(traverse != null){
            RandomListNode copyNode = traverse.next;
            if(traverse.random != null)
                copyNode.random = traverse.random.next;
            traverse = copyNode.next;
        }
        // detach pointer
        RandomListNode result = null;
        RandomListNode secondTraverse = null;
        traverse = head;
        while(traverse != null){
            if(result == null)
                result = traverse.next;
            if(secondTraverse != null)
                secondTraverse.next = traverse.next;
            secondTraverse = traverse.next;
            traverse.next = traverse.next.next;
            traverse = traverse.next;
        }
        return result;
    }
}