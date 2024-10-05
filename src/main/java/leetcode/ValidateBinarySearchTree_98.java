package leetcode;

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left==null && root.right==null) {
            return true;
        }
        if(root.left==null) {
            return root.val < getMin(root.right) && isValidBST(root.right);
        }
        if(root.right==null) {
            return getMax(root.left)< root.val && isValidBST(root.left);
        }
        return getMax(root.left)< root.val && root.val < getMin(root.right) && isValidBST(root.left) && isValidBST(root.right);
    }

    private int getMax(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.right==null) {
            return root.val;
        }
        return getMax(root.right);
    }

    private int getMin(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null) {
            return root.val;
        }
        return getMin(root.left);
    }
}
