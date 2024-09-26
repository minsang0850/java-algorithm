package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        var result = new java.util.ArrayList<List<Integer>>();
        dfs(n, k, 1, new java.util.ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int n, int k, int i, ArrayList<Integer> integers, ArrayList<List<Integer>> result) {
        if (integers.size() == k) {
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int j = i; j <= n; j++) {
            integers.add(j);
            dfs(n, k, j + 1, integers, result);
            integers.remove(integers.size() - 1);
        }
    }
}
