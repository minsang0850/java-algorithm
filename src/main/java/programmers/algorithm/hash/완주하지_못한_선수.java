package programmers.algorithm.hash;

import java.util.HashMap;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        var map = new HashMap<String, Integer>();
        for (String player: completion){
            if(!map.containsKey(player)){
                map.put(player, 1);
            } else {
                map.put(player, map.get(player)+1);
            }
        }
        for (String player: participant){
            if(!map.containsKey(player)){
                return player;
            }
            var score = map.get(player);
            score--;
            if(score==0){
                map.remove(player);
            }
            else {
                map.put(player, score);
            }

        }
        return "";
    }
}
