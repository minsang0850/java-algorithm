package programmers.summercoding2018;

public class 소수_만들기 {
    public static void main(String[] args) {
        var p = new 소수_만들기();
        p.solution(new int[]{1,2,3,4});
    }
    int answer=0;

    public int solution(int[] nums) {
        permutation(nums, 0, nums.length-1, 3, 0);
        return answer;
    }

    private void permutation(int[] nums, int start, int end, int size, int sum) {
        if(size==0){
            if(isPrime(sum)){
                answer++;
            }
            return;
        }
        if(start>end){
            return;
        }
        permutation(nums, start+1, end, size-1, sum+nums[start]);
        permutation(nums, start+1, end, size, sum);
    }

    private boolean isPrime(int num) {
        for (int i=2; i<num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
