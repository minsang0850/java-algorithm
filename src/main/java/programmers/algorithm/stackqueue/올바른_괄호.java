package programmers.algorithm.stackqueue;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            var current = s.charAt(i);
            if(current == '(') {
                stack.push("(");
            }
            if(current == ')') {
                if(stack.empty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
