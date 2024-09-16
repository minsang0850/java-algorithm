package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        var sum = new ArrayList<Double>();
        var count = new ArrayList<Integer>();
        averageOfLevels(root, 0, sum, count);
        var answer = new ArrayList<Double>();
        for (int i = 0; i < sum.size(); i++) {
            answer.add(i, sum.get(i)/(double)count.get(i));
        }
        return answer;
    }

    private void averageOfLevels(TreeNode root, int level, ArrayList<Double> sum, ArrayList<Integer> count) {
        if (root == null) {
            return;
        }
        if (level == sum.size()) {
            sum.add((double) root.val);
            count.add(1);
        } else {
            sum.set(level, sum.get(level) + (double)root.val);
            count.set(level,  count.get(level) + 1);
        }
        averageOfLevels(root.left, level + 1, sum, count);
        averageOfLevels(root.right, level + 1, sum, count);
    }
}
