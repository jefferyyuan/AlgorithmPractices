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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTPart(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBSTPart(TreeNode root, long min, long max)
    {
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValidBSTPart(root.left, min, (long)root.val)
            && isValidBSTPart(root.right, (long)root.val, max);
    }
}