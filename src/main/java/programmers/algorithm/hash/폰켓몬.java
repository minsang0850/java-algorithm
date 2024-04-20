package programmers.algorithm.hash;

public class 폰켓몬 {

    int[] kindArray = new int[200001];
    public int solution(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            kindArray[num]++;
        }
        int kind = 0;
        for(int i = 0; i< 200001; i++){
            if(kindArray[i]>0){
                kind++;
            }
        }
        if(kind> nums.length/2){
            return nums.length/2;
        }
        return kind;
    }

}
