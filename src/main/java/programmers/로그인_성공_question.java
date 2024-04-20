package programmers;

public class 로그인_성공_question {

    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        for (String[] accountToCheck : db) {
            if (accountToCheck[0].equals(id_pw[0])) {
                if (accountToCheck[1].equals(id_pw[1])) {
                    return "login";
                }
                answer = "wrong pw";
            }
        }
        return answer;
    }
}
