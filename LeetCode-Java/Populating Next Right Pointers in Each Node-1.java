/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//without container
public class Solution 
{
    public void connect(TreeLinkNode root) 
    {
        boolean setRoot = false;
        while(root != null)
        {
           TreeLinkNode temp = root;
           root = temp.left;
           while(temp != null)
           {
               if(temp.left != null && temp.right != null) temp.left.next = temp.right;
               if(temp.right != null && temp.next!= null && temp.next.left != null)
                  temp.right.next = temp.next.left;
               temp = temp.next;
           }
        }
        return;
    }
}