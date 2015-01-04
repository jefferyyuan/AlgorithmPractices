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
        boolean result = true;
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftStack.push(root.left);
        rightStack.push(root.right);
        while((!leftStack.empty()) && (!rightStack.empty()))
        {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if(left == null || right == null)
            {
                if(left == null && right == null)
                    continue;
                else
                {
                    result = false;
                    break;
                }
            }
            else
            {
                if(left.val != right.val)
                {
                    result = false;
                    break;
                }
                else
                {
                    leftStack.push(left.left);
                    leftStack.push(left.right);
                    rightStack.push(right.right);
                    rightStack.push(right.left);
                }
            }
        }
        return result;
    }
}