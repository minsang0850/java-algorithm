package leetcode;

public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        var current = 0;
        var num = -101;
        for (int i=0; i<nums.length; i++) {
            if(nums[i]==num) {
                continue;
            }
            nums[current++] = nums[i];
            num = nums[i];
        }
        return current;
    }
}
