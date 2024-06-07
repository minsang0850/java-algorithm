package programmers.summercoding2018;

public class 스티커_모으기 {
    int[][][] dp = new int[100001][2][2]; // n번까지, 0번을 뜯었을때 1, n번을 뜯었을때 1
    int answer = 0;
    public int solution(int sticker[]) {
        if (sticker.length == 1) {
            return sticker[0];
        }

        // 고려할 점 1: 0번째를 뜯냐 안뜯냐. n-1번에 영향을 주기 때문
        // k까지 뜯었을때 최댓값.
        //

        dp[0][0][0] = 0;
        dp[0][1][1] = sticker[0];
        dp[1][0][0] = 0;
        dp[1][0][1] = sticker[1];
        dp[1][1][0] = sticker[0];
        dp[1][1][1] = -1;

        for (int i = 2; i < sticker.length-1; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            dp[i][0][1] = dp[i - 1][0][0] + sticker[i];
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1]);
            dp[i][1][1] = dp[i - 1][1][0] + sticker[i];
            getAnswer(i);
        }
        var last = sticker.length-1;
        dp[last][0][0] = Math.max(dp[last - 1][0][0], dp[last - 1][0][1]);
        dp[last][0][1] = dp[last - 1][0][0] + sticker[last];
        dp[last][1][0] = Math.max(dp[last - 1][1][0], dp[last - 1][1][1]);
        getAnswer(last);

        return answer;
    }

    private void getAnswer(int i) {
        answer=Math.max(dp[i][0][0], answer);
        answer=Math.max(dp[i][0][1], answer);
        answer=Math.max(dp[i][1][0], answer);
        answer=Math.max(dp[i][1][1], answer);
    }
}
