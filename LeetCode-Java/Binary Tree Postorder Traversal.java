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
    public class TreeTrackNode {
        TreeNode node;
        boolean isReady;
        TreeTrackNode(TreeNode x){
            node = x;
            isReady = false;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();
        if(root == null) return resultList;
        Stack<TreeTrackNode> nodeStack = new Stack<TreeTrackNode>();
        nodeStack.push(new TreeTrackNode(root));
        while(!nodeStack.empty())
        {
            TreeTrackNode tempNode = nodeStack.pop();
            if(tempNode.isReady)
            {
                resultList.add(tempNode.node.val);
            }
            else
            {
                tempNode.isReady = true;
                nodeStack.push(tempNode);
                if(tempNode.node.right != null)nodeStack.push(new TreeTrackNode(tempNode.node.right));
                if(tempNode.node.left != null)nodeStack.push(new TreeTrackNode(tempNode.node.left));
            }
        }
        return resultList;
    }
}