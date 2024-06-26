package leetcode;

public class Container_with_most_water {

    public static void main(String[] args) {
        var p = new Container_with_most_water();
        p.maxArea(new int[]{0,2});
    }
    public int maxArea(int[] height) {
        int area = 0;

        for(int i = 0; i < height.length; i++)
        {
            if (height[i]==0){
                continue;
            }
            for(int j = area/height[i]+i; j < height.length; j++)
            {
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;
    }
}
