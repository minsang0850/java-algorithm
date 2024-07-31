package leetcode;

public class ReverseWordsInString_151 {
    public String reverseWords(String s) {
        var splitted = s.split(" ");
        var result = new StringBuilder();
        for (int i = splitted.length - 1; i >= 0; i--) {
            if (!splitted[i].isBlank()) {
                result.append(splitted[i]).append(" ");
            }
        }
        return result.toString().trim();
    }
}
