package leetcode;

public class MaximumSubarray_53 {
    /**
     * https://leetcode.com/problems/maximum-subarray/solutions/5378437/video-simple-solution/
     * 더 간단한 풀이
     */
    public int maxSubArray(int[] nums) {
        var prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        var answer = nums[0];
        var min = 0;
        for (int i = 0; i < nums.length; i++) {
            answer = Math.max(answer, prefixSum[i] - min);
            min = Math.min(min, prefixSum[i]);
        }
        return answer;
    }
}
