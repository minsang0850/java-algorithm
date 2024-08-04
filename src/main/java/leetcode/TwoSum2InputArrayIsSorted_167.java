package leetcode;

public class TwoSum2InputArrayIsSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        var after = numbers.length-1;
        for (int i=0; i<numbers.length; i++) {
            var firstNum = numbers[i];
            while (numbers[after] + firstNum >target) {
                after--;
            }
            if(i>=after) {
                break;
            }
            if(firstNum + numbers[after]==target) {
                return new int[]{i+1, after+1};
            }
        }
        return new int[]{0,0};
    }
}
