package leetcode;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        var p= new ValidPalindrome_125();
        p.isPalindrome("0P");
    }
    public boolean isPalindrome(String s) {
        var cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        var left = 0;
        var right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
