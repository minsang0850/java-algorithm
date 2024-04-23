package programmers.algorithm.bruteforce;

import java.util.ArrayList;

public class 전력망을_둘로_나누기 {
    public static void main(String[] args) {
        var p = new 전력망을_둘로_나누기();
        p.solution(7, new int[][]{new int[]{1, 2}, new int[]{2, 7}, new int[]{3, 7}, new int[]{3, 4}, new int[]{4, 5}, new int[]{6, 7}});
    }
    public int solution(int n, int[][] wires) {
        int answer = 100;
        var connected = new int[n + 1][n + 1]; //1부터 n까지라서
        for (int[] wire : wires) {
            connected[wire[0]][wire[1]] = 1;
            connected[wire[1]][wire[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if(connected[i][j]==0){
                    continue;
                }
                connected[i][j] = 0;
                connected[j][i] = 0;
                var iCount = count(i, connected);
                var jCount = n-iCount;
                var diff = iCount >= jCount ? iCount - jCount : jCount - iCount;
                if(answer>diff){
                    answer=diff;
                }
                connected[i][j] = 1;
                connected[j][i] = 1;
            }
        }
        return answer;
    }

    private int count(int num, int[][] connected) {
        var answer = 1;
        var temp = new ArrayList<Integer>();
        // 연결 끊기
        for (int i=0; i<connected.length; i++){
            if(connected[num][i]==1){
                connected[num][i]=0;
                connected[i][num]=0;
                temp.add(i);
            }
        }
        // 카운트 구하기
        for (int i=0; i<temp.size(); i++) {
            answer+= count(temp.get(i), connected);
        }
        // 연결 다시 잇기
        for (int i=0; i<temp.size(); i++){
            connected[num][temp.get(i)]=1;
            connected[temp.get(i)][num]=1;
        }
        return answer;
    }
}
