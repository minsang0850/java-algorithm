package leetcode;

import java.util.ArrayList;

public class ReverseVowelsOfString_345 {
    public static void main(String[] args) {
        var p = new ReverseVowelsOfString_345();
        p.reverseVowels("IceCreAm");
    }
    public String reverseVowels(String s) {
        var moeums = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        var list = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            for (int j = 0; j < 10; j++) {
                if (moeums[j] == c) {
                    list.add(i);
                    break;
                }
            }
        }

        var answer = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(i);
        }

        for (int i = 0; i < list.size() / 2; i++) {
            var idx = list.get(i);
            int j = list.size() - i - 1;
            var idx2 = list.get(j);
            var temp = s.charAt(idx);
            answer[idx] = s.charAt(idx2);
            answer[idx2] = temp;
        }
        return String.valueOf(answer);
    }
}
