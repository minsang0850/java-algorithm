package leetcode;

public class NumberOf1Bits_191 {
    public int hammingWeight(int n) {
        var count = 0;
        while (n != 0) {
            var carry = n%2;
            count+=carry;
            n/=2;
        }
        return count;
    }
}
