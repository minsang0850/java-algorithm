package leetcode;

public class NthTribonacciNumber_1137 {
    int[] dp = new int[38];
    public int tribonacci(int n) {
        if(dp[n] != 0) return dp[n];
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        var result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        dp[n] = result;
        return result;
    }
}
