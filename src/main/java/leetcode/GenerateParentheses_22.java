package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        combination(result,stack, n, 0, "", 0);
        return result;
    }

    private void combination(List<String> result, Stack<String> stack, int n, int index, String str, int in) {
        if(in> n) {
            return;
        }
        if(index == 2*n) {
            result.add(str);
            return;
        }
        var newStack = (Stack<String>)stack.clone();
        stack.push("(");
        combination(result, stack, n, index+1, str+"(", in+1);
        if(!newStack.isEmpty()) {
            newStack.pop();
            combination(result, newStack, n, index+1, str+")", in);
        }
    }
}
