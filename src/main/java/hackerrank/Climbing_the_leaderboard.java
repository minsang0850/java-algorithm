package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Climbing_the_leaderboard {
    public static void main(String[] args) {
        var list = new ArrayList<>(List.of(100,100, 100, 50, 40, 40, 20, 10));
        removeDuplicate(list);
        Climbing_the_leaderboard.climbingLeaderboard(new ArrayList<>(List.of(100, 100, 50, 40, 40, 20, 10))
                , new ArrayList<>(List.of(5, 25, 50, 120)));

        return;
    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        ranked = ranked.stream().distinct().collect(Collectors.toList());
        var answers = new ArrayList<Integer>();
        int n = ranked.size();
        int m = player.size();
        var idx = n-1;
        for (int i=0; i<m; i++) {
            var score = player.get(i);
            while (idx>=0 && score>=ranked.get(idx)) {
                idx--;
            }
            if(idx<0){
                answers.add(1);
            } else {
                answers.add(idx+2);
            }
        }
        return answers;
    }

    private static void removeDuplicate(List<Integer> ranked) {
        var prev = ranked.get(0);
        for (int i = 1; i < ranked.size(); i++) {
            if (prev == ranked.get(i)) {
                ranked.remove(i);
                i--;
            } else {
                prev = ranked.get(i);
            }
        }
    }

}
