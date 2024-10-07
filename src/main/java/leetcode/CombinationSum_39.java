package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        dfs(candidates, target, 0, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void dfs(int[] candidates, int target, int order, ArrayList<Integer> current, int currentSum, ArrayList<List<Integer>> result) {
        if(currentSum== target) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(currentSum > target) {
            return;
        }
        for (int i = order; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(candidates, target, i, current, currentSum + candidates[i], result);
            current.remove(current.size() - 1);
        }
    }
}
