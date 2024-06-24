package leetcode;

public class Reverse_Integer {
    public int reverse(int x) {
        var originString = String.valueOf(x);
        var isNegative = originString.charAt(0) == '-';
        if(isNegative) {
            originString = originString.substring(1);
        }
        var reversed = reverse(originString);
        if(isNegative) {
            reversed = "-" + reversed;
        }
        try {
            return Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String reverse(String originString) {
        StringBuilder result = new StringBuilder();
        for (int i = originString.length() - 1; i >= 0; i--) {
            result.append(originString.charAt(i));
        }
        return result.toString();
    }
}
