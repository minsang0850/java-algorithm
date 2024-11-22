package leetcode;

import java.util.ArrayList;

public class CountGoodNodesInBinaryTree_1448 {
    public int goodNodes(TreeNode root) {
        var answer = new ArrayList<Integer>();
        goodNodes(root, answer, root.val);
        return answer.size();
    }

    private void goodNodes(TreeNode root, ArrayList<Integer> answer, int x) {
        if(root==null) {
            return;
        }
        if(root.val>=x) {
            answer.add(root.val);
        }
        x = Math.max(root.val, x);
        goodNodes(root.left, answer, x);
        goodNodes(root.right, answer, x);
    }
}
