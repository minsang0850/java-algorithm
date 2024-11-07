package leetcode;

public class LongestSubarrayOf1sAfterDeletingOneElement_1493 {
    public int longestSubarray(int[] nums) {
        var zeroIdx = -1;
        var left=0;
        var answer=0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                if(zeroIdx == -1) { //0이 없었다면.
                    zeroIdx = right;
                } else { //이미 0이 있었다면
                    left= zeroIdx+1;
                    zeroIdx = right;
                }
            }
            answer = Math.max(answer, right-left);
        }

        return answer;
    }
}
