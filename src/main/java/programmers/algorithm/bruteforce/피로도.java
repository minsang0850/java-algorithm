package programmers.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 피로도 {
    public static void main(String[] args) {
        var p = new 피로도();
        p.solution(5, new int[][]{new int[]{5, 3}, new int[]{5, 3}, new int[]{5, 3}, new int[]{5, 3}});
    }
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        var permuted = new ArrayList<Integer>();
        for (int i=0; i<dungeons.length; i++){
            permuted.add(i);
        }
        var set = new HashSet<List<Integer>>();
        permute(new ArrayList<>(), set, permuted);
        for (List<Integer> order : set) {
            var currentFatigue = k;
            var dungeonClearCount = 0;
            for(int i=0; i<order.size(); i++) {
                var currentChallengeIdx = order.get(i);
                if(currentFatigue>=dungeons[currentChallengeIdx][0]) {
                    currentFatigue-=dungeons[currentChallengeIdx][1];
                    dungeonClearCount++;
                }
                else {
                    break;
                }
            }
            if(dungeonClearCount>answer){
                answer=dungeonClearCount;
            }
        }
        return answer;
    }

    private void permute(ArrayList<Integer> integers, HashSet<List<Integer>> set, ArrayList<Integer> permuted) {
        if(permuted.size()==0){
            set.add(integers);
            return;
        }
        for (int i=0; i<permuted.size(); i++) {
            var newIntegers = new ArrayList<>(integers);
            var newPermuted = new ArrayList<>(permuted);
            newIntegers.add(permuted.get(i));
            newPermuted.remove(i);
            permute(newIntegers, set, newPermuted);
        }
    }


}
