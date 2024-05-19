package hackerrank;

import java.util.List;

public class Diagonal_difference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        var left = 0;
        var right = 0;
        for (int i = 0; i < arr.size(); i++) {
            left += arr.get(i).get(i);
            right += arr.get(arr.size() - i - 1).get(i);
        }
        return Math.abs(left - right);
    }
}
