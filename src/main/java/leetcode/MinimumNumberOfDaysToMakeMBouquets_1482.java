package leetcode;

public class MinimumNumberOfDaysToMakeMBouquets_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * (long) k > (long) bloomDay.length) {
            return -1;
        }
        var low = 1;
        var high = 1_000_000_000;
        var answer = high;
        while (low <= high) {
            var mid = (low + high) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                answer = Math.min(answer, mid);
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return answer;
    }

    private boolean isPossible(int[] bloomDay, int m, int k, int mid) {
        var count = 0;
        var consecutive = 0;
        for (int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i]<=mid) {
                consecutive++;
                if(consecutive==k) {
                    count++;
                    consecutive=0;
                }
            } else {
                consecutive=0;
            }
        }
        return count >= m;
    }
}
