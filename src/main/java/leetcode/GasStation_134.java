package leetcode;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var costSum  = 0;
        var gasSum = 0;
        var index = 0;
        for (int i=0; i<cost.length; i++) {
            var diff = gas[i] - cost[i];
            costSum+= diff;
            gasSum+= diff;
            if(gasSum < 0) {
                gasSum = 0;
                index = i+1;
            }
        }
        if(costSum < 0) {
            return -1;
        }
        return index;
    }
}
