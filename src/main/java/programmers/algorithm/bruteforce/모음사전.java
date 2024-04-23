package programmers.algorithm.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 모음사전 {
    public static void main(String[] args) {
        var p = new 모음사전();
        p.solution("");
    }
    public int solution(String word) {
        String chars = "AEIOU";
        var set = new HashSet<String>();
        permute(set, "", chars);
        var list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)){
                return i+1;
            }
        }
        return 0;
    }

    private void permute(HashSet<String> set, String prefix, String chars) {
        if(prefix.length()!=0){
            set.add(prefix);
        }
        if(prefix.length()>=5){
            return;
        }
        for (int i=0; i<chars.length(); i++){
            permute(set, prefix+chars.charAt(i), chars.substring(0, i) + chars.substring(i, chars.length()));
        }
    }
}
