package leetcode;

import java.util.List;

public class DominoAndTrominoTiling_790 {
    long[] dp = new long[1001];
    public int numTilings(int n) {
        if(dp[n] != 0) {
            return (int) dp[n];
        }
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        if(n==3) {
            return 5;
        }
        dp[n] = (numTilings(n-1) + numTilings(n-2)) % 1000000007;
        for (int i=n-3; i>=0; i--){
            dp[n] = dp[n] +  numTilings(i) * 2;
            dp[n]= dp[n] % 1000000007;
        }
        return (int)dp[n];
    }
}
