package programmers.algorithm.stackqueue;

import java.util.Stack;

public class 주식가격 {

    public static void main(String[] args) {
        var p = new 주식가격();
        var a = p.solution(new int[]{1, 2, 3, 2, 3});
        var b = p.solution(new int[]{1});
        var c = p.solution(new int[]{1, 2, 3, 4});
        var d = p.solution(new int[]{4, 3, 2, 1});
        var answer = p.solution(new int[]{1, 3, 5, 4, 2});
        System.out.println(answer);
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        var stack = new Stack<Integer>();
        var top = prices[0];
        for (int i = 0; i < prices.length; i++) {
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    top = prices[i];
                    break;
                }
                if (top > prices[i]) {
                    var popped = stack.pop();
                    answer[popped] = i - popped;
                    top = getTop(stack, prices);
                } else {
                    stack.push(i);
                    top = prices[i];
                    break;
                }
            }

        }
        for (int i = 0; i < prices.length - 1; i++) {
            if (answer[i] == 0) {
                answer[i] = prices.length - i - 1;
            }
        }
        return answer;
    }

    private int getTop(Stack<Integer> stack, int[] prices) {
        if (stack.isEmpty()) {
            return 0;
        }
        var popped = stack.pop();
        stack.push(popped);
        return prices[popped];
    }
}
