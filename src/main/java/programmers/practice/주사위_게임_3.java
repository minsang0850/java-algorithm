package programmers.practice;

import java.util.HashMap;
import java.util.stream.Collectors;

public class 주사위_게임_3 {
    public int solution(int a, int b, int c, int d) {
        if (a == b && b == c && c == d) {
            return 1111 * a;
        }
        var map = new HashMap<Integer, Integer>();
        pushHashMap(a, map);
        pushHashMap(b, map);
        pushHashMap(c, map);
        pushHashMap(d, map);
        var keyList = map.keySet().stream().sorted().collect(Collectors.toList());
        if (keyList.size() == 2) {
            if (map.get(keyList.get(0)) == 2) {
                var p = keyList.get(0);
                var q = keyList.get(1);
                return (p + q) * Math.abs(p - q);
            } else {
                var p = 0;
                var q = 0;
                if (map.get(keyList.get(0)) == 3) {
                    p = keyList.get(0);
                    q = keyList.get(1);
                } else {
                    p = keyList.get(1);
                    q = keyList.get(0);
                }
                return (10 * p + q) * (10 * p + q);
            }
        }
        if(keyList.size()==3){
            if(map.get(keyList.get(0))==2){
                return keyList.get(1) * keyList.get(2);
            }
            if(map.get(keyList.get(1))==2){
                return keyList.get(0) * keyList.get(2);
            }
            if(map.get(keyList.get(2))==2){
                return keyList.get(1) * keyList.get(0);
            }
        }
        return keyList.get(0);
    }

    private static void pushHashMap(int a, HashMap<Integer, Integer> hm) {
        if (hm.containsKey(a)) {
            hm.put(a, hm.get(a) + 1);
        } else {
            hm.put(a, 1);
        }
    }
}
