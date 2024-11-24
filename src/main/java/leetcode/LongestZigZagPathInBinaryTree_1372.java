package leetcode;

public class LongestZigZagPathInBinaryTree_1372 {
    int answer = 0;
    public int longestZigZag(TreeNode root) {
        longestZigZag(root, 0, 0);
        longestZigZag(root, 1, 0);
        return answer;
    }

    private void longestZigZag(TreeNode root, int direction, int currentLength) {
        if(root==null) {
            return;
        }
        answer =Math.max(answer, currentLength);
        if(direction==0) { //left
            longestZigZag(root.right, 1, currentLength+1); //이음
            longestZigZag(root.left, 0, 1); //새로
        } else {
            longestZigZag(root.left, 0, currentLength+1);
            longestZigZag(root.right, 1, 1);
        }
    }
}
