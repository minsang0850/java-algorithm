package programmers.summercoding2018;

public class 점프와_순간_이동 {
    public int solution(int n) {
        int ans = 0;
        while(n>0){
            if(n%2==0){
                n=n/2;
            } else {
                ans++;
                n--;
            }
        }
        return ans;
    }
}
