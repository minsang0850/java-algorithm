package programmers.kakao2024internship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 도넛과_막대_그래프 {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // 도넛: a -> b -> c -> a ...
        // 막대: a -> b -> c
        // 8자: a ->b, c -> a
        var numSet = new HashSet<Integer>();
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            numSet.add(edges[i][0]);
            numSet.add(edges[i][1]);
            push(map, edges[i]);
        }
        for (int i = 0; i < edges.length; i++) {
            numSet.remove(edges[i][1]);
        }
        var vertex = getVertex(numSet, map);
        answer[0] = vertex;
        var starts = map.get(vertex);
        for (int start : starts) {
            var type = dfs(map, start, start);
            if (type == 0) {
                answer[1]++;
            } else if (type == 1) {
                answer[2]++;
            } else {
                answer[3]++;
            }
        }

        return answer;
    }

    private int dfs(HashMap<Integer, List<Integer>> map, int start, int origin) {
        if (!map.containsKey(start)) { // 다음이 없다? -> 막.
            return 1;
        }
        var nextGraph = map.get(start);
        if (nextGraph.size() == 2) { // 화살표가 두개인 케이스 -> 8자
            return 2;
        }
        var next = nextGraph.get(0);
        if (next == origin) { // 같은걸로 돌아온다 -> 도넛
            return 0;
        }
        return dfs(map, next, origin);
    }


    private void push(HashMap<Integer, List<Integer>> map, int[] edge) {
        var from = edge[0];
        var to = edge[1];
        if (map.containsKey(from)) {
            map.get(from).add(to);
        } else {
            var list = new ArrayList<Integer>();
            list.add(to);
            map.put(from, list);
        }
    }

    private int getVertex(HashSet<Integer> numSet, HashMap<Integer, List<Integer>> map) {
        return numSet.stream().filter(num->map.get(num).size()!=1).findAny().get();
    }
}
