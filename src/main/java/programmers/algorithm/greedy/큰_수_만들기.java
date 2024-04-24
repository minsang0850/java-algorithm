package programmers.algorithm.greedy;

import java.util.Stack;

public class 큰_수_만들기 {
    public static void main(String[] args) {
        var p = new 큰_수_만들기();
        p.solution("4177252841", 4);
    }
    public String solution(String number, int k) {
        var answerLen = number.length()-k;
        var stack = new Stack<Integer>();
        for (int i=0; i<number.length(); i++){
            var c = number.charAt(i)-'0';
            while(!stack.isEmpty() && stack.peek()<c && k-->0) {
                stack.pop();
            }
            stack.push(c);
        }
        var sb = new StringBuilder();
        for (int i=0; i<answerLen; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
