package leetcode;

import java.util.Collections;

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        var tempArray = new int[k];
        if (nums.length - (nums.length - k) >= 0)
            System.arraycopy(nums, nums.length - k, tempArray, nums.length - k - (nums.length - k), nums.length - (nums.length - k));

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        System.arraycopy(tempArray, 0, nums, 0, k);
    }
}

/**
 * Solution
 */
//class Solution {
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        reverse(nums, 0, nums.length-1);
//        reverse(nums, 0, k-1);
//        reverse(nums, k, nums.length-1);
//    }
//
//    public void reverse(int[] nums, int start, int end){
//        while(start < end){
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
//}