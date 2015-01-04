/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null)
        {
            TreeLinkNode head = root;
            root = null;
            TreeLinkNode childHead = null;
            // populate
            while(head != null)
            {
                if(head.left != null)
                {
                    if(childHead == null) 
                    {
                        childHead = head.left;
                        root = childHead;
                    }
                    else
                    {
                        childHead.next = head.left;
                        childHead = head.left;
                    }
                }
                if(head.right != null)
                {
                    if(childHead == null) 
                    {
                        childHead = head.right;
                        root = childHead;
                    }
                    else
                    {
                        childHead.next = head.right;
                        childHead = head.right;
                    }
                }
                head = head.next;
            }
        }
        return;
    }
}