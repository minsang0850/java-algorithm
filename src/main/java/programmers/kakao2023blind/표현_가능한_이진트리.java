package programmers.kakao2023blind;

public class 표현_가능한_이진트리 {

    public static void main(String[] args) {
        var p = new 표현_가능한_이진트리();
        p.solution(new long[]{42});
    }
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        // 7 -> 111
        // 42 -> 0101010
        // 5-> 101
        for (int i=0; i<numbers.length; i++) {
            if(calculate(numbers[i])) {
                answer[i]=1;
            }else {
                answer[i]=0;
            }
        }
        return answer;
    }

    private boolean calculate(long number) {
        var binaryString = Long.toBinaryString(number);
        var length = binaryString.length();
        var lenPlusOne = length+1;
        var sb = new StringBuilder();
        while (!isPowerOfTwo(lenPlusOne)) {
            lenPlusOne++;
            sb.append("0");
        }
        sb.append(binaryString);
        var completed = sb.toString();
        return check(completed, 0, completed.length());
    }

    private boolean check(String completed, int start, int length) {
        if(length==1) {
            return true;
        }
        var mid = (length)/2 + start;
        if(completed.charAt(mid)!='1') {
            return isOnlyZeros(completed.substring(start, start+length));
        }
        return check(completed, start, length/2)
               && check(completed, mid+1, length/2);
    }

    public static boolean isPowerOfTwo(int n) {
        // 0 이하의 숫자는 2의 제곱수가 될 수 없습니다.
        if (n <= 0) {
            return false;
        }
        // n이 2의 제곱수라면 (n & (n - 1))은 0이어야 합니다.
        return (n & (n - 1)) == 0;
    }

    public static boolean isOnlyZeros(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
