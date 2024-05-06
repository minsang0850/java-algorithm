package programmers.algorithm.dfsbfs;

import java.util.LinkedList;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {
        var flag = new boolean[words.length];
        var q = new LinkedList<WordWithDepth>();

        q.add(new WordWithDepth(begin, 0));
        while (!q.isEmpty()) {
            var polled = q.poll();
            var polledWord = polled.word;
            var depth = polled.depth;
            if(polledWord.equals(target)){
                return depth;
            }
            for (int i=0; i< words.length; i++){
                if(flag[i]) {
                    continue;
                }
                var diff = 0;
                var word = words[i];
                for (int j=0; j<word.length(); j++) {
                    if(word.charAt(j) != polledWord.charAt(j)){
                        diff++;
                    }
                }
                if(diff==1){
                    flag[i]=true;
                    q.add(new WordWithDepth(word, depth+1));
                }
            }
        }
        return 0;
    }

    class WordWithDepth {
        String word;
        int depth;

        public WordWithDepth(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
