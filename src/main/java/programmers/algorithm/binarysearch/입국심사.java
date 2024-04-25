package programmers.algorithm.binarysearch;

import java.util.Arrays;

public class 입국심사 {

    public static void main(String[] args) {
        var p = new 입국심사();
        p.solution(6, new int[]{7, 10});
    }

    public long solution(int n, int[] times) {
        long answer = 1;
        Arrays.sort(times);
        while (true) {
            var sum = 0;
            for (int time: times){
                sum += answer/time;
            }
            if(sum<n){
                answer*=2;
            } else {
                break;
            }
        }
        return find(answer/2, answer, times, n);
    }

    private long find(long min, long max, int[] times, int n) {
        long predicate = (min + max) / 2;
        if(min+1>=max){
            return max;
        }
        var sum = 0;
        for (int time: times){
            sum += predicate/time;
        }
        if(sum>=n){
            return find(min, predicate, times, n);
        }
        return find(predicate, max, times, n);
    }

}
