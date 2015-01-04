public class TreeNode{
	int val;
	TreeNode left,right;
}

public class RecordData{
	int maxDepth;
	public RecordData(int val){
		maxDepth = val;
	}
}
public boolean isBalancedTree(TreeNode root){
	int currentDepth = 0;
	RecordData record = new RecordData(currentDepth);
	return isBalancedTreePart(root, record);
}

public boolean isBalancedTreePart(TreeNode root, RecordData record){
	int currentDepth = record.maxDepth + 1;
	if(root == null)
		return true;
	record.maxDepth = currentDepth;
	if(!isBalancedTreePart(root.left, record))
		return false;
	int leftMax = record.maxDepth;
	record.maxDepth = currentDepth;
	if(!isBalancedTreePart(root.right, record))
		return false;
	int rightMax = record.maxDepth;
	if(Math.abs(leftMax - rightMax) > 1)
		return false;
	record.maxDepth = Math.max(leftMax,rightMax);
	return true;
}