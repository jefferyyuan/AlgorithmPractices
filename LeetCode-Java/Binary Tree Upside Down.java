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
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)
            return root;
        else{
            TreeNode originalLeft = root.left;
            TreeNode originalRight = root.right;
            root.left = null;
            root.right = null;
            return UpsideDownBinaryTreePart(originalLeft, root, originalRight);
        }
    }
    
    public TreeNode UpsideDownBinaryTreePart(TreeNode target, TreeNode root, TreeNode right){
        if(target.left == null){
            target.left = right;
            target.right = root;
            return target;
        }
        else{
            TreeNode newTarget = target.left;
            TreeNode originalRight = target.right;
            target.left = right;
            target.right = root;
            return UpsideDownBinaryTreePart(newTarget, target, originalRight);
        }
    }
}