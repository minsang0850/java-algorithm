package programmers.algorithm.bruteforce;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 1000000;
        for (int i = 1; i <= 1000; i++) {
            for (int j = i; j <= 1000; j++) {
                var flag = true;
                for (int k = 0; k < sizes.length; k++) {
                    if (!((i >= sizes[k][0] && j >= sizes[k][1])
                            || (i >= sizes[k][1] && j >= sizes[k][0]))) {
                        flag=false;
                        break;
                    }
                }
                if (flag) {
                    answer = answer > i * j ? i * j : answer;
                }
            }
        }
        return answer;
    }
}
