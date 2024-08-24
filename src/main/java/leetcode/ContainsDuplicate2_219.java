package leetcode;

import java.util.HashMap;

public class ContainsDuplicate2_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            else {
                var prev = map.get(nums[i]);
                if (i - prev <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
