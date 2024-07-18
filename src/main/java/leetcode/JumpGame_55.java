package leetcode;

public class JumpGame_55 {
    public static void main(String[] args) {
        var p = new JumpGame_55();
        p.canJump(new int[]{2,0,0});
    }
    public boolean canJump(int[] nums) {
        int[] dp = new int[10000];
        if(nums.length == 1){
            return true;
        }
        return canJump(nums, dp,0);
    }

    boolean canJump(int[] nums, int[] dp, int idx) {
        if(dp[idx] == 1){
            return true;
        }
        if(dp[idx] == -1){
            return false;
        }
        if(idx>=nums.length-1){
            return true;
        }
        var jumpValue = nums[idx];
        for (int i=1; i<=jumpValue; i++) {
            var flag = canJump(nums, dp, idx + i);
            if(flag){
                dp[idx] = 1;
                return true;
            }
       }
        dp[idx]=-1;
        return false;
    }
}
