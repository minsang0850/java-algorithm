package programmers.introduction;

public class 옹알이 {
    public static void main(String[] args) {
        var problem = new 옹알이();
        problem.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"});
    }
    public int solution(String[] babbling) {
        int answer = 0;
        for (String babble : babbling){
            if(solution(babble)){
                answer++;
            }
        }
        return answer;
    }

    public boolean solution(String babbling) {
        var charArray = babbling.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                return false;
            }
            if (i == charArray.length - 2) {
                if ((charArray[i] == 'y' && charArray[i + 1] == 'e')
                        || (charArray[i] == 'm' && charArray[i + 1] == 'a')) {
                    return true;
                }
                return false;
            }
            if (charArray[i] == 'y' && charArray[i + 1] == 'e') {
                i+=1;
            }
            else if (charArray[i] == 'm' && charArray[i + 1] == 'a') {
                i+=1;
            }
            else if (charArray[i] == 'a' && charArray[i + 1] == 'y' && charArray[i + 2] == 'a') {
                i+=2;
            }
            else if (charArray[i] == 'w' && charArray[i + 1] == 'o' && charArray[i + 2] == 'o') {
                i+=2;
            } else{
                return false;
            }
        }
        return true;
    }
}
