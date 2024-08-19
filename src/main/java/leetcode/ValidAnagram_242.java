package leetcode;

import java.util.Arrays;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        var arr1 = s.toCharArray();
        var arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
