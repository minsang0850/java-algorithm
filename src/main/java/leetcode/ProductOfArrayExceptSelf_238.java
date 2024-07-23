package leetcode;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        var answer = new int[nums.length];
        var totalMulti = 1;
        var zeroCount = 0;
        var zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]== 0){
                zeroCount++;
                zeroIndex = i;
                continue;
            }
            totalMulti *= nums[i];
        }
        if(zeroCount > 1){
            return answer;
        }

        if(zeroCount==1) {
            answer[zeroIndex] = totalMulti;
            return answer;
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = totalMulti / nums[i];
        }
        return answer;
    }
}
