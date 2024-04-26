package programmers.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;

public class 가장_먼_노드 {
    public static void main(String[] args) {
        var p = new 가장_먼_노드();
        p.solution(6, new int[][]{new int[]{3, 6},
                new int[]{4, 3},
                new int[]{3, 2},
                new int[]{1, 3},
                new int[]{1, 2},
                new int[]{2, 4},
                new int[]{5, 2}});
    }
    public int solution(int n, int[][] edge) {
        var graph = new boolean[n+1][n+1];
        for (int[] connect: edge){
            graph[connect[0]][connect[1]]=true;
            graph[connect[1]][connect[0]]=true;
        }
        return bfs(graph, n);
    }

    private int bfs(boolean[][] graph, int n) {
        var answer = 0;
        var done = new boolean[n+1];
        var q = new LinkedList<int[]>();
        q.add(new int[]{1, 0});
        var maxDistance = 0;
        done[1] = true;
        while (!q.isEmpty()) {
            var popped = q.poll();
            var currentVertex = popped[0];
            var currentDistance = popped[1];
            for (int i=1; i<=n; i++){
                if(done[i]){
                    continue;
                }
                if (graph[currentVertex][i]) {
                    graph[currentVertex][i]=false;
                    graph[i][currentVertex]=false;
                    q.add(new int[]{i, currentDistance+1});
                    done[i]=true;
                    if(currentDistance+1>maxDistance){
                        maxDistance = currentDistance+1;
                        answer = 1;
                    } else if(currentDistance+1==maxDistance){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
