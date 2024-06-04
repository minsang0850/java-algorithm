package programmers.summercoding2018;

public class 배달 {
    public static void main(String[] args) {
        var p = new 배달();
        p.solution(5, new int[][]{new int[]{1,2,1},new int[]{2,3,3},new int[]{5,2,2},new int[]{1,4,2},new int[]{5,3,1},new int[]{5,4,2}}, 3);
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 1;

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                graph[i][j] = 654321;
            }
        }
        for (int i = 0; i < road.length; i++) {
            var roadd = road[i];
            if (graph[roadd[0]][roadd[1]] > roadd[2]) {
                graph[roadd[0]][roadd[1]] = roadd[2];
                graph[roadd[1]][roadd[0]] = roadd[2];
            }
        }

        var distance = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            distance[i] = graph[1][i];
        }
        var flags = new boolean[N + 1];
        flags[1] = true;

        while (true) {
            //가장 가까운 노드
            var nearNode = getNearNode(distance, flags, N);
            // 다 멀면 멈춤
            if (nearNode == -1) {
                break;
            }
            // 가까운 노드가 K보다 작으면 ++
            if (distance[nearNode] <= K) {
                answer++;
                flags[nearNode] = true;
            } else {
                break;
            }
            // 거리 갱신
            for (int i = 2; i <= N; i++) {
                if (i == nearNode || flags[i]) { // 지나온 곳이나, nearNode면
                    continue;
                }
                if (distance[i] > distance[nearNode] + graph[nearNode][i]) { // 1->nearNode->i 가 더 작으면 갱신
                    distance[i] = distance[nearNode] + graph[nearNode][i];
                }
            }
        }

        return answer;
    }

    private int getNearNode(int[] distance, boolean[] flags, int n) {
        var currentMinValue = 654321;
        var answer = -1;
        for (int i = 2; i <= n; i++) {
            if (flags[i]) {
                continue;
            }
            if (currentMinValue > distance[i]) {
                currentMinValue = distance[i];
                answer = i;
            }
        }
        return answer;
    }
}
