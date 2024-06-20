package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        var p = new Longest_Substring_Without_Repeating_Characters();
//        p.lengthOfLongestSubstring("dvdf");
        p.lengthOfLongestSubstring("tmmzuxt");
    }
    public int lengthOfLongestSubstring(String s) {
        var set = new HashMap<Character, Integer>();
        var answer = 0;
        var left = 0;
        for (int i=0; i<s.length(); i++){
            if(set.containsKey(s.charAt(i)) && set.get(s.charAt(i))>=left) {
                left=set.get(s.charAt(i))+1;
                set.remove(s.charAt(i));
                set.put(s.charAt(i), i);
            } else {
                set.put(s.charAt(i), i);
                var len = i-left+1;
                if(answer<len) {
                    answer=len;
                }
            }
        }
        return answer;
    }
}
