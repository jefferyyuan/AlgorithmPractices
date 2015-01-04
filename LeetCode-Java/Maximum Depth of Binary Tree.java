/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution 
{
    public int maxDepth(TreeNode root) 
    {
        return root == null ? 0 : max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
    int max(int left,int right)
    {
        return left > right ? left : right;
    }
}