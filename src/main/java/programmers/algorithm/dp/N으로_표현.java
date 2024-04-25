package programmers.algorithm.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class N으로_표현 {
    public static void main(String[] args) {
        var p = new N으로_표현();
        p.solution(5, 12);
    }
    public int solution(int num, int target) {
        var makedNumbers = new Set[9];
        for (int i = 1; i < 9; i++) {
            var set = new HashSet<Integer>();
            var eleven = getEleven(i) * num;
            if (eleven == target) {
                return i;
            }
            set.add(eleven);
            for (int j = 1; j <= i / 2; j++) {
                for (Object frontNumber : makedNumbers[j]) {
                    for (Object backNumber : makedNumbers[i - j]) {
                        var front = (int) frontNumber;
                        var back = (int) backNumber;
                        //front>=back으로 만들기
                        if (front < back) {
                            var temp = front;
                            front = back;
                            back = temp;
                        }
                        var add = front + back;
                        var sub = front - back;
                        var mul = front * back;
                        var div = front / back;
                        if(add==target){
                            return i;
                        }
                        if(sub==target){
                            return i;
                        }
                        if(mul==target){
                            return i;
                        }
                        if(div==target){
                            return i;
                        }
                        set.add(add);
                        if(sub!=0) {
                            set.add(sub);
                        }
                        set.add(mul);
                        set.add(div);
                    }
                }
            }
            makedNumbers[i]=set;
        }
        return -1;
    }

    private Integer getEleven(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 11;
            case 3:
                return 111;
            case 4:
                return 1111;
            case 5:
                return 11111;
            case 6:
                return 111111;
            case 7:
                return 1111111;
            case 8:
                return 11111111;
            default:
                return 0;
        }
    }
}
