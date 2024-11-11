package leetcode;

public class MinimumReplacementsToSortTheArray_2366 {
    public static void main(String[] args) {
        var instance = new MinimumReplacementsToSortTheArray_2366();
        var result = instance.minimumReplacement(new int[]{12,9,7,6,17,19,21});
        System.out.println(result);
    }
    public long minimumReplacement(int[] nums) {
        var n = nums.length;
        long answer = 0;
        var next = nums[n-1];
        for (int i = n-2; i >=0; i--) {
            var num = nums[i];
            if(num>next) {
                var k  = num/next;
                var x = num%next;
                if(x==0) {
                    answer += (long)k-1;
                } else {
                    next = num/(k+1);
                    answer += (long)k;
                }
            } else {
                next = num;
            }
        }
        return answer;
    }
}
