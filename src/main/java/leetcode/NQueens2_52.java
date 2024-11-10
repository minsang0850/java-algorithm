package leetcode;

public class NQueens2_52 {
    public int totalNQueens(int n) {
        var board = new boolean[n][n];
        return nQueen(board, 0);
    }

    private int nQueen(boolean[][] board, int row) {
        if(board.length==row) {
            return 1;
        }
        var answer = 0;
        for (int col = 0; col < board.length; col++) {
            if (check(board, row, col)) {
                board[row][col] = true;
                answer += nQueen(board, row + 1);
                board[row][col]=false;
            }
        }
        return answer;
    }

    private boolean check(boolean[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        var i = row;
        var j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < board.length) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
