package leetcode;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        var visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if(visit(board, word, visited, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean visit(char[][] board, String word, boolean[][] visited, int order, int row, int col) {
        if(order==word.length()) {
            return true;
        }
        if(row<0 || col<0 || row>=board.length || col>=board[0].length) {
            return false;
        }
        if(visited[row][col]) {
            return false;
        }
        var c = word.charAt(order);
        if(board[row][col]!=c) {
            return false;
        }
        visited[row][col]=true;
        if(visit(board,word,visited,order+1,row+1,col)) {
            return true;
        }
        if(visit(board,word,visited,order+1,row-1,col)){
            return true;
        }
        if(visit(board,word,visited,order+1,row,col+1)){
            return true;
        }
        if(visit(board,word,visited,order+1,row,col-1)){
            return true;
        }
        visited[row][col]=false;
        return false;
    }
}
