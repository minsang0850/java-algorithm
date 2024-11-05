package leetcode;

public class MaximumNumberOfVowelsInSubstringOfGivenLength_1456 {
    public int maxVowels(String s, int k) {
        var vowels = "aeiou";

        var count=0;
        for (int i=0; i<k; i++) {
            if (vowels.contains(s.charAt(i) + "")) {
                count++;
            }
        }
        var answer = count;

        for (int i=k; i<s.length(); i++) {
            if (vowels.contains(s.charAt(i) + "")) {
                count++;
            }
            if (vowels.contains(s.charAt(i-k) + "")) {
                count--;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
