package leetcode;

import java.util.List;

public class KeyAndRooms_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int currentVisit, boolean[] visited) {
        visited[currentVisit] = true;

        for (int nextVisit : rooms.get(currentVisit)) {
            if (!visited[nextVisit]) {
                dfs(rooms, nextVisit, visited);
            }
        }
    }
}
