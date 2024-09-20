package leetcode;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) {
            return null;
        }
        var root = new TreeNode(nums[nums.length/2]);
        var leftArray = Arrays.copyOfRange(nums,0,nums.length/2);
        var rightArray = Arrays.copyOfRange(nums,nums.length/2+1,nums.length);
        root.left=sortedArrayToBST(leftArray);
        root.right=sortedArrayToBST(rightArray);
        return root;
    }
}
