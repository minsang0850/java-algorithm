package programmers.kakao2024internship;

import java.util.HashSet;

public class n_더하기_1_카드게임 {
    public static void main(String[] args) {
        var p = new n_더하기_1_카드게임();
//        p.solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}); //일반케이스
//        p.solution(3, new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12}); //처음에 x , 1라운드에서 2개
        p.solution(2, new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7}); // 처음에 1, 1라운드에서 2개
        p.solution(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18});
    }
    int count = 1;
    int round = 1;
    int current;
    int coin;

    public int solution(int coins, int[] cards) {
        int n = cards.length;
        current = n / 3;
        coin=coins;
        var myCard = new HashSet<Integer>();
        var checkedCard = new HashSet<Integer>();

        // 초기 카드 설정
        init(cards, n, myCard);
        removeInMyCard(myCard, n);
        while (current < n && count > 0) {
            //확인 가능한 카드들 추가
            addCard(cards, n, checkedCard);
            removeWithCouple(myCard, n, checkedCard);
            removeInCheckedCard(checkedCard, n);
        }

        return Math.min(round, n / 3 + 1);
    }

    private static void init(int[] cards, int n, HashSet<Integer> myCard) {
        for (int i = 0; i < n / 3; i++) {
            myCard.add(cards[i]);
        }
    }

    private void addCard(int[] cards, int n, HashSet<Integer> checkedCard) {
        while (count > 0 && current < n) {
            checkedCard.add(cards[current++]);
            checkedCard.add(cards[current++]);
            count--;
        }
    }

    private void removeInMyCard(HashSet<Integer> myCard, int n) {
        var iterator = myCard.iterator();
        // 이미 짝이 된 친구들 제거 & 라운드 추가 작업
        while (iterator.hasNext()){
            var card = iterator.next();
            var friend = n + 1 - card;
            if (myCard.contains(friend)) {
                myCard.remove(card);
                myCard.remove(friend);
                count++;
                round++;
                iterator= myCard.iterator();
            }
        }
    }

    private void removeWithCouple(HashSet<Integer> myCard, int n, HashSet<Integer> checkedCard) {
        //확인 가능한 카드들 중 짝이 맞는 카드 구입
        var iterator = myCard.iterator();
        while (iterator.hasNext() && coin > 0){
            var card = iterator.next();
            var friend = n + 1 - card;
            if (checkedCard.contains(friend)) {
                myCard.remove(card);
                checkedCard.remove(friend);
                coin--;
                count++;
                round++;
                iterator= myCard.iterator();
            }
        }
    }

    private void removeInCheckedCard(HashSet<Integer> checkedCard, int n) {
        // 짝 없으면(round==0) 본 카드들 중 짝 찾기 -> round!=0이면 카드를 더 추가하고 1개씩 교환하는게 효율적이기 때문
        if (count == 0) {
            var iterator = checkedCard.iterator();
            while (iterator.hasNext() && coin>=2){
                var card = iterator.next();
                var friend = n + 1 - card;
                if (checkedCard.contains(friend)) {
                    checkedCard.remove(card);
                    checkedCard.remove(friend);
                    coin-=2;
                    count++;
                    round++;
                    break;
                }
            }
        }
    }
}
