package programmers.algorithm.dp;

import java.util.Arrays;

public class 정수_삼각형 {
    public static void main(String[] args) {
        var p = new 정수_삼각형();
        p.solution(new int[][]{new int[]{7}, new int[]{3, 8}, new int[]{8, 1, 0}});
    }
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i=1; i<triangle.length; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                var current = triangle[i][j];
                if(j+1 == triangle[i].length){
                    triangle[i][j] = triangle[i-1][j-1] + current;
                }
                else if(j == 0){
                    triangle[i][j] = triangle[i-1][0] + current;
                }
                else {
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + current;
                }
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }
}
