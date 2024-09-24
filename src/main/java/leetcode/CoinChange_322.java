package leetcode;

public class CoinChange_322 {
    int[] dp = new int[10001];
    public int coinChange(int[] coins, int amount) {
        if(amount==0) {
            return 0;
        }
        if(dp[amount]!=0) {
            return dp[amount];
        }
        var answer = 987654321;
        for (int i=0; i<coins.length; i++){
            var target = amount- coins[i];
            if(target<0) {
                continue;
            }
            var count = coinChange(coins, target);
            if(count==-1) {
                continue;
            }
            answer = Math.min(answer, coinChange(coins, target) + 1);
        }
        if(answer==987654321) {
            answer = -1;
        }
        dp[amount] = answer;
        return answer;
    }
}
