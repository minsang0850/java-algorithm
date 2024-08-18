package leetcode;

import java.util.HashMap;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        var map = new HashMap<Character, String>();
        var words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i=0; i<pattern.length(); i++) {
            var c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(words[i])) {
                    return false;
                }
            }
            else {
                if(map.containsValue(words[i])){
                    return false;
                }
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
