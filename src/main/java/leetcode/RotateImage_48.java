package leetcode;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        rotate(matrix, 0, matrix.length);
    }

    private void rotate(int[][] matrix, int start, int length) {
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            var temp = matrix[start][start + i];
            matrix[start][start + i] = matrix[start + length - 1 - i][start];
            matrix[start + length - 1 - i][start] = matrix[start+length-1][start+length-1-i];
            matrix[start+length-1][start+length-1-i] = matrix[start+i][start+length-1];
            matrix[start+i][start+length-1] = temp;
        }
        rotate(matrix, start+1, length-2);
    }
}
