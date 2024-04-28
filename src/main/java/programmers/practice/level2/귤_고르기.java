package programmers.practice.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 귤_고르기 {
    public static void main(String[] args) {
        var p = new 귤_고르기();
        p.solution(6, new int[]{1,3,2,5,4,5,2,3});
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        var map = new HashMap<Integer, Integer>();
        for (int i=0; i<tangerine.length; i++){
            if(map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i])+1);
            }
            else{
                map.put(tangerine[i], 1);
            }
        }
        var keySet = map.keySet();
        var keyArr = new Integer[keySet.size()];
        int idx=0;
        for (int key : keySet) {
            keyArr[idx++]=map.get(key);
        }
        Arrays.sort(keyArr, Collections.reverseOrder());
        for (int i=0; i<keyArr.length; i++){
            k-=keyArr[i];
            answer++;
            if(k<=0){
                break;
            }
        }
        return answer;
    }
}
