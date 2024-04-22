package programmers.algorithm.sort;

import java.util.Arrays;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            var h = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, h);
        }
        return answer;
    }
}
