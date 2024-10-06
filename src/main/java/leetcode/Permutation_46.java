package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation_46 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        var result = new ArrayList<List<Integer>>();
        permute(nums, 0, visited, result, new ArrayList<>());
        return result;
    }

    private void permute(int[] nums, int order, boolean[] visited, ArrayList<List<Integer>> result, List<Integer> list) {
        if(order == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            var newList = new ArrayList<>(list);
            newList.add(nums[i]);
            visited[i] = true;
            permute(nums,order+1,visited,result,newList);
            visited[i] = false;
        }
    }
}
