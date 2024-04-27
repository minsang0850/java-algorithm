package programmers.algorithm.greedy;

import java.util.Arrays;

public class 단속카메라 {
    public static void main(String[] args) {
        var p = new 단속카메라();
        p.solution(new int[][]{new int[]{-20, -15},
                new int[]{-14, -5},
                new int[]{-18, -13},
                new int[]{-5, -3}});
    }

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        var endTime = routes[0][1];
        for (int i = 0; i < routes.length; i++) {
            // 시작시간이 끝나는 시간보다 작은 동안
            while (i < routes.length && endTime >= routes[i][0]) {
                endTime = Math.min(endTime, routes[i][1]);
                i++;
            }
            answer++;
            // 종료 조건 1
            if (i == routes.length) {
                break;
            }
            //
            endTime = routes[i][1];
            i--;
        }
        return answer;
    }
}
