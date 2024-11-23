package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum3_437 {
    int answer = 0;
    public int pathSum(TreeNode root, int targetSum) {
        getList(root, targetSum);
        return answer;
    }

    private List<Long> getList(TreeNode root, int targetSum) {
        if(root==null) {
            return new ArrayList<>();
        }
        var list = new ArrayList<Long>();
        var val = root.val;
        list.add((long)val);
        var left = getList(root.left, targetSum);
        for (int i=0; i<left.size(); i++) {
            list.add((long)val+left.get(i));
        }
        var right = getList(root.right, targetSum);
        for (int i=0; i<right.size(); i++) {
            list.add((long)val+right.get(i));
        }
        for (int i=0; i<list.size(); i++) {
            if(list.get(i)==targetSum) {
                answer++;
            }
        }
        return list;
    }
}
