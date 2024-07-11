package leetcode;

import java.util.Arrays;

public class RemoveElement_27 {
    public static void main(String[] args) {
        var p = new RemoveElement_27();
        p.removeElement(new int[]{3,2,2,3}, 3);
    }
    public int removeElement(int[] nums, int val) {
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[current++] = nums[i];
            }
        }
        return current;
    }
}
