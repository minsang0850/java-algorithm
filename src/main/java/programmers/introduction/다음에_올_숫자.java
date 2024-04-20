package programmers.introduction;

public class 다음에_올_숫자 {
    public int solution(int[] common) {
        int answer = 0;
        if (common[2] - common[1] == common[1] - common[0]) {
            int diff = common[2] - common[1];
            return common[common.length - 1] + diff;
        }

        int commonRatio = common[2] / common[1];
        return common[common.length - 1] * commonRatio;

    }
}
