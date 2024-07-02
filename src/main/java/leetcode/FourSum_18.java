package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        long[] nums = new long[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums);
        var set = new HashSet<List<Integer>>();
        for (int i=0; i<nums.length-3; i++) {
            for (int j=i+1; j<nums.length-2; j++) {
                var check1 = nums.length-1;
                for (int k=j+1; k<nums.length-1; k++) {
                    while (check1 > k && nums[i] + nums[j] + nums[k] +nums[check1] > target) {
                        check1--;
                    }
                    if (check1 == k) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[k] + nums[check1] == target) {
                        set.add(List.of((int)nums[i], (int)nums[j], (int)nums[k], (int)nums[check1]));
                        continue;
                    }
                    check1 = nums.length - 1;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
