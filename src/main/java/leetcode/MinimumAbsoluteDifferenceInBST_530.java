package leetcode;

public class MinimumAbsoluteDifferenceInBST_530 {
    int answer = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return answer;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        if (root.left != null) {
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            answer = Math.min(answer, root.val - left.val);
        }
        if (root.right != null) {
            TreeNode right = root.right;
            while (right.left != null) {
                right = right.left;
            }
            answer = Math.min(answer, right.val - root.val);
        }
    }
}
