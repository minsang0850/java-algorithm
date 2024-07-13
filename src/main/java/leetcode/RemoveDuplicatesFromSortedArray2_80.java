package leetcode;

public class RemoveDuplicatesFromSortedArray2_80 {
    public static void main(String[] args) {
        var p = new RemoveDuplicatesFromSortedArray2_80();
        p.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        var currentIdx = 0;
        var prevValue = nums[0];
        var count = 0;
        for (int i=0; i<nums.length; i++) {
            if(nums[i] == prevValue) {
                count++;
                if(count>2){
                    continue;
                }
                nums[currentIdx++] = nums[i];
                continue;
            }
            count = 1;
            nums[currentIdx++] = nums[i];
            prevValue = nums[i];
        }
        return currentIdx;
    }
}
