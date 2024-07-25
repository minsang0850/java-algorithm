package leetcode;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        var result = 0;
        for (int i=0; i<s.length(); i++) {
            var current = Roman.valueOf(String.valueOf(s.charAt(i)));
            if(i+1==s.length()) {
                result+=current.value;
                break;
            }
            var next = Roman.valueOf(String.valueOf(s.charAt(i+1)));
            if(current.ordinal()<next.ordinal()) {
                result+=next.value-current.value;
                i++;
            } else {
                result+=current.value;
            }
        }
        return result;
    }

    enum Roman{
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        public final int value;

        Roman(int value) {
            this.value = value;
        }
    }
}


