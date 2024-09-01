package leetcode;

public class HouseRobber_198 {
    int[] dp = new int[101];
    public int rob(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            dp[i] = -1;
        }
        return dp(nums, nums.length-1);
    }

    private int dp(int[] nums, int i) {
        if(i<0) {
            return 0;
        }
        if(dp[i]!=-1) {
            return dp[i];
        }
        dp[i] = Math.max(dp(nums, i-1), dp(nums, i-2) + nums[i]);
        return dp[i];
    }
}
