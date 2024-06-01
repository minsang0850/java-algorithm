package programmers.summercoding2018;

import java.util.Arrays;

//1, 3, 5, 7
//2, 2, 6, 8
public class 숫자_게임 {
    public static void main(String[] args) {
        var p = new 숫자_게임();
        p.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8});
    }
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        var check = A.length - 1;
        for (int i = B.length - 1; i >= 0; i--) {
            while (check >= 0 && A[check] >= B[i]) {
                check--;
            }
            if(check>=0){
                answer++;
                check--;
            } else {
                return answer;
            }
        }
        return answer;
    }
}
