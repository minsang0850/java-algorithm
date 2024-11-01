package leetcode;

import java.util.Arrays;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        var k = nums.length-1;

        for (int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                while(k>0 && nums[k]==0) {
                    k--;
                }
                if(k>i) {
                    nums[i]=nums[k];
                    nums[k]=0;
                }
            }
        }

        Arrays.sort(nums, 0, k+1);
    }
}
