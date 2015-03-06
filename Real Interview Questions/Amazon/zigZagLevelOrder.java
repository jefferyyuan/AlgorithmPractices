public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int count = 1;
        queue.addLast(root);
        int direction = 1; // true for from left to right
        while (queue.size() > 0) {
            int newCount = 0;
            List<Integer> tempLevel = new ArrayList<Integer>();
            while (count > 0) {
                count--;
                if (direction == 1) {
                    TreeNode tempNode = queue.pollFirst();
                    tempLevel.add(tempNode.val);
                    if (tempNode.left != null) {
                        queue.addLast(tempNode.left);
                        newCount++;
                    }
                    if (tempNode.right != null) {
                        queue.addLast(tempNode.right);
                        newCount++;
                    }
                } else {
                    TreeNode tempNode = queue.pollLast();
                    tempLevel.add(tempNode.val);
                    if (tempNode.right != null) {
                        queue.addFirst(tempNode.right);
                        newCount++;
                    }
                    if (tempNode.left != null) {
                        queue.addFirst(tempNode.left);
                        newCount++;
                    }
            
                }
            }
            count = newCount;
            direction = 1 - direction;
            if (tempLevel.size() > 0) {
                result.add(tempLevel);
            }
        }
        return result;
    }
}