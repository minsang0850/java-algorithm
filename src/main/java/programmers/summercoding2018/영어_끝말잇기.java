package programmers.summercoding2018;

import java.util.HashSet;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        var p = new 영어_끝말잇기();
        p.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
    public int[] solution(int n, String[] words) {
        var turn = 0;
        char prev = ' ';
        var wordSet = new HashSet<String>();
        while (true) {
            turn++;
            for (int i = 0; i < n; i++) {
                var now = (turn-1) * n + i;
                if(now>words.length-1){
                    return new int[]{0,0};
                }
                var currentWord = words[now];
                if (now != 0) {
                    if (prev != currentWord.charAt(0)) {
                        return new int[]{i + 1, turn};
                    } else{
                        if(wordSet.contains(currentWord)){
                            return new int[]{i + 1, turn};
                        }
                        prev=currentWord.charAt(currentWord.length()-1);
                        wordSet.add(currentWord);
                    }
                } else {
                    prev = currentWord.charAt(currentWord.length() - 1);
                    wordSet.add(currentWord);
                }
            }
        }
    }
}
