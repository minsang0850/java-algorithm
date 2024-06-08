package programmers.summercoding2019;

import java.math.BigInteger;

public class 멀쩡한_사각형 {
    public static void main(String[] args) {
        var p = new 멀쩡한_사각형();
//        p.solution(8, 12);
//        p.solution(12, 8);
//        p.solution(1,1);
//        p.solution(2,2);
//        p.solution(2,3);
//        p.solution(5,7);
//        p.solution(7,3);
//        p.solution(10, 1);
//        p.solution(3, 6);
//        p.solution(3, 7);
        p.solution(5, 3);
    }

    public long solution(int w, int h) {
        long totalCount = (long) w * (long) h;
        long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return totalCount - diagonalCount;
    }
}
