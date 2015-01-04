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
    public int sumNumbers(TreeNode root) {
        return sumNumbersPart(root, 0);
    }
    
    public int sumNumbersPart(TreeNode root, int tempSum)
    {
        if(root == null) return 0;
        tempSum = tempSum * 10 + root.val;
        if(root.left == null && root.right == null)
            return tempSum;
        else
            return sumNumbersPart(root.left, tempSum) + sumNumbersPart(root.right, tempSum);
    }
}