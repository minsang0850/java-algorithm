package leetcode;

import java.util.Arrays;

public class HIndex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // 0, 1, 3, 5, 6

        for (int i=0; i<citations.length; i++) {
            if(citations[i] >= citations.length-i){
                return citations.length-i;
            }
        }
        return 0;
    }
}
