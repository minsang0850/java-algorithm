package programmers.kakao2023blind;

public class 택배_배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        var prev=deliveries.length-1;
        while (true) {
            var minMove = getMinMove(deliveries, pickups, prev);
            prev=minMove;
            if (minMove == -1) {
                break;
            }
            var zim = cap;
            for (int i = minMove; i >= 0; i--) {
                if(zim==0) {
                    break;
                }
                if(deliveries[i]>zim) {
                    deliveries[i]-=zim;
                    zim=0;
                } else {
                    zim-=deliveries[i];
                    deliveries[i]=0;
                }
            }
            zim = cap;
            for (int i = minMove; i >= 0; i--) {
                if(zim==0) {
                    break;
                }
                if(pickups[i]>zim) {
                    pickups[i]-=zim;
                    zim=0;
                } else {
                    zim-=pickups[i];
                    pickups[i]=0;
                }
            }
            answer+=(minMove+1)*2;
        }
        return answer;
    }

    private int getMinMove(int[] deliveries, int[] pickups, int prev) {
        for (int i = prev; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                return i;
            }
        }
        return -1;
    }
}
