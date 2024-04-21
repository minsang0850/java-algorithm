package programmers.algorithm.stackqueue;

public class 다리를_지나는_트럭 {

    public static void main(String[] args) {
        var p = new 다리를_지나는_트럭();
        p.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    }
    public int solution(int bridge_length, int weightLimit, int[] truck_weights) {
        int time = 0;
        int waitingIdx = 0;
        int currentWeight = 0;
        int frontTruckIdx = 0;
        Truck[] trucks = new Truck[truck_weights.length];
        for(int i=0; i<truck_weights.length; i++) {
            var truck = new Truck(0, truck_weights[i]);
            trucks[i]=truck;
        }
        while (true) {
            time++;
            incrementPosition(trucks, frontTruckIdx, waitingIdx);
            if(trucks[frontTruckIdx].position>bridge_length) {
                currentWeight-=trucks[frontTruckIdx].weight;
                frontTruckIdx++;
                if(frontTruckIdx==trucks.length){
                    break;
                }
            }
            if(waitingIdx<trucks.length && currentWeight + trucks[waitingIdx].weight <= weightLimit) {
                currentWeight += trucks[waitingIdx].weight;
                trucks[waitingIdx].position=1;
                waitingIdx++;
            }
        }
        return time;
    }

    private void incrementPosition(Truck[] trucks, int frontTruckIdx, int waitingIdx) {
        for(int i=frontTruckIdx; i<waitingIdx; i++) {
            trucks[i].position++;
        }
    }

    class Truck {
        int position;
        int weight;

        Truck(int current, int weight){
            this.position = current;
            this.weight = weight;
        }
    }
}
