package programmers.practice.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            if(n>=enemy[i]) {
                n-=enemy[i];
                pq.add(enemy[i]);
                answer++;
            } else if(k==0) {
                return answer;
            } else {
                k--;
                pq.add(enemy[i]);
                var polled = pq.poll();
                n+=polled;
                n-=enemy[i];
                answer++;
            }
        }
        return answer;
    }
}
