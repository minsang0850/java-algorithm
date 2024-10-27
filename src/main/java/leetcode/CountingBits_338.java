package leetcode;

public class CountingBits_338 {
    public int[] countBits(int n) {
        var answer = new int[n+1];
        for (int i=1; i<n+1; i++) {
            answer[i]=answer[i>>1] + i%2;
        }
        return answer;
    }
}
