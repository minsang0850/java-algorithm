package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {
    public static void main(String[] args) {
        var p = new CombinationSum3_216();
        System.out.println(p.combinationSum3(3, 7));
    }
    List<List<Integer>> answer = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i=1; i<=9; i++) {
            combinationSum3(k, n, i, new int[k], 0, 0);
        }
        return answer;
    }

    private void combinationSum3(int k, int n, int number, int[] numbers, int idx, int currentSum) {
        if(idx==k || currentSum>=n) {
            return;
        }
        currentSum+= number;
        numbers[idx] = number;
        if(currentSum==n && idx+1==k) {
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<k; i++) {
                list.add(numbers[i]);
            }
            answer.add(list);
            return;
        }
        for (int newNumber=number+1; newNumber<=9; newNumber++) {
            combinationSum3(k, n, newNumber, numbers, idx+1, currentSum);
        }
    }
}
