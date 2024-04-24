package programmers.algorithm.greedy;

import java.util.Arrays;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i=0; i<lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    lost[i]=-1;
                    reserve[j]=-1;
                }
            }
        }
        for (int lostStudent : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lostStudent - 1
                    || reserve[j] == lostStudent
                    || reserve[j] == lostStudent + 1) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return n - lost.length + answer;
    }
}
