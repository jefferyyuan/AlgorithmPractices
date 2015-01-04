/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> record = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root != null){
            record.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !record.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = record.pop();
        int result = tempNode.val;
        tempNode = tempNode.right;
        while(tempNode != null){
            record.push(tempNode);
            tempNode = tempNode.left;
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */