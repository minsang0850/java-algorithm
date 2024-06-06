package programmers.summercoding2018;

public class 기지국_설치 {
    public static void main(String[] args) {
        var p = new 기지국_설치();
        p.solution(11, new int[]{4, 11}, 1);
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        var cover = 2 * w + 1;
        var prev = 1;
        for (int i = 0; i < stations.length; i++) {
            var station = stations[i];
            var min = station - w;
            var max = station + w;
            if (min <= prev) {
                prev = max + 1;
                continue;
            }
            var empty = min - prev;
            answer += empty / cover +
                      (empty % cover != 0
                       ? 1
                       : 0);
            prev = max + 1;
        }
        if (prev <= n) {
            var empty = n + 1 - prev;
            answer += empty / cover +
                      (empty % cover != 0
                       ? 1
                       : 0);
        }

        return answer;
    }
}
