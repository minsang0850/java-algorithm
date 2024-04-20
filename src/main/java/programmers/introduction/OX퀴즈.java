package programmers.introduction;

import java.util.Arrays;

public class OX퀴즈 {

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for (int i = 0; i < quiz.length; i++) {
            answer[i] = solution(quiz[i]);
        }
        return answer;
    }

    public String solution(String quiz) {
        var splitedString = quiz.split(" ");
        if (splitedString.length != 5) {
            return "X";
        }
        try {
            var firstNumber = Integer.parseInt(splitedString[0]);
            var secondNumber = Integer.parseInt(splitedString[2]);
            var resultNumber = Integer.parseInt(splitedString[4]);

            if (splitedString[1].equals("+")){
                if(firstNumber+secondNumber==resultNumber){
                    return "O";
                } else {
                    return "X";
                }
            }
            if (splitedString[1].equals("-")){
                if(firstNumber-secondNumber==resultNumber){
                    return "O";
                } else {
                    return "X";
                }
            }
        } catch (NumberFormatException e) {
            return "X";
        }

        return "O";
    }

}
