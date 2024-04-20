package programmers.introduction;

public class 캐릭터의좌표 {

    public static void main(String[] args) {
        var solution = new 캐릭터의좌표();
        solution.solution(new String[]{"down", "down", "down", "down", "down"}, new int[]{7,9});
    }

    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        init(board);
        for (int i = 0; i < keyinput.length; i++) {
            String key = keyinput[i];
            Key.move(answer, key);
        }
        return answer;
    }

    static int leftLimit;
    static int rightLimit;
    static int downLimit;
    static int upLimit;

    enum Key {
        UP("up", new int[]{0, 1}),
        DOWN("down", new int[]{0, -1}),
        LEFT("left",new int[]{-1, 0}),
        RIGHT("right", new int[]{1, 0});

        private final String keyInput;
        private final int[] directions;

        Key(String keyInput, int[] directions) {
            this.keyInput = keyInput;
            this.directions = directions;
        }

        static Key find(String keyString) {
            for(Key key : Key.values()) {
                if(key.keyInput.equals(keyString)) {
                    return key;
                }
            }
            return null;
        }

        static void move(int[] answer, String keyString) {
            var key = find(keyString);
            answer[0] += key.directions[0];
            answer[1] += key.directions[1];
            if(proceedLimit(answer)){
                answer[0] -= key.directions[0];
                answer[1] -= key.directions[1];
            }
        }

        static boolean proceedLimit(int[] answer) {
            if(answer[0]<leftLimit){
                return true;
            }
            if(answer[0]>rightLimit){
                return true;
            }
            if(answer[1]>upLimit){
                return true;
            }
            if(answer[1]<downLimit){
                return true;
            }
            return false;
        }
    }

    void init(int[] board) {
        leftLimit = -1 * (board[0] - 1) / 2;
        rightLimit = (board[0] - 1) / 2;
        downLimit = -1 * (board[1] - 1) / 2;
        upLimit = (board[1] - 1) / 2;
    }
}
