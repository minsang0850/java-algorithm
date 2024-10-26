package leetcode;

public class CountingBits_338 {
    public int[] countBits(int n) {
        var answer = new int[n+1];
        if(n==0) {
            return answer;
        }
        answer[1]=1;
        for (int i=2; i<n+1; i++) {
            var finded = find(i);
            answer[i]=answer[i-finded] + 1;
        }
        return answer;
    }

    private int find(int n) {
        for(int i=1; i<18; i++) {
            if(n<Math.pow(2, i)) {
                return (int)Math.pow(2, i-1);
            }
        }
        return -1;
    }

}
