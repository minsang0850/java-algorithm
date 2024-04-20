package programmers.introduction;

public class 안전지대 {
    public int solution(int[][] board) {
        int answer = 0;
        spread(board);
        var n = board.length;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if(board[i][j]==0){
                    answer++;
                }
            }
        }
        return answer;
    }

    private void spread(int[][] board) {
        var n = board.length;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if(board[i][j]==1){
                    for (int x=-1; x<=1; x++){
                        for (int y=-1; y<=1; y++) {
                            if(0<=i+x && n>i+x && 0<=j+y && n>j+y){
                                if(board[i+x][j+y]==0){
                                    board[i+x][j+y]=2;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
