package programmers.algorithm.dfsbfs;

import java.util.LinkedList;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i=0; i<n; i++) {
            answer+=bfs(n, computers, i);
        }
        return answer;
    }

    private int bfs(int n, int[][] computers, int idx) {
        var q = new LinkedList<Integer>();
        q.add(idx);
        var answer  = 0;
        while (!q.isEmpty()) {
            var popped = q.pop();
            for (int i=0; i<n; i++) {
                var computer = computers[popped][i];
                if(computer==1){
                    computers[popped][i]=0;
                    computers[i][popped]=0;
                    q.add(i);
                    answer = 1;
                }
            }
        }
        return answer;
    }
}
