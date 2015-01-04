public class BSTNode{
	int val;
	BSTNode left,right;
	public BSTNode(int tempValue){
		val = tempValue;
		left = null;
		right = null;
	}
}

/*
 * 	Create BST from sorted array
 */
public BSTNode constructBSTFromArray(int[] source){
	if(source == null)
		return null;
	else
		return constructBSTFromArray(source, 0, source.length - 1);
}
public BSTNode constructBSTFromArray(int[] source, int start, int end){
	if(source == null || source.length == 0 || start > end || start < 0 || end >= source.length){
		return null;
	}
	if(start == end)
		return new BSTNode(source[start]);
	else{
		int mid = (start + end) / 2;
		BSTNode root = new BSTNode(source[mid]);
		root.left = constructBSTFromArray(source, start, mid - 1);
		root.right = constructBSTFromArray(source, mid + 1, end);
		return root;
	}
}

/*
 *	Flatten a BST to a double-linked-list(use left and right as prev and next)
 *	微软等公司数据结构+算法面试100题 第1题
 *	http://blog.csdn.net/v_JULY_v/article/details/6057286
 */
public BSTNode flatBST(BSTNode root){
	if(root == null)
		return null;
	BSTNode result = null;
	if(root.left != null)
	{
		result = flatBST(root.left);
		BSTNode tempNode = result;
		while(tempNode.right != null){
			tempNode = tempNode.right;
		}
		tempNode.right = root;
		root.left = tempNode;
	}
	else
		result = root;
	BSTNode rightHead = flatBST(root.right);
	root.right = rightHead;
	if(rightHead != null)
		rightHead.left = root;
	return result;
}

public void test_1(){
	int[] source = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
	BSTNode root = this.constructBSTFromArray(source);
	root = this.flatBST(root);
	while(root!= null){
		System.out.print(root.val);
		root = root.right;
	}
	return;
}