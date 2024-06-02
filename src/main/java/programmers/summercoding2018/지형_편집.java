package programmers.summercoding2018;

public class 지형_편집 {

    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        var n = land.length;
        var start = 0;
        var end = 1000000000;
        var mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            var result1 = getCost(land, P, Q, n , mid);
            var result2 = getCost(land, P, Q, n , mid + 1);
            if (result1 < result2) {
                answer = Math.min(answer, result1);
                end = mid-1;
            } else {
                answer = Math.min(answer, result2);
                start = mid + 1;
            }
        }

        return answer;
    }

    private static long getCost(int[][] land, int P, int Q, int n, int height) {
        long cost = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (height < land[i][j]) {
                    cost += ((long)land[i][j] - height) * Q;
                } else if (height > land[i][j]) {
                    cost += (height - (long)land[i][j]) * P;
                }
            }
        }
        return cost;
    }
}
