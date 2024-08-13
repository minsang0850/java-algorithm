package leetcode;

public class GameOfLife_289 {
    public static void main(String[] args) {
        var p = new GameOfLife_289();
        p.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
    int[] directionx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] directiony = new int[]{1, 0, -1, 1, -1, 1, 0, -1};

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                var neighbor = getNeighbor(board, i, j);
                if (board[i][j] == 1) {
                    if(neighbor ==2 || neighbor == 3) {
                        board[i][j] +=2;
                    }
                } else {
                    if (neighbor == 3) {
                        board[i][j] +=2;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]/=2;
            }
        }
    }

    private int getNeighbor(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return 0;
        }
        var answer = 0;
        for (int k = 0; k < 8; k++) {
            var x = i + directionx[k];
            var y = j + directiony[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                answer += board[x][y]%2;
            }
        }
        return answer;
    }
}
