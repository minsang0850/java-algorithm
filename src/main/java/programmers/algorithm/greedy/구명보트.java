package programmers.algorithm.greedy;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        var p = new 구명보트();
        p.solution(new int[]{10, 30, 30, 40, 90}, 100);
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        if(people.length==1){
            return 1;
        }
        Arrays.sort(people);
        var notYetIdx = people.length-1;
        for (int i=0; i<=notYetIdx; i++) {
            while (people[i] + people[notYetIdx] >limit && i<notYetIdx){
                answer++;
                notYetIdx--;
            }
            if(i==notYetIdx){
                answer++;
                break;
            }
            if(people[i] + people[notYetIdx] <=limit){
                notYetIdx--;
                answer++;
            }
        }
        return answer;
    }
}
