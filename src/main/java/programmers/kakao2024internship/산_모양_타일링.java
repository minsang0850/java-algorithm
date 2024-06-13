package programmers.kakao2024internship;

public class 산_모양_타일링 {

    public static void main(String[] args) {
        var p = new 산_모양_타일링();
        p.solution(4, new int[]{1, 1, 0, 1});
    }

    int dp[][];

    public int solution(int n, int[] tops) {
        final int MOD = 10007;
        dp = new int[2][n + 1];
        dp[0][n] = 1;
        dp[1][n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (tops[i] == 1) {
                dp[0][i] = (dp[0][i + 1] * 3 + dp[1][i + 1] * 2) % MOD;
                dp[1][i] = (dp[0][i + 1] * 1 + dp[1][i + 1] * 1) % MOD;
            } else {
                dp[0][i] = (dp[0][i + 1] * 2 + dp[1][i + 1] * 1) % MOD;
                dp[1][i] = (dp[0][i + 1] * 1 + dp[1][i + 1] * 1) % MOD;
            }
        }
        return (dp[0][0] + dp[1][0]) % MOD;
    }
}
