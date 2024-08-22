package leetcode;

import java.util.HashSet;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        var set = new HashSet<Integer>();
        set.add(n);
        while (n>1) {
            n=getSquareSum(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    private int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
