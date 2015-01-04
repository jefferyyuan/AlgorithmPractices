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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreePart(preorder, 0 , preorder.length - 1, inorder, 0, inorder.length -1);
    }
    
    public TreeNode buildTreePart(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2)
    {
        if(start1 > end1)
            return null;
        int rootVal = preorder[start1];
        TreeNode root = new TreeNode(rootVal);
        if(start1 < end1)
        {
            int index = start2;
            for(;index <= end2;index ++)
            {
                if(inorder[index] == rootVal) break;
            }
            root.left = buildTreePart(preorder,start1 + 1,start1 + index - start2 ,inorder, start2, index - 1);
            root.right = buildTreePart(preorder,start1 + index - start2 + 1, end1,inorder, index + 1, end2);
        }
        return root;
    }
}