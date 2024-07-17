package leetcode;

public class BestTimeToBuyAndSellStock2_150 {
    public int maxProfit(int[] prices) {
        if(prices.length <=1) {
            return 0;
        }
        var answer = 0;
        var currentValue = prices[0];
        var currentIdx = 0;
        while (currentIdx< prices.length) {
            while (currentIdx < prices.length && prices[currentIdx] >= currentValue) {
                answer += prices[currentIdx] - currentValue;
                currentValue = prices[currentIdx];
                currentIdx++;
            }
            if(currentIdx== prices.length) {
                return answer;
            }
            currentValue = prices[currentIdx];
            currentIdx++;
        }
        return answer;
    }
}
