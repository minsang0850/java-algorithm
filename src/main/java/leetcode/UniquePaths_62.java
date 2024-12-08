package leetcode;

public class UniquePaths_62 {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[m-1][n-1] = 1;
        return dp(m, n, 0, 0);
    }

    private int dp(int m, int n, int x, int y) {
        if(x >= m || y >= n) {
            return 0;
        }
        if(dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = dp(m, n, x+1, y) + dp(m, n, x, y+1);
        return dp[x][y];
    }
}
