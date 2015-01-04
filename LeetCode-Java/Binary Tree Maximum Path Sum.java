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
    
    class MyTreeNode
    {
        int maxSinglePath;
        int maxCompletePath;
        int maxOneNode;
        public MyTreeNode(TreeNode root)
        {
            maxOneNode = root.val;
            int leftComplete = 0, rightComplete = 0;
            int leftSingle = 0, rightSingle = 0;
            if(root.left != null)
            {
                MyTreeNode leftNode = new MyTreeNode(root.left);
                leftComplete = leftNode.maxCompletePath;
                leftSingle = leftNode.maxSinglePath;
                maxOneNode = Math.max(maxOneNode,leftNode.maxOneNode);
            }
            if(root.right != null)
            {
                MyTreeNode rightNode = new MyTreeNode(root.right);
                rightComplete = rightNode.maxCompletePath;
                rightSingle = rightNode.maxSinglePath;
                maxOneNode = Math.max(maxOneNode,rightNode.maxOneNode);
            }
            maxSinglePath = Math.max(0, leftSingle + root.val);
            maxSinglePath = Math.max(maxSinglePath, rightSingle + root.val);
            
            maxCompletePath = Math.max(leftComplete, rightComplete);
            maxCompletePath = Math.max(maxCompletePath, leftSingle + root.val + rightSingle);
        }
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        MyTreeNode rootNode = new MyTreeNode(root);
        if(rootNode.maxCompletePath <= 0)
            return rootNode.maxOneNode;
        else
            return rootNode.maxCompletePath;
    }
}