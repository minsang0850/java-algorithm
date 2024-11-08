package leetcode;

public class FindTheHighestAltitude_1732 {
    public int largestAltitude(int[] gain) {
        var altitude = 0;
        var maxAltitude = 0;
        for (int j : gain) {
            altitude += j;
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }

}
