//	use wrapper
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

//	we can return -1 if not balanced, so we will not need the wrapper
public boolean isBalancedTree(TreeNode root){
	int height = checkHeight(root);
	return height >= 0;
}

public int checkHeight(TreeNode root){
	if(root == null)
		return 0;
	int leftLength = checkHeight(root.left);
	if(leftLength < 0)
		return -1;
	int rightLength = checkHeight(root.right);
	if(rightLength < 0)
		return -1;
	if(Math.abs(leftLength - rightLength) > 1)
		return -1;
	else
		return Math.max(leftLength, rightLength) + 1;
}