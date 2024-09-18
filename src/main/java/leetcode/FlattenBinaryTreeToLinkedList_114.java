package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList_114 {
    public void flatten(TreeNode root) {
        var list = new ArrayList<TreeNode>();
        flatten(root, list);
        for (int i=0; i<list.size(); i++) {
            var node = list.get(i);
            node.left=null;
            if(i<list.size()-1) {
                node.right=list.get(i+1);
            }
        }
    }

    private void flatten(TreeNode root, List<TreeNode> list) {
        if(root==null) {
            return;
        }
        list.add(root);
        flatten(root.left, list);
        flatten(root.right, list);
    }
}
