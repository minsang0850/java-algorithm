package leetcode;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        var node = new TreeNode();
        if(postOrder.length==0) {
            return null;
        }
        node.val=postOrder[postOrder.length-1];
        for (int i=0; i<inorder.length; i++) {
            if(node.val == inorder[i]) {
                var leftPostorder = Arrays.copyOfRange(postOrder, 0, i);
                var rightPostorder = Arrays.copyOfRange(postOrder, i, postOrder.length-1);
                var leftInorder = Arrays.copyOfRange(inorder, 0, i);
                var rightInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);
                node.left= buildTree(leftInorder, leftPostorder);
                node.right= buildTree(rightInorder, rightPostorder);
            }
        }
        return node;
    }
}
