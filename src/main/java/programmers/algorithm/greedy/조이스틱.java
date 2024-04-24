package programmers.algorithm.greedy;

public class 조이스틱 {
    public static void main(String[] args) {
        var p = new 조이스틱();
        p.solution("JEROEN");
    }

    public int solution(String name) {
        int answer = 0;
        for (char alphabet : name.toCharArray()) {
            var currentPos = 'A';
            var diff = alphabet > currentPos
                       ? alphabet - currentPos
                       : currentPos - alphabet;
            answer += Math.min(diff, 26 - diff);
        }
        var only_right = name.length()-1;
        var only_left = name.length()-1;
        for(int i=name.length()-1; i>0; i--){
            if(name.charAt(i)=='A'){
                only_right--;
            } else {
                break;
            }
        }

        for(int i=1; i<name.length(); i++){
            if(name.charAt(i)=='A'){
                only_left--;
            } else {
                break;
            }
        }
        var len = 0;
        var start = 0;
        var currentLen = 0;
        var currentStart = 0;
        for (int i=1; i<name.length(); i++) {
            if(name.charAt(i)=='A') {
                if(currentLen==0){
                    currentStart=i;
                }
                currentLen++;
            }
            else {
                if(len<currentLen){
                    len = currentLen;
                    start = currentStart;
                }
                currentLen=0;
            }
        }
        if(len==0) {
            return answer+Math.min(only_left, only_right) ;
        }
        var asdf = start -1 + start-1 + name.length()-(start+len);
        var abccxz = name.length()-(start+len) + name.length()-(start+len) + start-1;
        answer += Math.min(Math.min(asdf, abccxz), Math.min(only_left, only_right));
        return answer;
    }
}
