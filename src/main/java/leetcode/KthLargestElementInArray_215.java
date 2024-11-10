package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        k=nums.length-k+1;
        var answer = 0;
        for (int i=0; i<k; i++) {
            answer=pq.poll();
        }
        return answer;
    }
}
