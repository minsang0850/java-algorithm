package programmers.kakao2023blind;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class 개인정보_수집_유효기간 {
    public static void main(String[] args) {
        var p = new 개인정보_수집_유효기간();
        p.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 개인정보 n개
        // 약관마다 보관 유효기간
        // 모든 달은 28일까지
        var termMap = new HashMap<String, Integer>();
        for (String termWithLimit : terms) {
            var splitted = termWithLimit.split(" ");
            var term = splitted[0];
            var limit = Integer.parseInt(splitted[1]);
            termMap.put(term, limit);
        }
        var answer = new ArrayList<Integer>();

        for (int i=0; i< privacies.length; i++){
            var splitted = privacies[i].split(" ");
            var date = splitted[0];
            var term = splitted[1];
            var limit = termMap.get(term);
            if(afterLimit(date,today,limit)){
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean afterLimit(String date, String today, Integer limit) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        var originDate = LocalDate.parse(date, formatter);
        var todayDate = LocalDate.parse(today, formatter);
        var calculatedDate = originDate.plusMonths(limit);
        return !todayDate.isBefore(calculatedDate);
    }
}
