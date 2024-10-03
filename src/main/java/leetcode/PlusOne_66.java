package leetcode;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int checkIdx = digits.length - 1;
        while (checkIdx >= 0) {
            if(digits[checkIdx] == 9) {
                digits[checkIdx] = 0;
                checkIdx--;
            }
            else {
                digits[checkIdx]++;
                break;
            }
        }
        if(checkIdx==-1) {
            var answer = new int[digits.length+1];
            System.arraycopy(digits, 0, answer, 1, answer.length - 1);
            answer[0] = 1;
            return answer;
        }
        return digits;
    }
}
