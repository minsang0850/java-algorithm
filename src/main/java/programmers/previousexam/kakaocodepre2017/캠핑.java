package programmers.previousexam.kakaocodepre2017;

import java.util.ArrayList;
import java.util.Arrays;

public class 캠핑 {
    public static void main(String[] args) {
        var p = new 캠핑();
        p.solution(4, new int[][]{new int[]{0, 0}, new int[]{1, 1},
                new int[]{0, 2}, new int[]{2, 0}});
        p.solution(5, new int[][]{new int[]{0, 0}, new int[]{1, 1},
                new int[]{0, 2}, new int[]{2, 0}, new int[]{2, 2}});
    }

    public int solution(int n, int[][] data) {
        sort(data);
        int answer = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i][0] == data[j][0] || data[i][1] == data[j][1]) {
                    continue;
                }
                var flag = true;
                for(int k=i+1; k<j; k++) {
                    if((data[i][0]<data[k][0] &&
                            data[k][0] <data[j][0]) &&
                            Math.min(data[i][1], data[j][1])< data[k][1] &&
                            Math.max(data[i][1], data[j][1]) > data[k][1]) {
                        flag= false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void sort(int[][] data) {
        Arrays.sort(data, (a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else if (a[0] == b[0]) {
                if (a[1] < b[1]) {
                    return -1;
                }
            }
            return 1;
        });
    }
}
