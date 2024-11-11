package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var pq  = new PriorityQueue<Pair>((a, b) -> {
            if(nums1[a.x] + nums2[a.y] == nums1[b.x] + nums2[b.y]) {
                return nums1[a.x] - nums1[b.x];
            }
            return (nums1[a.x] + nums2[a.y]) - (nums1[b.x] + nums2[b.y]);
        });
        pq.add(new Pair(0, 0));
        var set = new java.util.HashSet<Pair>();

        var answer = new ArrayList<List<Integer>>();
        while(k-- > 0 && !pq.isEmpty()) {
            var p = pq.poll();
            answer.add(List.of(nums1[p.x], nums2[p.y]));
            if(p.x + 1 < nums1.length) {
                var pr = new Pair(p.x + 1, p.y);
                if(!set.contains(pr)) {
                    pq.add(new Pair(p.x + 1, p.y));
                    set.add(pr);
                }
            }
            if(p.y + 1 < nums2.length) {
                var pr = new Pair(p.x, p.y+1);
                if(!set.contains(pr)) {
                    pq.add(new Pair(p.x, p.y + 1));
                    set.add(pr);
                }
            }
        }
        return answer;
    }

    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
