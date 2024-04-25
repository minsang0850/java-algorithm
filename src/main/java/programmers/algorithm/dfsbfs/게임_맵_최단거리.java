package programmers.algorithm.dfsbfs;

import java.util.LinkedList;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        var p = new 게임_맵_최단거리();
        p.solution(new int[][]{new int[]{1, 0, 1, 1, 1},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 1, 1, 1},
                new int[]{1, 1, 1, 0, 1},
                new int[]{0, 0, 0, 0, 1}});
    }

    public int solution(int[][] maps) {
        var q = new LinkedList<Position>();
        var n = maps.length;
        var m = maps[0].length;
        q.add(new Position(0, 0, 1));
        while (!q.isEmpty()) {
            var popped = q.pop();
            if (popped.x == n - 1 && popped.y == m - 1) {
                return popped.distance;
            }
            if(!popped.isValid(n, m, maps)){
                continue;
            }
            maps[popped.x][popped.y] = 0;
            var left = new Position(popped.x - 1, popped.y, popped.distance + 1);
            var right = new Position(popped.x + 1, popped.y, popped.distance + 1);
            var down = new Position(popped.x, popped.y - 1, popped.distance + 1);
            var up = new Position(popped.x, popped.y + 1, popped.distance + 1);
            if (left.isValid(n, m, maps)) {
                q.add(left);
            }
            if (right.isValid(n, m, maps)) {
                q.add(right);
            }
            if (down.isValid(n, m, maps)) {
                q.add(down);
            }
            if (up.isValid(n, m, maps)) {
                q.add(up);
            }
        }
        return -1;
    }
}

class Position {
    int x;
    int y;
    int distance;

    Position(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public boolean isValid(int n, int m, int[][] maps) {
        if (x >= n || x < 0 || y >= m || y < 0) {
            return false;
        }
        return maps[x][y] == 1;
    }
}


