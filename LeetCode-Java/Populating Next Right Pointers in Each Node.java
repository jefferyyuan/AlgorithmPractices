/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

//with container
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> treeQueue = new  LinkedList<TreeLinkNode>();
        if(root == null) return;
        treeQueue.add(root);
        int preLength = 0,postLength = 1;
        while(postLength > 0)
        {
            for(int i = 0;i < postLength;i ++)
            {
                TreeLinkNode tempNode = treeQueue.poll();
                if(tempNode.left != null)
                {
                    treeQueue.add(tempNode.left);
                    preLength ++;
                }
                if(tempNode.right != null)
                {
                    treeQueue.add(tempNode.right);
                    preLength ++;
                }
                if(i != postLength - 1)
                {
                    tempNode.next = treeQueue.peek();
                }
            }
            postLength = preLength;
            preLength = 0;
        }
        return;
    }
}