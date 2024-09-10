package leetcode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var node = new TreeNode();
        if(preorder.length==0) {
            return null;
        }
        node.val=preorder[0];
        for (int i=0; i<inorder.length; i++) {
            if(node.val == inorder[i]) {
                var leftPreorder = Arrays.copyOfRange(preorder, 1, i+1);
                var rightPreorder = Arrays.copyOfRange(preorder, i+1, preorder.length);
                var leftInorder = Arrays.copyOfRange(inorder, 0, i);
                var rightInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);
                node.left= buildTree(leftPreorder, leftInorder);
                node.right= buildTree(rightPreorder, rightInorder);
            }
        }
        return node;
    }
}
