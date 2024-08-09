package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        var p = new LongestSubstringWithoutRepeatingCharacters_3();
//        p.lengthOfLongestSubstring("dvdf");
        p.lengthOfLongestSubstring("tmmzuxt");
    }
    public int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character, Integer>();
        var answer = 0;
        var left = 0;
        for (int right=0; right<s.length(); right++){
            if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right))>=left) {
                left=map.get(s.charAt(right))+1;
                map.remove(s.charAt(right));
                map.put(s.charAt(right), right);
            } else {
                map.put(s.charAt(right), right);
                answer = Math.max(answer, right-left+1);
            }
        }
        return answer;
    }
}
