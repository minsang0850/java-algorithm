package leetcode;

import java.util.HashMap;

public class StringCompression_443 {
    public int compress(char[] chars) {
        int ans = 0;

        for (int i = 0; i < chars.length; ) {
            final char letter = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }

            chars[ans++] = letter;

            if (count > 1) {
                for (final char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }

        return ans;
    }
}
