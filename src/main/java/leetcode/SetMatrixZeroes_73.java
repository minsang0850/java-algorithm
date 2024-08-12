package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes_73 {
    public void setZeroes(int[][] matrix) {
        var points = new ArrayList<List<Integer>>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]==0) {
                    points.add(List.of(i, j));
                }
            }
        }

        for (List<Integer> point : points) {
            int row = point.get(0);
            int col = point.get(1);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][col] = 0;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
    }
}
