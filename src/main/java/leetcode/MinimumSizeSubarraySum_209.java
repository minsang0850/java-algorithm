package leetcode;

public class MinimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        var p = new MinimumSizeSubarraySum_209();
//        p.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
//        p.minSubArrayLen(4, new int[]{1,4,4});
//        p.minSubArrayLen(11, new int[]{1,1,1, 1, 1, 1, 1, 1});
        p.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        var sum = nums[0];
        var answer = 987654321;
        if (sum == target) {
            return 1;
        }
        while (right < nums.length) {
            while (sum < target && right < nums.length - 1) {
                right++;
                sum += nums[right];
            }
            if (sum >= target) {
                answer = Math.min(answer, right - left + 1);
            } else {
                break;
            }
            while (sum >= target && left < right) {
                answer = Math.min(answer, right - left + 1);
                sum -= nums[left];
                left++;
            }
            if (left == right && sum >= target) {
                return 1;
            }
        }
        if (answer == 987654321) {
            return 0;
        }
        return answer;
    }
}
