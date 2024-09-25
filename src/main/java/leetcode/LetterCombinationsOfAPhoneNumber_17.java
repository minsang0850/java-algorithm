package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return List.of();
        }
        var map = new HashMap<String, List<Character>>();
        map.put("2", List.of('a', 'b', 'c'));
        map.put("3", List.of('d', 'e', 'f'));
        map.put("4", List.of('g', 'h', 'i'));
        map.put("5", List.of('j', 'k', 'l'));
        map.put("6", List.of('m', 'n', 'o'));
        map.put("7", List.of('p', 'q', 'r', 's'));
        map.put("8", List.of('t', 'u', 'v'));
        map.put("9", List.of('w', 'x', 'y', 'z'));
        return dfs(digits, 0, map, "");
    }

    private List<String> dfs(String digits, int i, HashMap<String, List<Character>> map, String s) {
        if (i == digits.length()) {
            return List.of(s);
        }
        var digit = String.valueOf(digits.charAt(i));
        var chars = map.get(digit);
        var result = new ArrayList<String>();
        for (var c : chars) {
            result.addAll(dfs(digits, i + 1, map, s + c));
        }
        return result;
    }

}
