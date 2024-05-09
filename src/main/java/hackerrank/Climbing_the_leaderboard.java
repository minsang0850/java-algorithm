package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Climbing_the_leaderboard {
    public static void main(String[] args) {
        Climbing_the_leaderboard.climbingLeaderboard(new ArrayList<>(List.of(100, 100, 50, 40, 40, 20, 10))
                , new ArrayList<>(List.of(5, 25, 50, 120)));

        var answer = search(new ArrayList<>(List.of(95, 90, 70, 50, 30, 10)), 5, 0, 5);
        return;
    }
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        removeDuplicate(ranked);
        var answer = new ArrayList<Integer>();
        for (int i = 0; i < player.size(); i++) {
            answer.add(search(ranked, player.get(i), 0, ranked.size() - 1));
        }
        return answer;
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

    private static int search(List<Integer> ranked, int score, int start, int end) {
        var mid = (start + end) / 2;
        if(0<=mid && mid<ranked.size()-1){
            if(ranked.get(mid)>score && ranked.get(mid+1)<score){
                return mid+2;
            }
        }
        if (ranked.get(mid) == score) {
            return mid + 1;
        } else if (ranked.get(mid) < score) {
            if (mid == 0) {
                return 1;
            }
            return search(ranked, score, start, mid - 1);
        } else {
            if (mid == ranked.size() - 1) {
                return mid + 2;
            }
            return search(ranked, score, mid + 1, end);
        }
    }
}
