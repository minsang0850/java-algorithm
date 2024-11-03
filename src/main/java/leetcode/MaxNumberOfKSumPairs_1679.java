package leetcode;

import java.util.HashMap;

public class MaxNumberOfKSumPairs_1679 {
    public int maxOperations(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        var answer = 0;
        for (int key : map.keySet()) {
            var value = map.get(key);
            if (value <= 0) {
                continue;
            }
            var key2 = k - key;
            if(key==key2) {
                var min = value/2;
                answer += min;
                map.put(key, value - min);
                continue;
            }
            if (map.containsKey(key2)) {
                var value2 = map.get(key2);
                if (value2 <= 0) {
                    continue;
                }
                var min = Math.min(value, value2);
                answer += min;
                map.put(key, value - min);
                map.put(key2, value2 - min);
            }
        }
        return answer;
    }
}
