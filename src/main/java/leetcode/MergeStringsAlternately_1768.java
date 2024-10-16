package leetcode;

public class MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        var sb = new StringBuilder();
        var firstIdx = 0;
        var secondIdx = 0;
        while (firstIdx < word1.length() && secondIdx < word2.length()) {
            sb.append(word1.charAt(firstIdx++));
            sb.append(word2.charAt(secondIdx++));
        }
        return sb.append(word1.substring(firstIdx)).append(word2.substring(secondIdx)).toString();
    }
}
