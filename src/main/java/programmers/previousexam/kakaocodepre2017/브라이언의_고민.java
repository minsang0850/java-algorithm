package programmers.previousexam.kakaocodepre2017;

import java.util.ArrayList;
import java.util.List;

public class 브라이언의_고민 {
    public static void main(String[] args) {
        var p = new 브라이언의_고민();
        var answer= p.solution("SpIpGpOpNpGJqOqA");
        return;
    }
    List<String> usedMarks = new ArrayList<String>();
    public String solution(String sentence) {
        var sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (i != 0) {
                sb.append(" ");
            }
            //특수문자로 시작하는 경우 == 규칙 2
            if (isSpecial(sentence.charAt(i))) {
                if(isUsed(sentence.charAt(i))){
                    return "INVALID";
                }
                var substr = "";
                int j = i + 1;
                for (; j < sentence.length(); j++) {
                    if (sentence.charAt(i) == sentence.charAt(j)) {
                        substr = sentence.substring(i + 1, j);
                        break;
                    }
                }
                // 규칙 2 solve -> substr
                if ("".equals(substr)) {
                    return "invalid";
                }
                char specialMark = '~';
                if (1 < substr.length()) {
                    specialMark = substr.charAt(1);
                }
                if (!isSpecial(specialMark)) {
                    for (int k = 0; k < substr.length(); k++) {
                        if (isSpecial(substr.charAt(k))) {
                            return "invalid";
                        } else {
                            sb.append(substr.charAt(k));
                        }
                    }
                }
                else {
                    for (int k = 0; k < substr.length(); k++) {
                        if (k % 2 == 1) {
                            if (specialMark != substr.charAt(k)) {
                                return "invalid";
                            }
                        } else {
                            if (isSpecial(substr.charAt(k))) {
                                return "invalid";
                            }
                            sb.append(substr.charAt(k));
                        }
                    }
                }
                i = j;
            }



            else {
                char specialMark = '~';
                if (i + 1 < sentence.length()) {
                    specialMark = sentence.charAt(i + 1);
                }
                int k = i;
                if (!isSpecial(specialMark)) {
                    while (k < sentence.length() && !isSpecial(sentence.charAt(k))) {
                        sb.append(sentence.charAt(k));
                        k++;
                    }
                    i = k - 1;
                }
                else {
                    if(isUsed(specialMark)){
                        return "invalid";
                    }
                    for (; k < sentence.length(); k++) {
                        //홀수번째
                        if ((k - i) % 2 == 1) {
                            if (specialMark != sentence.charAt(k)) {
                                i = k - 1;
                                break;
                            }
                        } else { //짝수번째
                            if (isSpecial(sentence.charAt(k))) {
                                return "invalid";
                            }
                            sb.append(sentence.charAt(k));
                        }
                    }
                    i = k - 1;
                }
            }
        }
        return sb.toString();
    }

    private boolean isUsed(char c) {
        for (int i=0; i<usedMarks.size(); i++) {
            if (usedMarks.get(i).charAt(0)==c){
                return true;
            }
        }
        usedMarks.add(String.valueOf(c));
        return false;
    }

    boolean isSpecial(char character) {
        if (character >= 'a' && character <= 'z') {
            return true;
        }
        return false;
    }

}
