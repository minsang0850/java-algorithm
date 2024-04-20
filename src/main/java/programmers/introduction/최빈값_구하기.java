package programmers.introduction;

public class 최빈값_구하기 {

    public static void main(String[] args) {
        var solution = new 최빈값_구하기();
        solution.solution(new int[]{1});
    }
    static int[] recordArray;

    public int solution(int[] array) {
        init();
        int answer = 0;
        int maxCalled = 0;
        for(int number : array) {
            recordArray[number] ++;
        }
        for(int i =0; i<1001; i++) {
            if(maxCalled<recordArray[i]){
                maxCalled=recordArray[i];
            }
        }
        int duplicateAnswer = 0;
        for(int i =0; i<1001; i++) {
            if(maxCalled==recordArray[i]){
                answer = i;
                duplicateAnswer++;
            }
        }
        if(duplicateAnswer>1){
            return -1;
        }
        return answer;
    }

    private void init() {
        recordArray = new int[1001];
        for(int i=0; i<1001; i++){
            recordArray[i]=0;
        }
    }
}
