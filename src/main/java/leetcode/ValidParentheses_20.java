package leetcode;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        var stack = new java.util.Stack<Character>();
        var in = new char[]{'(', '{', '['};
        var out = new char[]{')', '}', ']'};
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == in[0] || s.charAt(i) == in[1] || s.charAt(i) == in[2] ){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if(s.charAt(i) == out[0] && stack.peek() != in[0]) {
                    return false;
                }
                if(s.charAt(i) == out[1] && stack.peek() != in[1]) {
                    return false;
                }
                if(s.charAt(i) == out[2] && stack.peek() != in[2]) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
