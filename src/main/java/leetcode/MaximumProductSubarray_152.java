package leetcode;

public class MaximumProductSubarray_152 {

    public static void main(String[] args) {
        var p = new MaximumProductSubarray_152();
//        p.maxProduct(new int[] { 2, 3, -2, 4 });
//        p.maxProduct(new int[]{-2, 0, -1});
//        p.maxProduct(new int[]{-2, 3, -4});
        p.maxProduct(new int[]{1,0,-1,2,3,-5,-2});
    }

    public int maxProduct(int[] nums) {
        var answer = nums[0];
        var prefix = 0;
        var total = 1;
        var start = 1;
        for (int num : nums) {
            if(num<0){
                prefix = num;
            }
            if (num != 0) {
                answer = num;
                total = num;
                break;
            }
            start++;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] == 0) {
                answer = Math.max(answer, 0);
                total = 1;
                prefix = 0;
            }
            if (nums[i] < 0) {
                total *= nums[i];
                if (prefix == 0) { //첫번째 음수인 경우
                    prefix = total;
                    continue;
                }
                answer = Math.max(answer, total);
                answer = Math.max(answer, total / prefix);
            }
            if (nums[i] > 0) {
                total *= nums[i];

                if (total > 0) {
                    answer = Math.max(answer, total);
                } else {
                    answer = Math.max(answer, total / prefix);
                }
            }
        }
        return answer;
    }
}
