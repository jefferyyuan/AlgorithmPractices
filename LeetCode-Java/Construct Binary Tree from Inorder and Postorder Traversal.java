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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreePart(inorder, 0 , inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode buildTreePart(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2)
    {
        if(start1 > end1) 
            return null;
        else 
        {
            int rootVal = postorder[end2];
            TreeNode root = new TreeNode(rootVal);
            if(start1 < end1)
            {
                int index = start1;
                for(;index <= end1;index ++)
                {
                    if(inorder[index] == rootVal)
                        break;
                }
                root.left = buildTreePart(inorder,start1, index - 1, postorder, start2, start2 + index - 1 - start1);
                root.right = buildTreePart(inorder,index + 1, end1, postorder, start2 + index - start1, end2 - 1);
            }
            return root;
        }
    }
}