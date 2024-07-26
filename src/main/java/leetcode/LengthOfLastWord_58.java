package leetcode;

public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        var result = 0;
        var splitted = s.split(" ");
        if(splitted.length == 0) {
            return result;
        }
        return splitted[splitted.length-1].length();
    }
}
