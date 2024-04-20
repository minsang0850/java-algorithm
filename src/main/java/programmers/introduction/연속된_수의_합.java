package programmers.introduction;

public class 연속된_수의_합 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(num%2==0){
            var middleNum = total/num;
            var minNum = middleNum-(num/2-1);
            for(int i = 0; i<num; i++){
                answer[i]=minNum+i;
            }
        }
        if(num%2==1){
            var middleNum = total/num;
            var minNum = middleNum-(num/2);
            for(int i = 0; i<num; i++){
                answer[i]=minNum+i;
            }
        }
        return answer;
    }
}
