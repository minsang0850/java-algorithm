package leetcode;

import java.util.*;

public class Three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var set = new HashSet<List<Integer>>();
        var flag = false;
        for (int i=0; i<nums.length-2; i++) {
            var check = nums.length-1;
            for (int j=i+1; j<nums.length-1; j++) {
                if(nums[i]+nums[j]>0) {
                    break;
                }
                while (check>j && nums[i]+nums[j]+nums[check]>0) {
                    check--;
                }
                if(check==j) {
                    break;
                }
                if(nums[i]+nums[j]+nums[check]==0) {
                    set.add(List.of(nums[i], nums[j], nums[check]));
                    continue;
                }
                check= nums.length-1;
            }
            if(flag) {
                break;
            }
        }
        return new ArrayList<>(set);
    }

}
