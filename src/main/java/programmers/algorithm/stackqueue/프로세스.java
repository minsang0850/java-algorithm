package programmers.algorithm.stackqueue;

import java.util.*;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        var reverseSorted = new int[priorities.length];
        for (int i=0; i<priorities.length; i++) {
            reverseSorted[i]=priorities[i];
        }
        Arrays.sort(reverseSorted);
        var sorted = new int[priorities.length];
        for (int i=0; i<sorted.length; i++) {
            sorted[i] = reverseSorted[sorted.length-i-1];
        }
        var currentMaxValueIdx = 0;

        for (int i = 0; ; i++) {
            int idx = i%priorities.length;
            if(sorted[currentMaxValueIdx]==priorities[idx]) {
                priorities[idx]=-1;
                answer++;
                currentMaxValueIdx++;
                if(idx ==location){
                    break;
                }
            }
        }
        return answer;
    }
}
