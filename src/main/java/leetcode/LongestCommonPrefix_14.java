package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();
        Arrays.sort(strs);
        var first = strs[0];
        var last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return answer.toString();
            }
            answer.append(first.charAt(i));
        }
        return answer.toString();
    }
}
