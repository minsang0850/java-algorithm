package leetcode;

public class JumpGame2_45 {
    public static void main(String[] args) {
        var p = new JumpGame2_45();
        p.jump(new int[]{2,3,1,1,4});
    }
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i=0; i<dp.length-1; i++) {
            dp[i] = -1;
        }
        if(nums.length == 1){
            return 0;
        }
        return jump(nums, dp,0);
    }

    private int jump(int[] nums, int[] dp, int idx) {
        if(idx>dp.length-1){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        var value = 987654321;
        for (int i=1; i<=nums[idx]; i++) {
            value = Math.min(value, jump(nums, dp, idx + i) + 1);
        }
        dp[idx] = value;
        return value;
    }
}
