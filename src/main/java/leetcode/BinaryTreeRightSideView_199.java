package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        rightView(root, 0, ans);
        return ans;
    }

    public void rightView(TreeNode root, int depth, List<Integer> ans){
        if(root == null){
            return;
        }

        if(depth == ans.size()){
            ans.add(root.val);
        }
        rightView(root.right, depth+1, ans);
        rightView(root.left, depth+1, ans);
    }
}
