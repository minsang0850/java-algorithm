package programmers.algorithm.greedy;

import java.util.*;

public class 섬_연결하기 {
    public static void main(String[] args) {
        var p = new 섬_연결하기();
        p.solution(6, new int[][]{new int[]{0, 1, 5}, new int[]{0, 3, 2}, new int[]{0, 4, 3},
                new int[]{1, 4, 1}, new int[]{3, 4, 10}, new int[]{1, 2, 2},
                new int[]{2, 5, 3}, new int[]{4, 5, 4}});
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        //비용순 정렬
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        var setList = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < costs.length; i++) {
            var aPos = -1;
            var bPos = -1;
            for (int j=0; j<setList.size(); j++){
                if(setList.get(j).contains(costs[i][0])){
                    aPos=j;
                }
                if(setList.get(j).contains(costs[i][1])){
                    bPos=j;
                }
            }
            if(aPos!=-1 && aPos == bPos){ //같은 곳에 연결
                continue;
            }
            if (aPos==-1 && aPos==bPos){ //둘 다 없음
                var set = new HashSet<Integer>();
                set.add(costs[i][0]);
                set.add(costs[i][1]);
                setList.add(set);
            }
            else if (aPos==-1 && bPos!=-1){ //b만 있음
                setList.get(bPos).add(costs[i][0]);
            }
            else if (aPos!=-1 && bPos==-1){ //a만 있음
                setList.get(aPos).add(costs[i][1]);
            }
            else { //둘이 같은 곳에 연결
                setList.get(aPos).addAll(setList.get(bPos));
                setList.remove(bPos);
            }
            answer += costs[i][2];
        }
        return answer;
    }
}
