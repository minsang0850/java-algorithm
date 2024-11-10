package leetcode;

import java.util.HashMap;

public class RankTeamsByVotes_1366 {
    public String rankTeams(String[] votes) {
        var len = votes[0].length();
        var map = new HashMap<Character, TeamRank>();
        for (int i = 0; i < votes[0].length(); i++) {
            var c = votes[0].charAt(i);
            map.put(c, new TeamRank(c, votes[0].length()));
        }
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length(); j++) {
                var c = votes[i].charAt(j);
                map.get(c).rank[j]++;
            }
        }
        var list = map.values()
                .stream()
                .sorted((a, b) -> {
                    for (int i = 0; i < len; i++) {
                        if (a.rank[i] > b.rank[i]) {
                            return -1;
                        }
                        if (a.rank[i] < b.rank[i]) {
                            return 1;
                        }
                    }
                    if (a.c <= b.c) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .toList();
        var answer = "";
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i).c;
        }
        return answer;
    }

    class TeamRank {
        char c;
        int[] rank;

        TeamRank(char c, int len) {
            this.c = c;
            this.rank = new int[len];
        }
    }
}
