package leetcode;

public class greatestCommonDivisorOfStrings_1071 {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int length1, int length2) {
        if(length2 == 0) {
            return length1;
        }
        return gcd(length2, length1 % length2);
    }
}
