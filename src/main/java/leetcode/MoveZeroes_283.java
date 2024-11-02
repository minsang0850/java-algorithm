package leetcode;

import java.util.Arrays;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        var k = 0;

        for (int i=0; i<nums.length; i++) {
            k=Math.max(k, i);
            if(nums[i]==0) {
                while(k<nums.length && nums[k]==0) {
                    k++;
                }

                if(k<nums.length) {
                    nums[i]=nums[k];
                    nums[k]=0;
                }
            }
        }

    }
}
