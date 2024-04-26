package programmers.skillchecktest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 문제2 {
    public static void main(String[] args) {
        var p = new 문제2();
        p.solution(new int[]{100, 180, 360, 100, 270});
        p.solution(new int[]{100, 100, 200, 200, 180, 360, 270});
        p.solution(new int[]{100, 100, 200, 200, 200, 180, 360, 270});
    }

    public long solution(int[] weights) {
        long answer = 0;
        //시소 2,3,4
        Arrays.sort(weights);
        var map = getMap(weights);
        for (int weight : weights) {
            // 내가 4 상대가 2
            var findWeight = weight * 2;
            answer += getCoupleCount(map, findWeight);
            // 내가 4 상대가 3
            if (weight % 3 == 0) {
                findWeight = weight * 4 / 3;
                answer += getCoupleCount(map, findWeight);
            }
            // 내가 3 상대가 2
            if (weight % 2 == 0) {
                findWeight = weight * 3 / 2;
                answer += getCoupleCount(map, findWeight);
            }
        }

        //같은 무게 쌍
        for (int key : map.keySet()) {
            var checkWeights = map.get(key);
            answer += ((long)checkWeights.size()) * (long)(checkWeights.size() - 1) / 2;
        }
        return answer;
    }

    private static HashMap<Integer, List<Integer>> getMap(int[] weights) {
        var map = new HashMap<Integer, List<Integer>>();
        for (int weight : weights) {
            if (map.containsKey(weight)) {
                map.get(weight).add(weight);
            } else {
                var list = new ArrayList<Integer>();
                list.add(weight);
                map.put(weight, list);
            }
        }
        return map;
    }

    private static long getCoupleCount(HashMap<Integer, List<Integer>> map, int findWeight) {
        if (map.containsKey(findWeight)) {
            return (long)map.get(findWeight).size();
        }
        return 0;
    }
}
