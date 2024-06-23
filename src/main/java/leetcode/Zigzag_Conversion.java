package leetcode;

public class Zigzag_Conversion {
    char[][] map = new char[1000][1000];

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= 1) {
            return s;
        }
        var current = 0;
        for (int i = 0; i < s.length(); i += 2 * (numRows - 1)) {
            for (int j = 0; j < numRows && i + j < s.length(); j++) {
                map[current][j] = s.charAt(i + j);
            }
            current++;
            for (int j = numRows; j < 2 * numRows - 2 && i + j < s.length(); j++) {
                map[current][numRows * 2 - j - 2] = s.charAt(i + j);
                current++;
            }
        }
        var sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < current; j++) {
                if (map[j][i] != 0) {
                    sb.append(map[j][i]);
                }
            }
        }
        return sb.toString();
    }
}
