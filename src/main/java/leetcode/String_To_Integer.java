package leetcode;

public class String_To_Integer {
    public int myAtoi(String s) {
        var str = s.trim();
        if (str.isEmpty()) {
            return 0;
        }
        var isNegative = str.charAt(0) == '-';
        var isPositive = str.charAt(0) == '+';
        if (isNegative || isPositive) {
            str = str.substring(1);
        }
        var result = 0;
        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            var digit = c - '0';
            if (isNegative) {
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit > 8)) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 - digit;
            } else {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return Integer.MAX_VALUE;
                }
                result = result * 10 + digit;
            }
        }
        return result;
    }
}
