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
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTPart(num, 0, num.length - 1);
    }
    
    public TreeNode sortedArrayToBSTPart(int[] num,int start, int end)
    {
        if(end < start) return null;
        if(end == start) return new TreeNode(num[start]);
        else
        {
            int mid = (start + end) / 2;
            TreeNode midNode = new TreeNode(num[mid]);
            midNode.left = sortedArrayToBSTPart(num, start, mid - 1);
            midNode.right = sortedArrayToBSTPart(num, mid + 1, end);
            return midNode;
        }
    }
}