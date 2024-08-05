package leetcode;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        var front = 0;
        var back = height.length - 1;
        var answer = 0;
        while (front<back) {
            var width = back - front;
            var h = Math.min(height[front], height[back]);
            answer = Math.max(answer, width * h);
            if (height[front] < height[back]) {
                front++;
            } else {
                back--;
            }
        }
        return answer;
    }
}
