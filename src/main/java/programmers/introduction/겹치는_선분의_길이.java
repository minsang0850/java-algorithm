package programmers.introduction;

public class 겹치는_선분의_길이 {
    public int solution(int[][] lines) {
        int answer = 0;
        int duplicatelines = 0;
        for(int i=-100; i<=100; i++) {
            if(duplicatelines>=2){
                answer++;
            }
            for(int j=0; j<3; j++){
                if(lines[j][0]==i){
                    duplicatelines++;
                }
                if(lines[j][1]==i){
                    duplicatelines--;
                }

            }
        }

        return answer;
    }

}
