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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        while(root != null || !treeStack.empty())
        {
            if(root == null)
            {
                root = treeStack.pop();
            }
            else
            {
                resultList.add(root.val);
                treeStack.push(root.right);
                root = root.left;
            }
        }
        return resultList;
    }
}