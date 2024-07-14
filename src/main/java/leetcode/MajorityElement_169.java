package leetcode;


import java.util.HashMap;
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        var keySet = map.keySet();
        var max = 0;
        var maxKey = 0;
        for (var key: keySet) {
            if(map.get(key) > max) {
                max = map.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }
}
