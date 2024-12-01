package leetcode;

import java.util.Stack;

public class AsteroidCollision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new Stack<Integer>();

        for (int value : asteroids) {
            if(stack.isEmpty()) {
                stack.push(value);
                continue;
            }
            while(!stack.isEmpty()) {
                int top = stack.peek();
                if(top>0 && value<0) {
                    if(top == -value) {
                        stack.pop();
                        break;
                    } else if(top > -value) {
                        break;
                    } else {
                        stack.pop();
                        if(stack.isEmpty()) {
                            stack.push(value);
                            break;
                        }
                    }
                } else {
                    stack.push(value);
                    break;
                }
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
