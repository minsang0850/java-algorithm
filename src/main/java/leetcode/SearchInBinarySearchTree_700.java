package leetcode;

public class SearchInBinarySearchTree_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) {
            return null;
        }
        if(root.val==val) {
            return root;
        }
        if(root.val<val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
