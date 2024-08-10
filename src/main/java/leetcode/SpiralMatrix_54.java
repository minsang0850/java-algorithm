package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        var p = new SpiralMatrix_54();
//        p.spiralOrder(new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}});
        p.spiralOrder(new int[][]{new int[]{1,2,3,4}, new int[]{5,6,7,8}, new int[]{9,10,11,12}});
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrder(matrix,0,0,matrix.length-1, matrix[0].length-1);
    }

    private List<Integer> spiralOrder(int[][] matrix, int x, int y, int xx, int yy) {
        if(x>xx || y>yy) {
            return Collections.emptyList();
        }
        if(x==xx && y==yy) {
            return List.of(matrix[x][y]);
        }
        if(x==xx) {
            var list = new ArrayList<Integer>();
            for (int i=y; i<=yy; i++) {
                list.add(matrix[x][i]);
            }
            return list;
        }
        if(y==yy) {
            var list = new ArrayList<Integer>();
            for (int i=x; i<=xx; i++) {
                list.add(matrix[i][y]);
            }
            return list;
        }
        var list = new ArrayList<Integer>();
        for (int i=y; i<=yy; i++) {
            list.add(matrix[x][i]);
        }
        for (int i=x+1; i<=xx; i++) {
            list.add(matrix[i][yy]);
        }
        for (int i=yy-1; i>=y; i--) {
            list.add(matrix[xx][i]);
        }
        for (int i=xx-1; i>x; i--) {
            list.add(matrix[i][y]);
        }
        list.addAll(spiralOrder(matrix, x+1, y+1, xx-1, yy-1));
        return list;
    }
}
