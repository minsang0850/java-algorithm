package leetcode;

public class FindIndexOfFirstOccurrenceInString_28 {
    public int strStr(String haystack, String needle) {
        var needleSize = needle.length();
        for (int i = 0; i < haystack.length() - needleSize + 1; i++) {
            if (haystack.substring(i, i + needleSize).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
