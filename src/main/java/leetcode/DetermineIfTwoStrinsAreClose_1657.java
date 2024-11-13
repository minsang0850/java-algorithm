package leetcode;

import java.util.HashMap;

public class DetermineIfTwoStrinsAreClose_1657 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!= word2.length()) return false;

        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();

        for (int i=0; i<word1.length(); i++) {
            var c1 = word1.charAt(i);
            var c2 = word2.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }
        var keyset1 = map1.keySet().stream().sorted().toList();
        var keyset2 = map2.keySet().stream().sorted().toList();

        if(keyset1.size()!= keyset2.size()) return false;
        for (int i=0; i<keyset1.size(); i++) {
            if(keyset1.get(i)!= keyset2.get(i)) return false;
        }
        var values1 = map1.values().stream().sorted().toList();
        var values2 = map2.values().stream().sorted().toList();

        if(values1.size()!= values2.size()) return false;
        for (int i=0; i<values1.size(); i++) {
            if(!values1.get(i).equals(values2.get(i))) return false;
        }
        return true;
    }

}
