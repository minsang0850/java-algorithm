package leetcode;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        var sum = 0;
        for (int num : nums) {
            sum += num;
        }
        var leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
