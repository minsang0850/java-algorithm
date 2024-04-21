package programmers.algorithm.stackqueue;

import java.util.ArrayList;

public class 기능개발 {
    public static void main(String[] args) {
        var p = new 기능개발();
        p.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }
    public int[] solution(int[] progresses, int[] speeds) {
        var answer = new ArrayList<Integer>();
        var notCompleted = 0;
        for (int time=0; time< 100; time++) {
            int numberOfCompleted = 0;
            for (int j=notCompleted; j<progresses.length; j++) {
                if(progresses[j] + time * speeds[j] >= 100) {
                    numberOfCompleted++;
                    notCompleted++;
                }
                else {
                    break;
                }
            }
            if(numberOfCompleted > 0) {
                answer.add(numberOfCompleted);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
