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
    
    public class myTreeNode {
        int leftVal;
        int rightVal;
        TreeNode node;
        myTreeNode left;
        myTreeNode right;
        myTreeNode(TreeNode root)
        {
            if(root == null)
                node = null;
            else
            {
                node = root;
                left = null;
                leftVal = root.val;
                right = null;
                rightVal = root.val;
                if(root.left != null)
                {
                    this.left = new myTreeNode(root.left);
                    this.leftVal =this.left.leftVal;
                }
                if(root.right != null)
                {
                    this.right = new myTreeNode(root.right);
                    this.rightVal = this.right.rightVal;
                }
            }
        }
        boolean isValidBST()
        {
            if(node == null)
                return true;
            boolean result = true;
            if(node.left != null)
            {
                result = result && this.left.isValidBST() && this.left.rightVal < this.node.val;
            }
            if(node.right != null)
            {
                result = result && this.right.isValidBST() && this.right.leftVal > this.node.val;
            }
            return result;
        }
    }
    public boolean isValidBST(TreeNode root) {
        myTreeNode newRoot = new myTreeNode(root);
        return newRoot.isValidBST();
    }
}