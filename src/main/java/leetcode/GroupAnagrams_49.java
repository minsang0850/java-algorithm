package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            var sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return map.keySet()
                  .stream()
                  .map(map::get)
                  .toList();
    }
}
