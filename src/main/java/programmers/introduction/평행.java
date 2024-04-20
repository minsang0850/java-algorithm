package programmers.introduction;

public class 평행 {
    public int solution(int[][] dots) {
        int answer = 0;
        if (caculateSlope(dots[0], dots[1]) == caculateSlope(dots[2], dots[3])){
            return 1;
        }
        if (caculateSlope(dots[0], dots[2]) == caculateSlope(dots[1], dots[3])){
            return 1;
        }
        if (caculateSlope(dots[0], dots[3]) == caculateSlope(dots[1], dots[2])){
            return 1;
        }
        return 0;
    }

    private double caculateSlope(int[] a, int[] b) {
        return (double)(a[0]-b[0]) / (double)(a[1]-b[1]);
    }
}
