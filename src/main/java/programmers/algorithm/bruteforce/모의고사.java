package programmers.algorithm.bruteforce;

import java.util.ArrayList;

public class 모의고사 {
    public static void main(String[] args) {
        var p = new 모의고사();
        p.solution(new int[]{1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2});
    }

    public int[] solution(int[] answers) {
        var list = new ArrayList<Integer>();
        var firstScore = 0;
        var secondScore = 0;
        var thirdScore = 0;
        for (int i = 0; i < answers.length; i++) {
            System.out.println(getFirstManAnswer(i) + " ");
//            System.out.println(getSecondManAnswer(i) + " ");
//            System.out.println(getThirdManAnswer(i) + " ");
            if (answers[i] == getFirstManAnswer(i)) {
                firstScore++;
            }
            if (answers[i] == getSecondManAnswer(i)) {
                secondScore++;
            }
            if (answers[i] == getThirdManAnswer(i)) {
                thirdScore++;
            }
        }
        int max = 0;
        if (max < firstScore) {
            max = firstScore;
        }
        if (max < secondScore) {
            max = secondScore;
        }
        if (max < thirdScore) {
            max = thirdScore;
        }
        if (max == firstScore) {
            list.add(1);
        }
        if (max == secondScore) {
            list.add(2);
        }
        if (max == thirdScore) {
            list.add(3);
        }
        var answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    int getFirstManAnswer(int i) {
        var n = (i + 1) % 5;
        return n == 0 ? 5 : n;
    }

    int getSecondManAnswer(int i) {
        if (i % 2 == 0) {
            return 2;
        }
        var n = (i / 2) % 4;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 3;
        }
        if (n == 2) {
            return 4;
        }
        return 5;
    }

    int getThirdManAnswer(int i) {
        var n = i % 10;
        switch (n) {
            case 0:
            case 1:
                return 3;
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            case 6:
            case 7:
                return 4;
            default:
                return 5;
        }
    }
}
