package programmers.practice.level2;

public class 광물_캐기 {
    public static void main(String[] args) {
        var p = new 광물_캐기();
        p.solution(new int[]{1,3,2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"});
    }
    int answer = 987654321;

    public int solution(int[] picks, String[] minerals) {
        var dia = picks[0];
        var iron = picks[1];
        var stone = picks[2];
        dfs(dia, iron, stone, 0, 0, minerals);
        return answer;
    }

    private void dfs(int dia, int iron, int stone, int idx, int sum, String[] minerals) {
        var limit = Math.min(minerals.length, idx + 5);
        if (idx == limit || (dia==0 && iron==0 && stone==0)) {
            answer = Math.min(sum, answer);
            return;
        }
        var basicIdx = idx;
        if (dia > 0) {
            var piro = 0;
            while (idx < limit) {
                piro++;
                idx++;
            }
            dfs(dia - 1, iron, stone, limit, sum + piro, minerals);
        }
        if (iron > 0) {
            idx = basicIdx;
            var piro = 0;
            while (idx < limit) {
                if (minerals[idx].equals("diamond")) {
                    piro += 5;
                } else {
                    piro++;
                }
                idx++;
            }
            dfs(dia, iron - 1, stone, limit, sum + piro, minerals);
        }
        if (stone > 0) {
            idx = basicIdx;
            var piro = 0;
            while (idx < limit) {
                if (minerals[idx].equals("diamond")) {
                    piro += 25;
                } else if (minerals[idx].equals("iron")) {
                    piro += 5;
                } else {
                    piro++;
                }
                idx++;
            }
            dfs(dia, iron, stone - 1, limit, sum + piro, minerals);
        }
    }
}
