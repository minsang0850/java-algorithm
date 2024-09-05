package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        for (int i=0; i<tokens.length; i++) {
            if (tokens[i].equals("+")) {
                var num1 = stack.pop();
                var num2 = stack.pop();
                stack.push(num2 + num1);
            }
            else if (tokens[i].equals("-")) {
                var num1 = stack.pop();
                var num2 = stack.pop();
                stack.push(num2 - num1);
            }
            else if (tokens[i].equals("*")) {
                var num1 = stack.pop();
                var num2 = stack.pop();
                stack.push(num2 * num1);
            }
            else if (tokens[i].equals("/")) {
                var num1 = stack.pop();
                var num2 = stack.pop();
                stack.push(num2 / num1);
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
