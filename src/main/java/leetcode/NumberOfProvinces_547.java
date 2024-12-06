package leetcode;

public class NumberOfProvinces_547 {
    public int findCircleNum(int[][] isConnected) {
        var visited = new boolean[isConnected.length];
        var answer = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int num) {
        visited[num] = true;

        for (int i=0; i<isConnected.length; i++) {
            if (isConnected[num][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
