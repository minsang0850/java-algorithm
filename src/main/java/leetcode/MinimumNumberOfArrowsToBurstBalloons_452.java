package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        for (int i=0; i<points.length; i++) {
            count++;
            int end = points[i][1];
            while (i+1 < points.length && points[i+1][0] <= end) {
                i++;
            }
        }
        return count;
    }
}
