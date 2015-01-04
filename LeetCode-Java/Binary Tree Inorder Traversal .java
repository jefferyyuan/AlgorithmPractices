/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Stack;
import java.util.ArrayList;
public class Solution 
{
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> resultList = new ArrayList<Integer>();
        if(root == null) return resultList;
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
        root = root.left;
        while(root != null || !treeStack.empty())
        {
            if(root != null)
            {
                treeStack.push(root);
                root = root.left;
            }
            else
            {
                TreeNode tempNode = treeStack.pop();
                resultList.add(tempNode.val);
                root = tempNode.right;
            }
        }
        return resultList;
    }
}