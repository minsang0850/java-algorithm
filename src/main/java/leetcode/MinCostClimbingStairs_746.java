package leetcode;

public class MinCostClimbingStairs_746 {
    int[] dp = new int[1000];
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }

    private int minCostClimbingStairs(int[] cost, int n) {
        if(n>=cost.length) {
            return 0;
        }
        if(dp[n]!=0) {
            return dp[n];
        }
        var a = cost[n]+minCostClimbingStairs(cost, n+1);
        var b = cost[n]+minCostClimbingStairs(cost,n+2);
        if(a<b) {
            dp[n]=a;
            return a;
        }
        dp[n]=b;
        return b;
    }
}
