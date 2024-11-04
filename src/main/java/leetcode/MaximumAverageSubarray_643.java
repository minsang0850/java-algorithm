package leetcode;

public class MaximumAverageSubarray_643 {
    public double findMaxAverage(int[] nums, int k) {
        double avg=0;

        for (int i=0; i<k; i++) {
            avg+= nums[i];
        }
        avg = avg/(double)k;
        double answer = avg;

        for (int i=k;  i<nums.length; i++) {
            double temp = nums[i];
            temp = temp/(double)k;
            avg = avg + (temp - nums[i-k]/(double)k);
            answer = Math.max(avg,answer);
        }

        return answer;
    }

}
