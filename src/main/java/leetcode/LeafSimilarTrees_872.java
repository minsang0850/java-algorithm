package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        var leafs1 = new ArrayList<Integer>();
        setLeafs(root1, leafs1);
        var leafs2 = new ArrayList<Integer>();
        setLeafs(root2, leafs2);
        if(leafs1.size()!=leafs2.size()) {
            return false;
        }
        return leafs1.equals(leafs2);
    }

    private void setLeafs(TreeNode root, List<Integer> leafs) {
        if(root==null) {
            return;
        }
        if (root.left==null && root.right==null) {
            leafs.add(root.val);
            return;
        }
        setLeafs(root.left, leafs);
        setLeafs(root.right, leafs);
    }
}
