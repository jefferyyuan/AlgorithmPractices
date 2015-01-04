/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] record = new TreeNode[3];
        record[0] = null;
        record[1] = null;
        record[2] = null;
        recoverTreePart(root, record);
        int temp = record[0].val;
        record[0].val = record[1].val;
        record[1].val = temp;
        return;
    }
    
    public void recoverTreePart(TreeNode root, TreeNode[] record)
    {
        if(root == null) return;
        recoverTreePart(root.left, record);
        TreeNode pre = record[2];
        if(pre != null)
        {
            if(pre.val > root.val && record[0] == null)
            {
                record[0] = pre;
                record[1] = root;
            }
            else if(pre.val > root.val)
            {
                record[1] = root;
            }
        }
        record[2] = root;
        recoverTreePart(root.right, record);
        return;
    }
}