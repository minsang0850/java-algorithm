package programmers.kakao2024internship;

import java.util.HashMap;

public class 가장_많이_받은_선물 {
    public static void main(String[] args) {
        var p = new 가장_많이_받은_선물();
        p.solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
    }
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        var map = new HashMap<String, Integer>();
        var history = new int[friends.length][friends.length];
        var giftValue = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        for (String gift: gifts) {
            var splited = gift.split(" ");
            var from = splited[0];
            var to = splited[1];
            history[map.get(from)][map.get(to)]++;
            giftValue[map.get(from)]++;
            giftValue[map.get(to)]--;
        }
        for (int i=0; i<friends.length; i++) {
            var result = 0;
            for (int j=0;j<friends.length; j++) {
                // 선물을 더 많이 줬다면
                if(history[i][j]>history[j][i]){
                    result++;
                } else if(history[i][j]==history[j][i]) {
                    if(giftValue[i]>giftValue[j]){
                        result++;
                    }
                }
            }
            answer = Math.max(answer, result);
        }

        return answer;
    }
}
