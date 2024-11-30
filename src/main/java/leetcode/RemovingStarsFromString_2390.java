package leetcode;

import java.util.Stack;

public class RemovingStarsFromString_2390 {
    public String removeStars(String s) {
        var stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
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
