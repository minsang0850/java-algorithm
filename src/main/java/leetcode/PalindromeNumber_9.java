package leetcode;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        var string = String.valueOf(x);
        for (int i=0; i<string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
