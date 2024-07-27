package leetcode;

import java.util.Arrays;


public class IntegerToRoman_12 {
    public static void main(String[] args) {
        var p = new IntegerToRoman_12();
        p.intToRoman(100);
    }
    public String intToRoman(int num) {
        if(num<10) {
            return intToRoman(num, 0);
        }
        var level = getLevel(num);
        var divideValue = pow(level);
        var currentValue = num / divideValue;
        return intToRoman(currentValue, level) + intToRoman(num % divideValue);
    }

    private String intToRoman(int currentValue, int level) {
        if(currentValue==0) {
            return "";
        }
        if (currentValue <= 3) {
            var roman = Roman.getBasicRoman(level);
            var result = "";
            for (int i = 0; i < currentValue; i++) {
                result += roman.name();
            }
            return result;
        }
        if (currentValue == 4) {
            var roman = Roman.getBasicRoman(level);
            var fiveRoman = Roman.getFiveRoman(level);
            return roman.name() + fiveRoman.name();
        }
        if (currentValue < 9) {
            var roman = Roman.getBasicRoman(level);
            var fiveRoman = Roman.getFiveRoman(level);
            var result = fiveRoman.name();
            for (int i = 0; i < currentValue-5; i++) {
                result += roman.name();
            }
            return result;
        }
        return Roman.getBasicRoman(level).name() + Roman.getBasicRoman(level + 1).name();
    }

    private int getLevel(int num) {
        var level = 0;
        while (num >= 10) {
            num /= 10;
            level++;
        }
        return level;
    }

    enum Roman {
        I(1, 0),
        V(5, 0),
        X(10, 1),
        L(50, 1),
        C(100, 2),
        D(500, 2),
        M(1000, 3);

        private final int value;
        private final int level;

        Roman(int value, int level) {
            this.value = value;
            this.level = level;
        }

        static Roman getBasicRoman(int level) {
            return Arrays.stream(Roman.values())
                    .filter(roman -> roman.level == level)
                    .findFirst()
                    .get();
        }

        static Roman getFiveRoman(int level) {
            return Arrays.stream(Roman.values())
                    .filter(roman -> roman.level == level && roman.value / pow(level) == 5)
                    .findFirst()
                    .get();
        }

        private static int pow(int level) {
            var answer = 1;
            for (int i=0; i<level; i++) {
                answer*=10;
            }
            return answer;
        }
    }

    private int pow(int level) {
        var answer = 1;
        for (int i=0; i<level; i++) {
            answer*=10;
        }
        return answer;
    }
}
