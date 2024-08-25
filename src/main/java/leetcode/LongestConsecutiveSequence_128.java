package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        if(set.isEmpty()) {
            return 0;
        }
        var sortedList = set.stream()
                            .sorted()
                            .toList();
        var prev = sortedList.get(0);
        var answer = 1;
        var sequence = 1;
        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i) - prev == 1) {
                sequence++;
                if(answer<sequence) {
                    answer = sequence;
                }
            } else {
                sequence=1;
            }
            prev = sortedList.get(i);
        }
        return answer;
    }
}
