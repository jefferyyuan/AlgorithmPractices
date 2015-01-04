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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.addLast(root);
        int length = 1;
        
        while(length > 0)
        {
            List<Integer> tempList = new ArrayList<Integer>();
            int newLength = 0;
            while(length > 0)
            {
                TreeNode tempNode = nodeList.pollFirst();
                if(tempNode == null) continue;
                tempList.add(tempNode.val);
                length --;
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
            if(tempList.size() > 0)
                result.add(0, tempList);
            length = newLength;
        }
        return result;
    }
}