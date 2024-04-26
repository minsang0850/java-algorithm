package programmers.skillchecktest.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문제1 {
    public static void main(String[] args) {
        var p = new 문제1();
        p.solution(new int[]{14, 35, 119}, new int[]{18, 30, 102});
    }
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        var commonDivsA = commonDiv(arrayA);
        var filteredA = filter(commonDivsA, arrayB);

        var commonDivsB = commonDiv(arrayB);
        var filteredB = filter(commonDivsB, arrayA);
        return Math.max(filteredA, filteredB);
    }

    private List<Integer> commonDiv(int[] array) {
        var list = new ArrayList<Integer>();
        for (int j = 2; j <= array[0]; j++) {
            boolean flag = true;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % j != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(j);
            }
        }
        return list;
    }

    private int filter(List<Integer> commonDivs, int[] array) {
        for (int j = commonDivs.size() - 1; j >= 0; j--) {
            boolean flag = true;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % commonDivs.get(j) == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return commonDivs.get(j);
            }
        }
        return 0;
    }
}
