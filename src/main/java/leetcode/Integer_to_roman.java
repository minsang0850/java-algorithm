package leetcode;

public class Integer_to_roman {
    public String intToRoman(int num) {
        var answer = "";
        if(num/1000>0) {
            var mock = num/1000;
            for(int i=0; i<mock; i++) {
                answer += "M";
            }
        }
        num %= 1000;
        if(num/900>0) {
            answer += "CM";
            num -= 900;
        }
        if (num / 500 > 0) {
            answer += "D";
            num -= 500;
        }
        if (num / 400 > 0) {
            answer += "CD";
            num -= 400;
        }
        if (num / 100 > 0) {
            var mock = num / 100;
            for (int i = 0; i < mock; i++) {
                answer += "C";
            }
        }
        num %= 100;
        if (num / 90 > 0) {
            answer += "XC";
            num -= 90;
        }
        if (num / 50 > 0) {
            answer += "L";
            num -= 50;
        }
        if (num / 40 > 0) {
            answer += "XL";
            num -= 40;
        }
        if (num / 10 > 0) {
            var mock = num / 10;
            for (int i = 0; i < mock; i++) {
                answer += "X";
            }
        }
        num %= 10;
        if (num / 9 > 0) {
            answer += "IX";
            num -= 9;
        }
        if (num / 5 > 0) {
            answer += "V";
            num -= 5;
        }
        if (num / 4 > 0) {
            answer += "IV";
            num -= 4;
        }
        if (num / 1 > 0) {
            var mock = num / 1;
            for (int i = 0; i < mock; i++) {
                answer += "I";
            }
        }
        return answer;
    }
}
