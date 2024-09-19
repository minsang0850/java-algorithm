package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        var sums = sumNumbers2(root);
        var sum = 0;
        for (var s : sums) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private List<String> sumNumbers2(TreeNode root) {
        if(root==null) {
            return List.of();
        }
        var left = sumNumbers2(root.left);
        var right = sumNumbers2(root.right);
        var list = new ArrayList<String>();
        if(!left.isEmpty()) {
            for (int i=0; i<left.size(); i++) {
                list.add(root.val + left.get(i));
            }
        }
        if(!right.isEmpty()) {
            for (int i=0; i<right.size(); i++) {
                list.add(root.val + right.get(i));
            }
        }
        if(list.isEmpty()) {
            list.add(String.valueOf(root.val));
        }
        return list;
    }
}
