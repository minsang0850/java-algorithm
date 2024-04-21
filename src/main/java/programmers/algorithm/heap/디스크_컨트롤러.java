package programmers.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    public static void main(String[] args) {
        var p = new 디스크_컨트롤러();
        p.solution(new int[][]{new int[]{0, 3}, new int[]{1, 9}, new int[]{2, 6}});
    }
    public int solution(int[][] jobs) {
        int sum = 0;
        var startPq = new PriorityQueue<int[]>(new StartTimeComparator());
        var throughputPq = new PriorityQueue<int[]>(new ThroughputComparator());
        for (int i = 0; i < jobs.length; i++) {
            startPq.add(jobs[i]);
        }
        var currentTime = 0;
        while (true) {
            //작업큐에 넣기
            while (true) {
                if (startPq.isEmpty()) {
                    break;
                }
                var polled = startPq.poll();
                if (polled[0] <= currentTime) {
                    throughputPq.add(polled);
                } else {
                    startPq.add(polled);
                    break;
                }
            }
            //작업큐에서 하나 실행
            if (!throughputPq.isEmpty()) {
                var polled = throughputPq.poll();
                currentTime += polled[1];
                sum += currentTime - polled[0];
            }
            if(startPq.isEmpty() && throughputPq.isEmpty()){
                break;
            }
            if(throughputPq.isEmpty()) {
                var polled = startPq.poll();
                if(currentTime<polled[0]){
                    currentTime = polled[0];
                }
                startPq.add(polled);
            }
        }
        return sum/ jobs.length;
    }

    class StartTimeComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] <= o2[0]) {
                return -1;
            }
            return 1;
        }
    }

    class ThroughputComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[1] <= o2[1]) {
                return -1;
            }
            return 1;
        }
    }
}
