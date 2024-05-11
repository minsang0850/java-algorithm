package programmers.previousexam.kakaocodepre2017;

import java.util.Arrays;

public class 보행자_천국 {
    public static void main(String[] args) {
        var p = new 보행자_천국();
        p.solution(3, 3, new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}});
        p.solution(3, 6, new int[][]{new int[]{0, 2, 0, 0, 0, 2}, new int[]{0, 0, 2, 0, 1, 0}, new int[]{1, 0, 0, 2, 2, 0}});
        // [-1 ,-1, -1, -1, -1, -1]
        // [+0, +0, +0, -1, -1, -1]
        // [+0, +0, +0, +0, -1, -1]
    }

    int MOD = 20170805;
    int[][][] dp;

    public int solution(int m, int n, int[][] cityMap) {
        dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        var answer = (dp(1, 0, m, n, cityMap, Direction.DOWN.getCode()) + dp(0, 1, m, n, cityMap, Direction.RIGHT.getCode()))%MOD;
        return answer;
    }

    private int dp(int currentX, int currentY, int m, int n, int[][] cityMap, int code) {
        //나간 케이스
        if (currentX >= m || currentY >= n) {
            return 0;
        }
        //dp 케이스
        if (currentX == m - 1 && currentY == n - 1) {
            return 1;
        }
        if (dp[currentX][currentY][code] != -1) {
            return dp[currentX][currentY][code];
        }
        // 진입 금지
        if (cityMap[currentX][currentY] == 1) {
            dp[currentX][currentY][code] = 0;
            return 0;
        }
        var direction = Direction.getByCode(code);
        // 오던 방향 이동만 가능
        var answer = 0;
        if (cityMap[currentX][currentY] == 2) {
            if (direction == Direction.DOWN) {
                answer = dp(currentX + 1, currentY, m, n, cityMap, Direction.DOWN.getCode()) % MOD;
            } else { //RIGHT
                answer = dp(currentX, currentY + 1, m, n, cityMap, Direction.RIGHT.getCode()) % MOD;
            }
        } else {
            answer = (dp(currentX + 1, currentY, m, n, cityMap, Direction.DOWN.getCode())
                    + dp(currentX, currentY + 1, m, n, cityMap, Direction.RIGHT.getCode())) % MOD;
        }
        dp[currentX][currentY][code] = answer;
        return answer;
    }

    enum Direction {
        DOWN(0),
        RIGHT(1);

        private final int code;

        Direction(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Direction getByCode(int code) {
            return Arrays.stream(values()).filter(a -> a.getCode() == code)
                    .findFirst().get();
        }
    }
}
