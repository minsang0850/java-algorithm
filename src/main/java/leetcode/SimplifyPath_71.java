package leetcode;

import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        var split = path.split("/");

        var stack = new Stack<String>();
        for (int i=0; i<split.length; i++) {
            if(split[i].equals("") || split[i].equals(".")) {
                continue;
            }
            if(split[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(split[i]);
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<stack.size(); i++) {
            answer.append("/").append(stack.get(i));
        }
        return answer.length() == 0 ? "/" : answer.toString();
    }
}
