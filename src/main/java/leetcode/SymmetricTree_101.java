package leetcode;

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null && right==null) {
            return true;
        }
        if (left==null || right==null) {
            return false;
        }
        if(left.val==right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
}
