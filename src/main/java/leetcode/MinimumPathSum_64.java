package leetcode;

public class MinimumPathSum_64 {
    int[][] dp = new int[201][201];
    public int minPathSum(int[][] grid) {
        for (int i=0; i<201; i++) {
            for (int j=0; j<201; j++) {
                dp[i][j] = -1;
            }
        }
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int x, int y) {
        if(dp[x][y]!=-1) {
            return dp[x][y];
        }
        if(x==grid.length-1 && y==grid[0].length-1) {
            dp[x][y] = grid[x][y];
            return grid[x][y];
        }
        if(x==grid.length || y==grid[0].length) {
            return 987654321;
        }
        var minSum = grid[x][y]+ Math.min(minPathSum(grid, x+1, y), minPathSum(grid, x, y+1));
        dp[x][y] = minSum;
        return minSum;
    }
}
