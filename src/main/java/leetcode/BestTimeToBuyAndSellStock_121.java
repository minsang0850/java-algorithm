package leetcode;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        if(prices.length <=1) {
            return 0;
        }
        var answer = 0;
        var currentMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] <= currentMin) {
                currentMin = prices[i];
                continue;
            }
            answer = Math.max(answer, prices[i] - currentMin);
        }
        return answer;
    }
}
