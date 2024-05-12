package programmers.previousexam.kakaocodepre2017;

public class 사단_고음 {
    public static void main(String[] args) {
        var p = new 사단_고음();
        p.solution(2147483647);
    }
    long target;
    int answer = 0;
    public int solution(int n) {
        target=n;
        bfs(n-2, 2);
        return answer;
    }

    private void bfs(long current, int plus) {
        if(current < 1 || Math.log(current)/Math.log(3) < (plus + 1)/2){
            return ;
        }
        if(current==3){
            if(plus==2) answer++;
            return;
        }
        if(current%3==0 && plus>1) {
            bfs(current/3, plus-2);
        }
        bfs(current-1, plus+1);
    }
}
