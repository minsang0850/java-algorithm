package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        var values = map.values();
        var set = new HashSet<>(values);
        return values.size() == set.size();
    }
}
