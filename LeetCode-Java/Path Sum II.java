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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> record = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pathSumPart(root, sum, record, result);
        return result;
    }
    
    public void pathSumPart(TreeNode root, int sum,ArrayList<Integer> record, List<List<Integer>> result)
    {
        if(root == null) 
            return;
        if(root.left == null && root.right == null)
        {
            if(root.val == sum)
            {
                record.add(root.val);
                ArrayList<Integer> tempResult = (ArrayList<Integer>)record.clone();
                result.add(tempResult);
                record.remove(record.size() - 1);
            }
        }
        else
        {
            sum -= root.val;
            record.add(root.val);
            if(root.left != null)
            {
                pathSumPart(root.left, sum, record, result);
            }
            if(root.right != null)
            {
                pathSumPart(root.right, sum, record, result);
            }
            record.remove(record.size() - 1);
        }
        return;
    }
}