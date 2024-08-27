package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        var answer = new ArrayList<int[]>();
        var start = intervals[0][0];
        var end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                answer.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        answer.add(new int[]{start, end});
        return answer.toArray(new int[0][]);
    }
}
