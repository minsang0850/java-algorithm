package programmers.introduction;

import java.math.*;

public class 분수의_덧셈 {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        for (int i=2; i<=denom; i++) {
            if(numer%i==0 && denom%i==0){
                numer/=i;
                denom/=i;
                i=1;
            }
        }
        answer[0]=numer;
        answer[1]=denom;
        return answer;
    }
}
