package programmers.algorithm.heap;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        var pq = new PriorityQueue<Integer>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while (true){
            var firstScoville = pq.poll();
            if(firstScoville>=K) {
                break;
            }
            if(pq.isEmpty()){
                return -1;
            }
            var secondScoville = pq.poll();
            pq.add(fusion(firstScoville, secondScoville));
            answer++;
        }

        return answer;
    }

    int fusion(int a, int b) {
        return a + b * 2;
    }

}
