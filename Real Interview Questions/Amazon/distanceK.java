

public void print(TreeNode root, int k) {
	if (root == null || k < 0) {
		return;
	} else if (k == 0) {
		System.out.print(root.val + " ");
	} else {
		print(root.left, k - 1);
		print(root.right, k - 1);
	}
}

public int dfs(TreeNode root, TreeNode targetNode, int k) {
	if (root == NULL) {
		return -1;
	} else if (root == targetNode) {
		print(root, k);
		return 0;
	} else {
		int distance = dfs(root.left, targetNode, k);
		if (distance >= 0) {
			if (distance + 1 == k) {
				print(root, 0);
			} else {
				print(root.right, k - distance - 1);
			}
			return distance + 1;
		}
		distance = dfs(root.right, targetNode, k);
		if (distance >= 0) {
			if (distance + 1 == k) {
				print(root, 0);
			} else {
				print(root.left, k - distance - 1);
			}
			return distance + 1;
		}
		return -1;
	}
}