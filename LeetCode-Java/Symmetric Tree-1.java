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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else
            return isSymmetricPart(root.left, root.right);
    }
    public boolean isSymmetricPart(TreeNode left, TreeNode right)
    {
        if(left == null || right == null) 
            return right == null && left == null;
        return left.val == right.val && isSymmetricPart(left.left,right.right) && isSymmetricPart(left.right,right.left);
    }
}