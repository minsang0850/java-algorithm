package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter_combinations_of_a_phone_number {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            return List.of();
        }
        var answer = new ArrayList<String>();
        var map = new HashMap<Integer, List<String>>();
        map.put(2, List.of("a", "b", "c"));
        map.put(3, List.of("d", "e", "f"));
        map.put(4, List.of("g", "h", "i"));
        map.put(5, List.of("j", "k", "l"));
        map.put(6, List.of("m", "n", "o"));
        map.put(7, List.of("p", "q", "r", "s"));
        map.put(8, List.of("t", "u", "v"));
        map.put(9, List.of("w", "x", "y", "z"));
        dfs(answer, 0, "", digits, map);
        return answer;

    }

    private void dfs(ArrayList<String> answer, int idx, String str, String digits, HashMap<Integer, List<String>> map) {
        if(idx==digits.length()) {
            answer.add(str);
            return;
        }
        var num = digits.charAt(idx)-'0';
        for(var s: map.get(num)) {
            dfs(answer, idx+1, str+s, digits, map);
        }
    }
}
