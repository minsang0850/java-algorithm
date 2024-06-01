package programmers.summercoding2018;

import java.util.HashSet;
import java.util.Objects;

public class 방문_길이 {
    public int solution(String dirs) {
        int answer = 0;
        var current = new int[]{0, 0};
        var set = new HashSet<Point>();
        for (int i = 0; i < dirs.length(); i++) {
            var dir = dirs.charAt(i);
            var currentX = current[0];
            var currentY = current[1];
            if (dir == 'U') {
                if (validate(currentX, currentY + 1)) {
                    if(!set.contains(new Point(currentX, currentY, 'U'))){
                        answer++;
                    }
                    set.add(new Point(currentX, currentY, 'U'));
                    currentY++;
                    set.add(new Point(currentX, currentY, 'D'));
                }
            }
            if (dir == 'D') {
                if (validate(currentX, currentY - 1)) {
                    if(!set.contains(new Point(currentX, currentY, 'D'))){
                        answer++;
                    }
                    set.add(new Point(currentX, currentY, 'D'));
                    currentY--;
                    set.add(new Point(currentX, currentY, 'U'));
                }
            }
            if (dir == 'R') {
                if (validate(currentX+1, currentY)) {
                    if(!set.contains(new Point(currentX, currentY, 'R'))){
                        answer++;
                    }
                    set.add(new Point(currentX, currentY, 'R'));
                    currentX++;
                    set.add(new Point(currentX, currentY, 'L'));
                }
            }
            if (dir == 'L') {
                if (validate(currentX-1, currentY)) {
                    if(!set.contains(new Point(currentX, currentY, 'L'))){
                        answer++;
                    }
                    set.add(new Point(currentX, currentY, 'L'));
                    currentX--;
                    set.add(new Point(currentX, currentY, 'R'));
                }
            }
            current[0]=currentX;
            current[1]=currentY;
        }
        return answer;
    }

    private boolean validate(int currentX, int currentY) {
        if (currentX < -5 || currentX > 5) {

            return false;
        }
        if (currentY < -5 || currentY > 5) {
            return false;
        }
        return true;
    }

    class Point{
        int x;
        int y;
        char dir;

        public Point(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && dir == point.dir;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, dir);
        }
    }
}
