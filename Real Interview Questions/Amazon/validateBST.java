// pass range
public class Solution {
    public boolean isValidBST(TreeNode root) {
        long left = ((long)Integer.MIN_VALUE) - 1;
        long right = ((long)Integer.MAX_VALUE) + 1;
        return isValidBST(root, left, right);
    }
    
    public boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        } else {
            long tempVal = (long)root.val;
            if (tempVal <= left || tempVal >= right) {
                return false;
            } else {
                return isValidBST(root.left, left, tempVal) && isValidBST(root.right, tempVal, right);
            }
        }
    }

    
}

// using pre
public class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        pre = null;
        return isValidBSTHelper(root);
    }
    public boolean isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(!isValidBSTHelper(root.left)) {
            return false;
        }
        if(pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        if(!isValidBSTHelper(root.right)) {
            return false;
        }
        return true;
    }
    
}