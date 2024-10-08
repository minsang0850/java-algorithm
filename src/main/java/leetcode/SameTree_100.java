package leetcode;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        }
        if(p==null || q==null) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val==q.val;
    }
}
