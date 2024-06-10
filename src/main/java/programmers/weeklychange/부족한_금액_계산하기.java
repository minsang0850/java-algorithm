package programmers.weeklychange;

public class 부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {
        long moneyLong = money;
        long priceLong = price;
        for (int i=0; i<count; i++) {
            moneyLong-=priceLong*(i+1);
        }
        if(moneyLong<0){
            return -moneyLong;
        }
        return 0;
    }
}
