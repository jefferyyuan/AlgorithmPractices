/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        // generate permutations
        int[] num = new int[n];
        for(int i = 0;i < n;i ++) num[i] = i + 1;
        return generateTreesFromArray(num, 0, num.length - 1);
    }
    
    public List<TreeNode> generateTreesFromArray(int[] num, int start, int end)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) 
        {
            result.add(null);
            return result;
        }
        else if(start == end)
        {
            result.add(new TreeNode(num[start]));
            return result;
        }
        else
        {
            for(int i = start;i <= end;i ++)
            {
                List<TreeNode> leftResult = generateTreesFromArray(num, start, i - 1);
                List<TreeNode> rightResult = generateTreesFromArray(num, i + 1, end);
                for(int m = 0;m < leftResult.size();m ++)
                {
                    for(int n = 0;n < rightResult.size();n ++)
                    {
                        TreeNode tempNode = new TreeNode(num[i]);
                        tempNode.left = leftResult.get(m);
                        tempNode.right = rightResult.get(n);
                        result.add(tempNode);
                    }
                }
            }
        }
        return result;
    }
}