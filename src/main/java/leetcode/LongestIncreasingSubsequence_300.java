package leetcode;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        var answer = 0;
        var dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
                answer = Math.max(answer, dp[i]);
            }
        }
        return answer+1;
    }
}
