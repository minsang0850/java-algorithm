package leetcode;

public class MaxConsecutiveOnes3_1004 {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int zeroes = 0;
        for (int right=0; right<nums.length; right++) {
            if(nums[right] == 0) {
                zeroes++;
                while(zeroes > k) {
                    if(nums[left] == 0) {
                        zeroes--;
                    }
                    left++;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}
