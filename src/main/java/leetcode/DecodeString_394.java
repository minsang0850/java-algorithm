package leetcode;

import java.util.Stack;

public class DecodeString_394 {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            var c = s.charAt(i);
            if(c == ']') {
                var sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                var num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.append(stack.pop());
                }
                int count = Integer.parseInt(num.reverse().toString());
                String str = sb.reverse().toString();
                for (int j=0; j<count; j++) {
                    for (char ch : str.toCharArray()) {
                        stack.push(ch);
                    }
                }
            } else {
                stack.push(c);
            }
        }
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
