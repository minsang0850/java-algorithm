package programmers.algorithm.bruteforce;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int i=1; i<2000; i++) {
            for (int j=i; j<2000; j++){
                if (i*j==yellow && (i+2)*(j+2)==yellow+brown){
                    return new int[]{j+2, i+2};
                }
            }
        }

        return answer;
    }
}
