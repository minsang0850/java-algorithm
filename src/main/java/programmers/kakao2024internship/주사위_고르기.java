package programmers.kakao2024internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 주사위_고르기 {
    public int[] solution(int[][] dice) {
        //6^10 = 60,466,176
        var n = dice.length / 2;
        var answer = new int[n];
        var list = new ArrayList<Dice>();
        for (int i = 0; i < dice.length; i++) {
            list.add(new Dice(i + 1, dice[i]));
        }
        Collections.sort(list, (a, b) -> {
            var suma = 0;
            var sumb = 0;
            var diceA = a.dice;
            var diceB = b.dice;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (diceA[i] > diceB[i]) {
                        suma++;
                    } else if (diceA[i] < diceB[i]) {
                        sumb++;
                    }
                }
            }
            return sumb - suma;
        });
        for (int i = 0; i < n; i++) {
            answer[i] = list.get(i).order;
        }

        return answer;
    }

    class Dice {
        int order;
        int[] dice;

        public Dice(int order, int[] dice) {
            this.order = order;
            this.dice = dice;
        }
    }
}
