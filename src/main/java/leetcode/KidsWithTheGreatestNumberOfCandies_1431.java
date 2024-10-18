package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        var answer = new ArrayList<Boolean>();
        for (int i = 0; i < candies.length; i++) {
            answer.add(candies[i] + extraCandies >= max);
        }
        return answer;
    }
}
