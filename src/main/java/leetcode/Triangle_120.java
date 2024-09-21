package leetcode;

import java.util.List;

public class Triangle_120 {

    public static void main(String[] args) {
        var p = new Triangle_120();
//        p.minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)));
        p.minimumTotal(List.of(List.of(-1), List.of(-2, -3)));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        var dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        if(triangle.size()==1) {
            return dp[0];
        }
        var temp = new int[triangle.size()];
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    temp[j] = dp[j] + triangle.get(i).get(j);
                } else if (j == i) {
                    temp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    temp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
            for (int j = 0; j <= i; j++) {
                dp[j] = temp[j];
            }
        }
        var answer = 987654321;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }
        return answer;
    }
}
