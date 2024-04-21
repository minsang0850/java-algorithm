package programmers.algorithm.stackqueue;

import java.util.ArrayList;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        var answer = new ArrayList<Integer>();
        answer.add(arr[0]);
        var prev = arr[0];
        for (int i=1; i<arr.length; i++){
            if(prev != arr[i]){
                prev = arr[i];
                answer.add(prev);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
