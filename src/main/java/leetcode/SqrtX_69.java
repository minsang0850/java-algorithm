package leetcode;

public class SqrtX_69 {
    public int mySqrt(int x) {
        var left = 1;
        var right = x;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            var sqrt = x / mid;

            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
