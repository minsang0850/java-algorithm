package leetcode;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) {
            return false;
        }
        return hasPathSum(root.left, targetSum- root.val)
               || hasPathSum(root.right, targetSum- root.val)
               || (root.left==null && root.right==null && root.val==targetSum);
    }
}
