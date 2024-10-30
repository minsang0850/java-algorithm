package leetcode;

public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet(int[] nums) {
        var db = -1;
        var single = 0;

        for (int i=1; i< nums.length; i++) {
            if(db>=0 && nums[db]<nums[i]) {
                return true;
            }
            if(nums[single]<nums[i]) {
                if(db>=0) { //값이 있으면 비교해서 넣어야함
                    if(nums[db]>nums[i]) {
                        db=i;
                    }
                } else { //더블이 없었음녀 그냥 넣음
                    db=i;
                }
            } else {
                single=i;
            }
        }
        return false;
    }
}
