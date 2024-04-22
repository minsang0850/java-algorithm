package programmers.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int currentIdx = 0;
        for(int[] command : commands){
            var list = new ArrayList<Integer>();
            for(int i=command[0]-1; i<command[1]; i++) {
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[currentIdx]= list.get(command[2]-1);
            currentIdx++;
        }
        return answer;
    }
}
