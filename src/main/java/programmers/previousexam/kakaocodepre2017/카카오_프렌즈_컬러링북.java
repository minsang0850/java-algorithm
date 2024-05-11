package programmers.previousexam.kakaocodepre2017;

public class 카카오_프렌즈_컬러링북 {
    int[][] picture;
    int m;
    int n;
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.picture = picture;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                var size = bfs(i, j, picture[i][j]);
                if (size > 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int x, int y, int color) {
        //범위 초과
        if (x >= m || x < 0 || y >= n || y < 0) {
            return 0;
        }
        //이미 체크됨 혹은 무색
        if (picture[x][y] == 0) {
            return 0;
        }
        // 다른 색인 경우 아무것도 하지 않음
        if (color != picture[x][y]) {
            return 0;
        }
        picture[x][y]=0;
        return 1
                + bfs(x + 1, y, color)
                + bfs(x, y + 1, color)
                + bfs(x - 1, y, color)
                + bfs(x, y - 1, color);
    }
}

// [1, 1, 1, 0]
// [1, 2, 2, 0]
// [1, 0, 0, 1]
// [0, 0, 0, 1]
// [0, 0, 0, 3]
// [0, 0, 0, 3]