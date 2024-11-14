package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EqualRowAndColumnPairs_2352 {
    public int equalPairs(int[][] grid) {
        var map = new HashMap<List<Integer>, Integer>();
        for (int i = 0; i < grid.length; i++) {
            var list = new ArrayList<Integer>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[i][j]);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        var res = 0;

        for (int i = 0; i < grid.length; i++) {
            var list = new ArrayList<Integer>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[j][i]);
            }
            if(map.containsKey(list)){
                res += map.get(list);
            }
        }
        return res;
    }
}
