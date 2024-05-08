package leetcode;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        var flags = new boolean[10];
        var answer=true;
        for (int i=0; i<9; i++) {
            reset(flags);
            for (int j=0; j<9; j++) {
                var num = board[i][j]-'0';
                if(num<=0 || num>9){
                    continue;
                }
                if(flags[num]){
                    answer=false;
                    break;
                }
                flags[num]=true;
            }
        }
        for (int i=0; i<9; i++) {
            reset(flags);
            for (int j=0; j<9; j++) {
                var num = board[j][i]-'0';
                if(num<=0 || num>9){
                    continue;
                }
                if(flags[num]){
                    answer=false;
                    break;
                }
                flags[num]=true;
            }
        }
        for (int i=0; i<9; i=i+3) {
            for (int j=0; j<9; j=j+3) {
                reset(flags);
                for (int x=0; x<3; x++){
                    for (int y=0; y<3; y++){
                        var num = board[i+x][j+y]-'0';
                        if(num<=0 || num>9){
                            continue;
                        }
                        if(flags[num]){
                            answer=false;
                            break;
                        }
                        flags[num]=true;
                    }
                }
            }
        }
        return answer;
    }

    private void reset(boolean[] flags) {
        for (int i=0; i< flags.length; i++){
            flags[i]=false;
        }
    }
}
