package leetcode;

public class Search2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        var rows = matrix.length;
        var cols = matrix[0].length;
        var left = 0;
        var right = rows * cols - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            var row = mid / cols;
            var col = mid % cols;

            var value = matrix[row][col];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
