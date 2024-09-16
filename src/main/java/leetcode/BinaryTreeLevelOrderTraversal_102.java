package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var answer = new ArrayList<List<Integer>>();
        averageOfLevels(root, 0, answer);
        return answer;
    }

    private void averageOfLevels(TreeNode root, int level, List<List<Integer>> answer) {
        if (root == null) {
            return;
        }
        if (level == answer.size()) {
            var list = new ArrayList<Integer>();
            list.add(root.val);
            answer.add(list);
        } else {
            answer.get(level).add(root.val);
        }
        averageOfLevels(root.left, level + 1, answer);
        averageOfLevels(root.right, level + 1, answer);
    }
}
