package programmers.algorithm.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        var p = new 징검다리();
        p.solution(25, new int[]{2,14,11,21,17}, 2);
    }
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        var newRocks = new int[rocks.length+1];
        for (int i=0; i<rocks.length; i++){
            newRocks[i+1]=rocks[i];
        }
        return binarySearch(0, distance, newRocks, n, distance,99999);
    }

    private int binarySearch(int min, int max, int[] rocks, int n, int distance, int answer) {
        var predicate = (min + max) / 2;
        if(min>max) {
            return answer;
        }
        var removedCount = getRemovedCount(rocks, distance, predicate);
        if(removedCount>n) { //더 많이 부셨네? predicate는 안되나보다!
            return binarySearch(min, predicate-1, rocks, n, distance, answer);
        }
        answer=predicate;
        return binarySearch(predicate+1, max, rocks, n, distance, answer);
    }

    private static int getRemovedCount(int[] rocks, int distance, int predicate) {
        //제거되지 않는 돌 저장
        var newRocks = new ArrayList<Integer>();
        var removedCount = 0;
        for (int current = 0; current< rocks.length; current++){
            newRocks.add(rocks[current]);
            var next = current + 1;
            while (next< rocks.length && rocks[next]- rocks[current]< predicate){
                next++;
                removedCount++;
            }
            current=next-1;
        }
        //도착지점까지의 거리 확인 후 추가 제거
        for (int i = newRocks.size()-1; i>=0; i--){
            if(distance - newRocks.get(i)< predicate){
                removedCount++;
            }
        }
        return removedCount;
    }
}
