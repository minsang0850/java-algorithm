package programmers.kakao2023blind;

import java.util.ArrayList;
import java.util.List;

public class 이모티콘_할인행사 {
    public int[] solution(int[][] users, int[] emoticons) {
        // 가입자 늘리기
        // 판매액 늘리기
        // n명에게 이모티콘 m개
        // 할인율은 10, 20, 30, 40

        // 일정 비율 할인 이모티콘 모두 구매
        // 이모티콘 구매 비용 합이 일정 가격 이상이면 구매를 취소하고 이모티콘 플러스
        int[] answer = new int[]{0,0};
        var discountsList = new ArrayList<List<Integer>>();
        combination(discountsList, new ArrayList<Integer>(), 0, emoticons.length);
        for (List<Integer> discounts: discountsList) {
            var joinCount = 0;
            var cost = 0;
            for (int i=0; i<users.length; i++) {
                var abc = getCost(discounts, users[i], emoticons);
                if(abc==-1) {
                    joinCount++;
                } else {
                    cost+=abc;
                }
            }
            if(answer[0]<joinCount){
                answer= new int[]{joinCount, cost};
            } else if(answer[0]==joinCount) {
                if(answer[1]<cost){
                    answer= new int[]{joinCount, cost};
                }
            }
        }
        return answer;
    }

    private int getCost(List<Integer> discounts, int[] user, int[] emoticons) {
        var sum = 0;
        for (int i=0; i<emoticons.length; i++) {
            if(user[0]<=discounts.get(i)){ //할인율 충족
                sum+=emoticons[i]*(100-discounts.get(i))/100;
            }
        }
        if(sum>=user[1]){ //플러스
            return -1;
        }
        return sum;
    }


    private void combination(List<List<Integer>> discounts, List<Integer> list, int current, int length) {
        if (current==length) {
            discounts.add(list);
            return;
        }
        var list1 = new ArrayList<Integer>(list);
        var list2 = new ArrayList<Integer>(list);
        var list3 = new ArrayList<Integer>(list);
        var list4 = new ArrayList<Integer>(list);
        list1.add(10);
        list2.add(20);
        list3.add(30);
        list4.add(40);
        combination(discounts, list1, current+1, length);
        combination(discounts, list2, current+1, length);
        combination(discounts, list3, current+1, length);
        combination(discounts, list4, current+1, length);
    }
}
