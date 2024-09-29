package leetcode;

import java.util.ArrayList;

public class KthSmallestElementInBST_230 {
    public int kthSmallest(TreeNode root, int k) {
        var list = new java.util.ArrayList<Integer>();
        dfs(root, list);
        return list.get(k-1);
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
