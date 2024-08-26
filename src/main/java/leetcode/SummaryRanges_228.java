package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        var answer = new ArrayList<String>();
        if (nums.length == 0) {
            return answer;
        }
        var str = nums[0] + "";
        var prev = nums[0];
        for (int i=1; i<nums.length; i++) {
            if(prev+1 == nums[i]) {
                prev = nums[i];
            } else {
                if (prev == Integer.parseInt(str)) {
                    answer.add(str);
                } else {
                    answer.add(str + "->" + prev);
                }
                str = nums[i] + "";
                prev = nums[i];
            }
        }
        if (prev == Integer.parseInt(str)) {
            answer.add(str);
        } else {
            answer.add(str + "->" + prev);
        }
        return answer;
    }
}
