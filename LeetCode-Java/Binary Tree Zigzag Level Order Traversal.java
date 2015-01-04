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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        int turn = 0;
        int length = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) 
            return result;
        nodeList.addLast(root);
        while(length > 0)
        {
            int newLength = 0;
            List<Integer> tempResult = new ArrayList<Integer>();
            while(length > 0)
            {
                if(turn == 0)
                {
                    TreeNode tempNode = nodeList.pollFirst();
                    tempResult.add(tempNode.val);
                    if(tempNode.left != null)
                    {
                        nodeList.addLast(tempNode.left);
                        newLength ++;
                    }
                    if(tempNode.right != null)
                    {
                        nodeList.addLast(tempNode.right);
                        newLength ++;
                    }
                }
                else
                {
                    TreeNode tempNode = nodeList.pollLast();
                    tempResult.add(tempNode.val);
                    if(tempNode.right != null)
                    {
                        nodeList.addFirst(tempNode.right);
                        newLength ++;
                    }
                    if(tempNode.left != null)
                    {
                        nodeList.addFirst(tempNode.left);
                        newLength ++;
                    }
                }
                length --;
            }
            turn = 1 - turn;
            length = newLength;
            result.add(tempResult);
        }
        return result;
    }
}