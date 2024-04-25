package programmers.algorithm.dfsbfs;

public class 타겟_넘버 {
    public int solution(int[] numbers, int target) {
        return solution(0, numbers, target);
    }

    private int solution(int current, int[] numbers, int target) {
        if (current==numbers.length){
            var value =0;
            for (int i=0; i<numbers.length; i++) {
                value += numbers[i];
            }
            return target==value?1:0;
        }
        var a = solution(current+1, numbers, target);
        numbers[current]= -numbers[current];
        var b = solution(current+1, numbers, target);
        return a+b;
    }
}
