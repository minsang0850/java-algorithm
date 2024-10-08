package leetcode;

public class UniquePaths2_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        return dfs(obstacleGrid, m, n, 0, 0, dp);
    }

    private int dfs(int[][] obstacleGrid, int m, int n, int x, int y, int[][] dp) {
        if(x >= m || y >= n) {
            return 0;
        }
        if(obstacleGrid[x][y] == 1) {
            return 0;
        }
        if(x == m - 1 && y == n - 1) {
            return 1;
        }
        if(dp[x][y] > 0) {
            return dp[x][y];
        }
        int right = dfs(obstacleGrid, m, n, x, y + 1, dp);
        int down = dfs(obstacleGrid, m, n, x + 1, y, dp);
        dp[x][y] = right + down;
        return dp[x][y];
    }
}
