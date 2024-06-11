package programmers.kakao2024internship;

import java.util.*;

public class 주사위_고르기 {
    public static void main(String[] args) {
        var p = new 주사위_고르기();
        p.solution(new int[][]{new int[]{40, 41, 42, 43, 44, 45}, new int[]{40, 41, 42, 43, 44, 45},
                new int[]{40, 41, 42, 43, 44, 45},
                new int[]{40, 41, 42, 43, 44, 45}});
    }

    ArrayList<List<Integer>> combinationsA = new ArrayList<>();
    ArrayList<List<Integer>> combinationsB = new ArrayList<>();

    public int[] solution(int[][] dice) {
        //6^10 = 60,466,176
        // 6^5 * 2 * 조합(252)
        var n = dice.length / 2;
        var answer = new int[n];
        var max = 0;
        //조합 생성
        getCombinations(new ArrayList<>(), new ArrayList<>(), 0, n, 0, 0);
        for (int i=0; i<combinationsA.size(); i++){
            //합 구하기
            var aResults = getResult(dice, combinationsA.get(i), n);
            var bResults = getResult(dice, combinationsB.get(i), n);
            Collections.sort(aResults);
            Collections.sort(bResults);
            // 승률 구하기
            var winRate = getWinRate(aResults, bResults);
            // 승률이 현재까지 최고보다 높으면 answer 갱신
            if(winRate>max){
                max=winRate;
                for (int j=0; j<n; j++) {
                    answer[j]=combinationsA.get(i).get(j)+1;
                }
            }
        }
        return answer;
    }

    private int getWinRate(List<Integer> aResults, List<Integer> bResults) {
        int current = 0;
        int result = 0;
        for (int i=0; i<aResults.size(); i++) {
            var a = aResults.get(i);
            while (current<bResults.size() && a>bResults.get(current)){
                current++;
            }
            result+=current;
        }
        return result;
    }

    private List<Integer> getResult(int[][] dices, List<Integer> integers, int n) {
        var list = new ArrayList<Integer>();
        getDiceSum(list, dices, integers, 0, 0, n);
        return list;
    }

    private void getDiceSum(List<Integer> list, int[][] dices, List<Integer> integers, int currentIdx, int sum, int n) {
        if(currentIdx==n){
            list.add(sum);
            return;
        }
        int current = integers.get(currentIdx);
        var dice = dices[current];
        for (int i=0; i<6; i++) {
            getDiceSum(list, dices, integers, currentIdx+1, sum+dice[i], n);
        }
    }

    private void getCombinations(List<Integer> combinationA, List<Integer> combinationB, int current, int n, int aSize, int bSize) {
        if (aSize == n && bSize == n) {
            combinationsA.add(combinationA);
            combinationsB.add(combinationB);
            return;
        }
        var newCombinationA = new ArrayList<Integer>(combinationA);
        var newCombinationB = new ArrayList<Integer>(combinationB);

        if(aSize<n){
            newCombinationA.add(current);
            getCombinations(newCombinationA, combinationB, current + 1, n, aSize + 1, bSize);
        }
        if(bSize<n){
            newCombinationB.add(current);
            getCombinations(combinationA, newCombinationB, current + 1, n, aSize, bSize + 1);
        }
    }
}
