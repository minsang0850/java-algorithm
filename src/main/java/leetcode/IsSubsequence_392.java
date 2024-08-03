package leetcode;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int current = 0;
        for (int i = 0; i<t.length() && current<s.length(); i++) {
            if(s.charAt(current)==t.charAt(i)) {
                current++;
            }
        }
        return current == s.length();
    }
}
