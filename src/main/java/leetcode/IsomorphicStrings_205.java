package leetcode;

import java.util.HashMap;

public class IsomorphicStrings_205 {
    public static void main(String[] args) {
        var p = new IsomorphicStrings_205();
        p.getScore("abcdefghijklmnopqrstuvwxyzva");
        p.getScore("abcdefghijklmnopqrstuvwxyzck");
    }
    public boolean isIsomorphic(String s, String t) {
        return getScore(s).equals(getScore(t));
    }

    private String getScore(String s) {
        var map = new HashMap<Character, Integer>();
        var score = new StringBuilder();
        var k=0;
        for (int i=0; i<s.length(); i++) {
            var c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, k++);
            }
            score.append(map.get(c) +'a');
        }
        var result = score.toString();
        return result;
    }
}
