package programmers.algorithm.hash;

import java.util.HashMap;

public class 의상 {

    public static void main(String[] args) {
        var problem = new 의상();
        problem.solution(new String[][]{new String[]{"yellow_hat", "headgear"}, new String[]{"blue_sunglasses", "eyewear"}, new String[]{"green_turban", "headgear"}});

    }
    public int solution(String[][] clothes) {
        int answer = 1;
        var map = new HashMap<String, Integer>();
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            } else {
                map.put(cloth[1], 1);
            }
        }

        for (String key : map.keySet()) {
            var kinds = map.get(key);
            answer *= kinds+1;
        }
        return answer-1;
    }
}
