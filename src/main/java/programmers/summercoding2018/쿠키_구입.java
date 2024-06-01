package programmers.summercoding2018;

public class 쿠키_구입 {
    public static void main(String[] args) {
        var p = new 쿠키_구입();
        p.solution(new int[]{1,1,2,3});
    }
    int[][] dp=new int[2001][2001];
    int len;
    int[] cookies;
    int answer = 0;
    public int solution(int[] cookie) {
        len = cookie.length;
        cookies=cookie;
        for (int i=0; i<len; i++){
            for (int j=i; j<len; j++) {
                if(i==j){
                    dp[i][j]= cookies[i];
                } else {
                    dp[i][j]=dp[i][j-1]+cookies[j];
                }
            }
        }

        for (int l=0; l<len-1; l++){
            for(int m=len-1; m>=l; m--){
                var first = dp[l][m];
                if(first<answer){
                    break;
                }
                binearySearch(m+1, m+1, len-1, first);
            }
        }
        return answer;
    }

    private void binearySearch(int mPlusOne, int start, int end, int first) {
        if(start>end){
            return;
        }
        var mid = (start+end)/2;
        if(dp[mPlusOne][mid]==first){
            answer=Math.max(answer, first);
        } else if(dp[mPlusOne][mid]>first){
            binearySearch(mPlusOne, start, mid-1, first);
        } else {
            binearySearch(mPlusOne, mid+1, end, first);
        }
    }
}
