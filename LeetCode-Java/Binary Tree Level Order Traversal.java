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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> nodeStack = new LinkedList<TreeNode>();
        if(root == null) return result;
        nodeStack.addLast(root);
        int count = 1;
        while(count > 0)
        {
            List<Integer> tempResult = new ArrayList<Integer>();
            int newCount = 0;
            while(count > 0)
            {
                TreeNode tempNode = nodeStack.pollFirst();
                count --;
                tempResult.add(tempNode.val);
                if(tempNode.left != null) 
                {
                    nodeStack.addLast(tempNode.left);
                    newCount ++;
                }
                if(tempNode.right != null)
                {
                    nodeStack.addLast(tempNode.right);
                    newCount ++;
                }
            }
            if(tempResult.size() > 0) result.add(tempResult);
            count = newCount;
        }
        return result;
    }
}