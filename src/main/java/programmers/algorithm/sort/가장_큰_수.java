package programmers.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = "";
        var list = new ArrayList<String>();
        for(int number:numbers){
            list.add(String.valueOf(number));
        }
        Collections.sort(list, (a, b) -> (a + b).compareTo(b + a) * -1);
        if(list.get(0).equals("0")){
            return "0";
        }
        var stringBuffer = new StringBuffer();
        for (String str: list){
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
