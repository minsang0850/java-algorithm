package leetcode;

public class MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        var sb = new StringBuilder();
        var i = 0;
        var j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        return sb.append(word1.substring(i)).append(word2.substring(j)).toString();
    }
}
