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
    public void flatten(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        if(root == null) return;
        nodeStack.push(root);
        while(!nodeStack.empty())
        {
            TreeNode tempNode = nodeStack.pop();
            if(tempNode.right != null) nodeStack.push(tempNode.right);
            if(tempNode.left != null) nodeStack.push(tempNode.left);
            if(nodeStack.empty()) tempNode.right = null;
            else tempNode.right = nodeStack.peek();
            tempNode.left = null;
        }
        return;
    }
}