package programmers.algorithm.dp;

public class 등굣길 {
    public static void main(String[] args) {
        var p = new 등굣길();
        var answer = p.solution(2, 2, new int[][]{new int[]{}});
        System.out.println(answer);
    }

    int[][] answers;

    public int solution(int m, int n, int[][] puddles) {
        answers = new int[m+1][n+1];
        return solution(1,1, m, n, puddles);
    }

    private int solution(int currentX, int currentY, int m, int n, int[][] puddles) {
        if(currentX==m && currentY==n){
            return 1;
        }
        if(currentX>m || currentY>n){
            return 0;
        }
        if(answers[currentX][currentY]!=0){
            return answers[currentX][currentY];
        }
        for (int[] puddle : puddles){
            if(puddle[0]==currentX && puddle[1]==currentY) {
                return 0;
            }
        }
        var x = solution(currentX+1, currentY, m, n, puddles);
        var y = solution(currentX, currentY+1, m, n, puddles);
        var answer = (x + y) % 1000000007;
        answers[currentX][currentY]= answer;
        return answer;
    }
}
