package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Three_sum_closest {

    public static void main(String[] args) {
        var p = new Three_sum_closest();
        p.threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        var answer = nums[0]+nums[1]+nums[2];
        for (int i=0; i<nums.length-2; i++) {
            var check = nums.length-1;
            for (int j=i+1; j<nums.length-1; j++) {
                while (check>j && nums[i]+nums[j]+nums[check]>target) {
                    check--;
                }
                if(check==j) {
                    var sum = nums[i] + nums[j] + nums[check + 1];
                    if (Math.abs(sum - target) < Math.abs(answer - target)) {
                        answer = sum;
                    }
                    break;
                }
                var sum = nums[i]+nums[j]+nums[check];
                if(Math.abs(sum-target) < Math.abs(answer-target)) {
                    answer = sum;
                }
                if(check+1<nums.length) {
                    sum = nums[i] + nums[j] + nums[check + 1];
                    if (Math.abs(sum - target) < Math.abs(answer - target)) {
                        answer = sum;
                    }
                }
                if(nums[i]+nums[j]+nums[check]==target) {
                    return target;
                }
            }
        }
        return answer;
    }
}
