package hackerrank;

import java.util.List;

public class A_very_big_sum {
    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        var answer = 0L;
        for (int i=0; i<ar.size(); i++){
            answer+=ar.get(i);
        }
        return answer;
    }
}
