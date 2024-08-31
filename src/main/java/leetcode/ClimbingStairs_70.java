package leetcode;

public class ClimbingStairs_70 {
    int[] dp = new int[46];
    public int climbStairs(int n) {
        if(n==1) {
            dp[1] = 1;
            return 1;
        }
        if(n==2) {
            dp[2] = 2;
            return 2;
        }
        if(dp[n]!=0) {
            return dp[n];
        }
        dp[n]= climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
    }
}
