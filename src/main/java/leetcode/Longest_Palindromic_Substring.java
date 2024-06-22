package leetcode;

public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        var answer = "";
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                if (isPalindrome(s.substring(i, i + len))) {
                    answer = s.substring(i, i + len);
                    break;
                }
            }
        }
        return answer;
    }

    private boolean isPalindrome(String substring) {
        var len = substring.length();
        for (int i=0; i<len/2; i++) {
            if(substring.charAt(i) != substring.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}
