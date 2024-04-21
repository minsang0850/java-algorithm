package programmers.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        var p = new 이중우선순위큐();
        p.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
    }
    public int[] solution(String[] operations) {
        var pq = new PriorityQueue<Integer>();
        var reversePq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("D -1")) {
                if(!pq.isEmpty()) {
                    var minDeleted = pq.poll();
                    reversePq.remove(minDeleted);
                }
            } else if (operations[i].equals("D 1")) {
                if(!reversePq.isEmpty()){
                    var maxDeleted = reversePq.poll();
                    pq.remove(maxDeleted);
                }
            } else {
                var splited = operations[i].split(" ");
                var number = Integer.parseInt(splited[1]);
                pq.add(number);
                reversePq.add(number);
            }
        }
        if(reversePq.isEmpty() || pq.isEmpty()) {
            return new int[]{0, 0};
        }
        var max = reversePq.poll();
        var min = pq.poll();
        return new int[]{max, min};
    }
}
